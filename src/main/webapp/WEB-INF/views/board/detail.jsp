<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
    <div class="container">
        <table class="table">
            <tr>
                <th>글 번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성시간</th>
            </tr>
            <tr>
                <td>${boardList.id}</td>
                <td>${boardList.boardTitle}</td>
                <td>${boardList.boardWriter}</td>
                <td>${boardList.boardHits}</td>
                <td>${boardList.boardCreatedDate}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="4">
                    ${boardList.boardContents}
                </td>
            </tr>
        </table>
        <div><a href="/">index로 이동</a></div>
    </div>
</body>
</html>
