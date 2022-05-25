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
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="/resources/jquery/jquery.js"></script>
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
                <th>이미지</th>
                <th>페이징목록</th>
            </tr>
            <tr>
                <td>${boardList.id}</td>
                <td>${boardList.boardTitle}</td>
                <td>${boardList.boardWriter}</td>
                <td>${boardList.boardHits}</td>
                <td>${boardList.boardCreatedDate}</td>
                <th><img src="${pageContext.request.contextPath}/upload/${boardList.boardFileName}" alt="" height="100" width="100"></th>
                <td><a href="/board/paging?page=${page}">페이징목록</a></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="5">
                    ${boardList.boardContents}
                </td>
            </tr>
        </table>
    </div>
    <div class="container">
        <div id="comment-write" class="input-group mb-3">
            <input type="text" id="commentWriter" class="form-control" placeholder="작성자">
            <input type="text" id="commentContents" class="form-control" placeholder="내용">
            <button id="comment-write-btn" class="btn btn-primary">댓글작성</button>
        </div>

        <div id="comment-list">
            <table class="table">
                <tr>
                    <th>댓글번호</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>작성시간</th>
                </tr>
                <c:forEach items="${commentList}" var="comment">
                    <tr>
                        <td>${comment.id}</td>
                        <td>${comment.commentWriter}</td>
                        <td>${comment.commentContents}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${comment.commentCreatedDate}"></fmt:formatDate></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
<script>
    $("#comment-write-btn").click(function (){
        //댓글 작성자 내용 가져오고 ajax 문법활용 /comment/save주소로 posot 방식으로 작성자 내용 ㄱ글번호 보내기
        const boardId = '${boardList.id}'; // 글번호
        const commentWriter = document.getElementById("commentWriter").value;
        const commentContents = $("#commentContents").val(); // 제이쿼리 문법
        // const commentContents = document.getElementById("commentContents").value;

        $.ajax({
            type:"post",
            url: "/comment/save",
            data:{"boardId":boardId,"commentWriter":commentWriter,"commentContents":commentContents},
            dataType:"json",
            success:function (result){
                console.log(result);
                let output = "<table class='table'>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in result){
                    output += "<tr>";
                    output += "<td>"+result[i].id+"</td>";
                    output += "<td>"+result[i].commentWriter+"</td>";
                    output += "<td>"+result[i].commentContents+"</td>";
                    output += "<td>"+moment(result[i].commentCreatedDate).format("YYYY-MM-DD HH:mm:ss")+"</td>";
                    output += "</tr>";
                }
                output += "</table>";
                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';

            },
            error:function (){
                alert("이거뜨면 큰일난다");
            }
        })
    });
</script>
</html>
