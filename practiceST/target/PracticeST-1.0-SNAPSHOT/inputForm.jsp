<%--
  Created by IntelliJ IDEA.
  User: alcuz
  Date: 28.06.2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ResponsePost" method="post">
    Введите сообщение: <input type="text" name="messege"><br>
    <button>Отправить</button>>
</form>
</body>
</html>
