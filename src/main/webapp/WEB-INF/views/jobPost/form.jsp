<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용 공고 작성</title>
</head>
<body>
	<h1>채용 공고 작성</h1>

	<form:form action="/jobPost/create" method="post"
		modelAttribute="jobPost">
		<div>
			<label for="compId">회사Id</label>
			<form:input path="compId" required="required" />
		</div>
		<div>
			<label for="title">제목:</label>
			<form:input path="title" required="required" />
		</div>
		<div>
			<label for="content">내용:</label>
			<form:textarea path="content" required="required" />
		</div>
		<div>
			<label for="position">직위:</label>
			<form:input path="position" />
		</div>
		<div>
			<label for="salary">연봉:</label>
			<form:input path="salary" />
		</div>
		<div>
			<label for="experience">경력:</label>
			<form:input path="experience" />
		</div>
		<div>
			<label for="education">학력:</label>
			<form:input path="education" />
		</div>
		<div>
			<label for="address">주소:</label>
			<form:input path="address" />
		</div>
		<div>
			<label for="homePage">홈페이지:</label>
			<form:input path="homePage" />
		</div>
		<div>
			<label for="endDate">마감일:</label> <input type="date" name="endDate"
				id="endDate" value="${jobPost.endDate}">
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form:form>

	<a href="/jobPost/list">목록으로 돌아가기</a>
</body>
</html>