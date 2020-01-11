<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <label for="username"/>User name<input type="text" name="userName" id="username" placeholder="Type username" value="${user.username}"/><br/>
    <label for="password"/>Password<input type="password" name="password" id="password" placeholder="Type password" value="${user.password}"/><br/>
    <label for="firstName"/>First name<input type="text" name="firstName" id="firstName" placeholder="Type firstName" value="${user.firstName}"/><br/>
    <label for="lastName"/>Last name<input type="text" name="lastName" id="lastName" placeholder="Type lastName" value="${user.lastName}"/><br/>

    <input type="submit" name="Register">
</form>
<c:if test="${error != null}">
    <p>User registered try different username</p>
</c:if>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
