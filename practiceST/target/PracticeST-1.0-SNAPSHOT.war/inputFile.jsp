<%--
  Created by IntelliJ IDEA.
  User: alcuz
  Date: 28.06.2021
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправка файла Jsp</title>
</head>
<body>
<h1><%= "Отправка файла" %></h1>>
<form method="post" action="InputFile" enctype="multipart/form-data">
    <input type="file" name="fileName" >
    <button>Отпарвить</button>>
</form>
</body>
</html>
