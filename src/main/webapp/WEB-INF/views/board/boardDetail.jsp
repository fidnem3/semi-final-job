<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- now : 현재 시간의 시분초를 now 변수에 세팅 --%>
<c:set var="now" value="<%= new java.util.Date() %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css' />?v=${now}" />
</head>
<body>
    <c:if test="${not empty message}">
        <script>
            alert('${message}');
        </script>
    </c:if>
	<div class="container">
		<%-- 헤더부분 include 액션 태그 사용, c:url 사용금지, 경로 직접 지정해야함. --%>
		<jsp:include page="/resources/common/header.jsp" />
        <main>
			<table border="1">
				<tr>
					<th>게시물번호</th>
					<td><c:out value="${boardVo.bno }"/></td>
				</tr>
				<tr>	
					<th>제목</th>
					<td><c:out value="${boardVo.title }" /></td>
				</tr>
				<tr>	
					<th>내용</th>
					<td>${boardVo.content }</td>
				</tr>
				<tr>		
					<th>작성자</th>
					<td><c:out value="${boardVo.memberId }" /></td>
				</tr>
				<tr>		
					<th>작성일자</th>
					<td><fmt:formatDate value="${boardVo.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>		
					<th>조회수</th>
					<td><c:out value="${boardVo.hitNo }"/></td>
				</tr>
				<c:if test="${not empty boardVo.fileName}">
					<tr>
						<th>첨부 파일</th>
						<td>
							<img src="<c:url value='/upload/${boardVo.fileName}'/>" alt="첨부 이미지">
							<br>
							<a href="<c:url value='/upload/${boardVo.fileName}'/>" download="${boardVo.fileName}">다운로드</a>
						</td>
					</tr>
				</c:if>				
			</table>
			<br>
			<a href="<c:url value='/board/list'/>">목록</a>
			<a href="<c:url value='/board/update'/>?bno=${boardVo.bno}">수정</a>
			<form action="<c:url value='/board/delete'/>" method="post">
				<input type="hidden" name="bno" value="${boardVo.bno}" >
				<input type="submit" value="삭제" onclick="return confirm('정말 삭제하시겠습니까?');">
			</form>
			<a href="<c:url value='/reply'/>?bno=${boardVo.bno}">답글작성</a>
		</main>
	</div>	
</body>
</html>	
