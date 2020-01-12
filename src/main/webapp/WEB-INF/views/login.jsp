<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-11
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
<h1>Login</h1>
<form method="post" action="/login">
    <label for="username"/>Username<input type="text" id="username" name="username" value="${user.username}"/>
    <label for="password"/>Password<input type="password" id="password" name="password"/>

    <input type="submit" name="Login">
</form>
<c:if test="${loginError != null}">
    <p>Login or password is not correct</p>
</c:if>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
