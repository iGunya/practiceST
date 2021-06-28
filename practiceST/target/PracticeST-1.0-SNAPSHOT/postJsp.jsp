<%--
  Created by IntelliJ IDEA.
  User: alcuz
  Date: 28.06.2021
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input JSP</title>
</head>
<body>
<h1><%= "Input form" %></h1>
<br/>
<form method="post" action="${pageContext.request.contextPath}/PostExample">
    <input type="text" name="name">
    <input type="text" name="price">
    <button type="submit">Аdd to shopping cart</button>>
</body>
</html>
