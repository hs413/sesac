<%--
  Created by IntelliJ IDEA.
  User: D
  Date: 2024-06-18
  Time: 오후 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Page</h1>
<%--${list}--%>
<%--<h1>JSP - EL</h1>--%>
<%--${list[0].tno} --- ${list[0].title}--%>

<%--<h4>${list[0].title}</h4>--%>
<%--<h4>${list[0].getTitle()}</h4>--%>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach>
</ul>

<c:if test="${list.size() % 2 == 0}">
    짝수
</c:if>
<c:if test="${list.size() % 2 == 0}">
    홀수
</c:if>
</body>
</html>
