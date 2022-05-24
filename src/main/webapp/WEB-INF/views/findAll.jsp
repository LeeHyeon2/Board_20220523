<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<html>
<head>
    <script src="/resources/js/jquery.js"></script>
    <style>
        input{
            display: block;
        }
    </style>
    <title>Title</title>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container">
    <table class="table">
        <tr>
            <th>id</th>
            <th>글 제목</th>
            <th>조회 수</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
        <tr>
            <td><a href="/detail?id=${board.id}">${board.id}</a></td>
            <td>${board.boardTitle}</td>
            <td>${board.boardHits}</td>
            <td><a href="/update?id=${board.id}">수정</a></td>
            <td><a href="/delete?id=${board.id}">삭제</a></td>
        </tr>
        </c:forEach>
    </table>
    <a href="/index">index로 이동</a>
</div>
</body>
</html>
