package com.github.hirethem.action.interceptor;

import com.github.hirethem.model.entity.User;
import com.github.hirethem.model.service.CurrentUserService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

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
            if (!user.isAdmin() && annotation.admin()) {
                return "loginRedirect";
            }
            if (StringUtils.equals(annotation.userType(), "")) {
                return invocation.invoke();
            }
            if (!StringUtils.equals(annotation.userType(), user.getUserType().name())) {
                return "loginRedirect";
            }
            return invocation.invoke();
        }
    }
}
