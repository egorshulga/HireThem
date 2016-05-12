package com.github.hirethem.action.admin.users;

import com.github.hirethem.action.authentication.SigninAction;
import com.github.hirethem.action.interceptor.AuthorizeAs;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class CreateUserAdminPanelAction extends SigninAction {

}
