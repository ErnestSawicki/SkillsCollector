<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-12
  Time: 12:06
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
<h1>User skills</h1>
<table>
    <tr>
        <td>Order number</td>
        <td>Skill name</td>
        <td>Skill value</td>
    </tr>
    <%
        int count = 0;
    %>
    <c:forEach items="${skills}" var="skill">
        <tr>
            <td><%=++count %></td>
            <td>${skill.key}</td>
            <td>${skill.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
