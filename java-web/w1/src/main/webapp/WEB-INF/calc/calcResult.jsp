<%--
  Created by IntelliJ IDEA.
  User: D
  Date: 2024-06-05
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- EL: 데이터를 출력하기 위한 문법 --%>
    <h1>NUM1 ${param.num1}</h1>
    <h1>NUM2 ${param.num2}</h1>

    <%-- 전달되는 데이터는 문자열로 처리됨 --%>
    <h1>SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
