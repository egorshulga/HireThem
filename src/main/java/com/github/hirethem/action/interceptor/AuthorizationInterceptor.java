package com.github.hirethem.action.interceptor;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

import javax.security.sasl.AuthenticationException;

/**
 * Created by egorshulga.
 */
public class AuthorizationInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(final ActionInvocation invocation) throws Exception {

        Object action = invocation.getAction();
        Class actionClass = action.getClass();
        AuthorizeAs annotation = (AuthorizeAs) actionClass.getAnnotation(AuthorizeAs.class);

        if (annotation == null) {
            return invocation.invoke();
        } else {
            CurrentUserService service = new CurrentUserService();
            User user = service.getCurrentUserEntity();
            if (user.isAdmin()) {
                return invocation.invoke();
            }
            if (!user.isAdmin() && annotation.forAdmin()) {
                throw new AuthenticationException("User is not an admin");
            }
            if (StringUtils.equals(annotation.userType(), "")) {
                invocation.invoke();
            }
            if (!StringUtils.equals(annotation.userType(), user.getUserType().name())) {
                throw new AuthenticationException("The action is unavailable for users of this type");
            }
            return invocation.invoke();
        }
    }
}
