<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
<form action="/register" method="post">
    <label for="username"/>User name<input type="text" id="username" placeholder="Type username"/><br/>
    <label for="password"/>Password<input type="text" id="password" placeholder="Type password"/><br/>
    <label for="firstName"/>First name<input type="text" id="firstName" placeholder="Type firstName"/><br/>
    <label for="lastName"/>Last name<input type="text" id="lastName" placeholder="Type lastName"/><br/>
    <input type="submit" name="Register">
</form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
