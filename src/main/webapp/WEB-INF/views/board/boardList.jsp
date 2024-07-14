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
<%-- css 자원요청 문자열에 시시각각 변하는 시간을 파라미터로 전달하기 때문에 서브는 매번 새로운 요청으로 착각, 
	늘 css 읽어온다. 캐싱안함. --%>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board.css' />?v=${now}" />
</head>
<body>
    <div class="container">
 		<%-- 헤더부분 include 액션 태그 사용, c:url 사용금지, 경로 직접 지정해야함. --%>
		<jsp:include page="/resources/common/header.jsp" />
        <main>
        	<h3>게시물 목록</h3>
        	<form action="<c:url value='/boardList'/>" method="get" class="search-form" >
        		<input type="text" name="keyword" placeholder="검색어 입력" />
        		<input type="submit" value="검색" />
        	</form>
        	
        	<c:if test="${empty boardList}">
                <p>게시물이 존재하지 않습니다.</p>
            </c:if>
            
            <c:if test="${not empty boardList}">
				<table border="1">
					<caption>게시판 목록</caption>
					<colgroup>
						<col width="100" />
						<col width="500" />
						<col width="80" />
						<col width="200" />
						<col width="80" />
						<col width="100" />
						<col width="100" />
						<col width="100" />
					</colgroup>
					<thead>
						<tr>
							<th>게시물</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>조회수</th>
							<th>그룹</th>
							<th>그룹내정렬순서</th>
							<th>들여쓰기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${boardList }" varStatus="idx">
							<tr>
								<td><c:out value="${idx.count }"/></td>
								<td>
									<c:if test="${board.replyIndent > 0 }">
										<c:forEach begin="1" end="${board.replyIndent}">
											&nbsp;&nbsp;
										</c:forEach>
										<img src="<c:url value='/image/reply_icon.gif'/>" />
									</c:if>
									<a href="<c:url value='/board/detail'/>?bno=${board.bno}">
										<c:out value="${board.title }"/>
									</a>									
								</td>
								<td><c:out value="${board.memberId }"/></td>
								<td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><c:out value="${board.hitNo }"/></td>
								
								<td><c:out value="${board.replyGroup }"/></td>
								<td><c:out value="${board.replyOrder }"/></td>
								<td><c:out value="${board.replyIndent }"/></td>

							</tr>		
						</c:forEach>
						<tr>
							<td align="center" colspan="8">${page_navigator}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td align="center" colspan="8">Copyright javalab Corp.ltd All Rights Reserved</td>
						</tr>
					</tfoot>
				</table>
			</c:if>
			<br>
			<a href="<c:url value='/board/create'/>">게시물 작성</a>
		</main>
	</div>
</body>
</html>	
