<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-12
  Time: 13:09
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
<table border="true">
    <tr>
        <th>Order number</th>
        <th>Source name</th>
        <th>Source description</th>
        <th>Source skills</th>
    </tr>
    <%
        int count = 0;
    %>
    <c:forEach items="${sources}" var="source">
        <tr>
            <td><%=++count%></td>
            <td>${source.name}</td>
            <td>${source.description}</td>
            <td>
                <c:forEach items="${source.skills}" var="skills">
                ${skills.name},
            </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
