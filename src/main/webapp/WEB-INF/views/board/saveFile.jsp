<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2>글 작성</h2>
        <form action="/board/saveFile" method="post" enctype="multipart/form-data">
            <input class="form-control mb-2" type="text" name="boardTitle" placeholder="제목">
            <input class="form-control mb-2" type="text" name="boardWriter" placeholder="작성자">
            <input class="form-control mb-2" type="text" name="boardPassword" placeholder="비밀번호">
            <textarea class="form-control mb-2" name="boardContents" rows="5" cols="10" placeholder="내용"></textarea>
            첨부파일: <input type="file" name="boardFile">
            <input class="btn btn-primary"  type="submit" value="제출">
        </form>
    </div>
</body>
</html>
