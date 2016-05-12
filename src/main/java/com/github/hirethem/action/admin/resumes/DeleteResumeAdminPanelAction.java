package com.github.hirethem.action.admin.resumes;

import com.github.hirethem.action.interceptor.AuthorizeAs;
import com.github.hirethem.action.resumes.DeleteResumeAction;

/**
 * Created by egorshulga on 12-May-16.
 */
@AuthorizeAs(admin = true)
public class DeleteResumeAdminPanelAction extends DeleteResumeAction {
}
