<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input JSP</title>
</head>
<body>
<h1><%= "Возможные endpoint" %>
</h1>
<br/>
<p> Форма для отправки post запроса</p>
<a href="${pageContext.request.contextPath}/post-example">/post-example </a>

<p> Отпправка файла </p>
<a href="${pageContext.request.contextPath}/input-file">/input-example</a>

</body>
</html>