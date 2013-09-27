<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring-javaconfig-example</title>
</head>
<body>
<h2>Welcome on secure page!</h2>

<h3>Username: ${userLogin.username}</h3>

<h3>Password: ${userLogin.password}</h3>

<a href="secure/logout">logout</a>
</body>
</html>