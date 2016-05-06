package com.github.hirethem.action.interceptor;

import com.github.hirethem.action.LoginAction;
import com.github.hirethem.model.service.LoginService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by egorshulga.
 */
public class AuthorizationInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(final ActionInvocation invocation) throws Exception {

        if (new LoginService().isUserAuthenticated()) {
            return invocation.invoke();
        }

        Object action = invocation.getAction();

        // sb: if the action doesn't require sign-in, then let it through.
        if (!(action instanceof AuthorizationRequired)) {
            return invocation.invoke();
        }

        // sb: if this request does require login and the current action is
        // not the login action, then redirect the user
        if (!(action instanceof LoginAction)) {
            return "loginRedirect";
        }

        // sb: they either requested the login page or are submitting their
        // login now, let it through
        return invocation.invoke();
    }
}
