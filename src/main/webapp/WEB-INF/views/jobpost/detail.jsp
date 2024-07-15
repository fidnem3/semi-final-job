<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="job-detail-container">
		<h1>${jobPost.title}</h1>
		<p>
			<strong>회사:</strong> ${jobPost.compId}
		</p>
		<p>
			<strong>내용:</strong> ${jobPost.content}
		</p>
		<p>
			<strong>직위:</strong> ${jobPost.position}
		</p>
		<p>
			<strong>연봉:</strong> ${jobPost.salary}
		</p>
		<p>
			<strong>경력:</strong> ${jobPost.experience}
		</p>
		<p>	
			<strong>학력:</strong> ${jobPost.education}
		</p>
		<p>
			<strong>주소:</strong> ${jobPost.address}
		</p>
		<p>
			<strong>마감일:</strong> ${jobPost.endDate}
		</p>
		<p>
			<strong>조회수:</strong> ${jobPost.hitNO}
		</p>

		<button onclick="window.close()">창 닫기</button>
	</div>
</body>
</html>