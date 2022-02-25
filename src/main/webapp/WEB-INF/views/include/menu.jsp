<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="${path}/board/list.do">게시판</a>
<c:choose>
	<c:when test="${sessionScope.userId == null}">
		<a href="${path}/member/login.do">LOGIN</a>
	</c:when>
	<c:otherwise>
		${sessionScope.userName}님이 로그인 중입니다.
		<a href="${path}/member/logout.do">LOGOUT</a>
	</c:otherwise>
</c:choose>