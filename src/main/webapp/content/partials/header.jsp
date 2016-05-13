<%--
  User: egorshulga
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Navigation bar -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">

        <!-- Logo -->
        <div class="pull-left">
            <a class="navbar-toggle" href="#" data-toggle="offcanvas"><i class="ti-menu"></i></a>

            <div class="logo-wrapper">
                <a class="logo" href="/"><img src="../assets/img/logo.png" alt="logo"></a>
            </div>

        </div>
        <!-- END Logo -->

        <!-- User account -->
        <div class="pull-right user-login">
            <a class="btn btn-sm btn-primary" href="<s:url action="login"/>">Login</a> or <a
                href="<s:url action="signin"/>">register</a>
        </div>
        <!-- END User account -->

        <!-- Navigation menu -->
        <ul id="nav-menu-id" class="nav-menu">
            <li>
                <a href="/">Home</a>
            </li>
            <li>
                <a href="#">Profile</a>
                <ul>
                    <li><a href="profile">My profile</a></li>
                    <li><a href="editProfile">Edit profile</a></li>
                    <li><a href="logout">Log out</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Resume</a>
                <ul>
                    <li><a href="content/resume-list.jsp">Browse resumes</a></li>
                    <li><a href="manageResumes">Manage resumes</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Vacancy</a>
                <ul>
                    <li><a href="content/vacancy-list.jsp">Browse vacancies</a></li>
                    <li><a href="content/vacancy-manage.jsp">Manage vacancies</a></li>
                </ul>
            </li>
            <li>
                <a href="#">Pages</a>
                <ul>
                    <li><a href="about">About</a></li>
                    <li><a href="contact">Contact</a></li>
                    <li><a href="faq">FAQ</a></li>
                </ul>
            </li>
            <li>
                <a href="content/admin.jsp">Admin</a>
            </li>
        </ul>
        <!-- END Navigation menu -->

    </div>
</nav>
<!-- END Navigation bar -->