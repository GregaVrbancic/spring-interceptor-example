<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring-javaconfig-example</title>
</head>
<body>
<h2>Login:</h2>
<form:form method="post" commandName="userLogin">
    <form:label path="username">Username:</form:label>
    <form:input type="text" path="username"/><br/>
    <form:label path="password">Password:</form:label>
    <form:input type="password" path="password"/><br/>
    <form:button type="submit">login</form:button>
</form:form>
</body>
</html>