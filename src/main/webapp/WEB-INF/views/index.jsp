<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오전 10:03
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
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
    <div class="container">
        <div class="form-control">index.jsp</div>
        <button class="btn btn-primary" onclick="save()">글 작성</button>
        <button class="btn btn-primary" onclick="saveFile()">글 작성(파일)</button>
        <button class="btn btn-primary" onclick="findAll()">글 목록</button>
    </div>
    <!-- 회원가입 : /member-save => /member/save , 글쓰기 : /board-save => /board/save -->
</body>
<script>
    const save = () => {
        location.href = "/save"
    }
    const findAll = () => {
        location.href = "/findAll"
    }
    const saveFile = () => {
        location.href = "/board/saveFile";
    }
</script>
</html>
