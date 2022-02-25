<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
 <%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			// 태그.val() : 태그에 입력된 값
			// 태그.val("값") : 태그의 값을 변경
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			if (userId == "") {
				alert("ID를 입력하세요");
				$("#userId").focus();	// 입력 포커스 이동
				return;
			}
			if (userPw == "") {
				alert("Password를 입력하세요");
				$("#userPw").focus();	// 입력 포커스 이동
				return;
			}
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action = "${path}/member/loginCheck.do";
			// 제출
			document.form1.submit();
		});
	});
</script>
</head>
<body>
<h2>로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>ID</td>
				<td><input name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">LOGIN</button>
					<c:if test="${msg == 'failure'}">
						<div style="color: red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
					</c:if>
					<c:if test="${msg == 'logout'}">
						<div style="color: red">로그아웃 되었습니다.</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>