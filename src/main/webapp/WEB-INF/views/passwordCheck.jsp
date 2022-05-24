<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-23
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
    <h2>passwordCheck.jsp</h2>
    <form action="${Link}" method="post" name="loginForm">
        <input type="password" name="boardPassword" id="password" placeholder="비밀번호 입력.">
        <input class="btn btn-primary" type="button" onclick="login()" value="전송">
    </form>

</body>
<script>
    const login = () => {
        const pwCheck = document.getElementById("password").value;
        const pwDB = '${boardDTO.boardPassword}';
        if(pwCheck == pwDB){
            loginForm.submit();
        }else{
            alert("비밀번호가 틀립니다.")
        }
    }
</script>
</html>
