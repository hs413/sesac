<%--
  Created by IntelliJ IDEA.
  User: D
  Date: 2024-06-27
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div>
        <input type="text" name="title" placeholder="INSERT TITME">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <div>
        <button type="reset">RESET</button>
        <button type="submit">REGISTER</button>
    </div>
</form>
</body>
</html>
