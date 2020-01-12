<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-12
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
<table>
    <tr>
        <th>Order number</th>
        <th>Source name</th>
        <th>Source description</th>
        <th>Source skills</th>
        <th>Confirmation</th>>
    </tr>
    <%
        int count = 0;
    %>
    <c:forEach items="${sourcesUnknown}" var="sourcesUnknown">
        <tr>
            <td><%=++count%></td>
            <td>${sourcesUnknown.name}</td>
            <td>${sourcesUnknown.description}</td>
            <td>
                <c:forEach items="${sourcesUnknown.skills}" var="skills">
                    ${skills.name},
                </c:forEach>
            </td>
            <td><a href="/sources/confirm?sourceId=${sourcesUnknown.id}">Confirm knowledge</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
