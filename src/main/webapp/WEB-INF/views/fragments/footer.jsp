<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020-01-11
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Footer</title>
</head>
<body>

<p>Author: <b>Ernest Sawicki @</b>
    <% out.println(LocalDate.now().toString());
    %>
</p>

</body>
</html>
