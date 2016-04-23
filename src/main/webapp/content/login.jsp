<%--
  User: egors
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>HireThem</title>
</head>
<body>

<h1>Login to HireThem</h1>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>

<s:form action="submitLogin" method="post">
    <s:textfield name="email" label="Email "/>
    <s:password label="Password " name="password"/>
    <s:radio label="Login as " name="userType" value="defaultUserType" list="userTypes"/>
    <s:submit type="button" label="Login "/>
</s:form>            
</body>              
</html>
