<%--
  Created by IntelliJ IDEA.
  User: D
  Date: 2024-06-07
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>
<form action="/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
    <button type="submit">LOGIN</button>
</form>
</body>
</html>
