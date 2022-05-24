<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오후 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
    <h2>수정할 내용 입력</h2>
    <form action="/update/request?id=${boardDTO.id}" method="post">
        <input type="text" name="boardTitle" value="${boardDTO.boardTitle}">
        <textarea class="form-control" name="boardContents" rows="5" cols="10">${boardDTO.boardContents}</textarea>
        <input class="btn btn-primary" type="submit" value="제출">
    </form>
</body>
</html>
