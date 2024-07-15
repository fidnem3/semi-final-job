<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>채용 공고 ${empty jobPost.jobPostId ? '작성' : '수정'}</h1>
    <form action="${empty jobPost.jobPostId ? '/jobpost/create' : '/jobpost/update'}" method="post">
        <c:if test="${not empty jobPost.jobPostId}">
            <input type="hidden" name="jobPostId" value="${jobPost.jobPostId}">
        </c:if>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${jobPost.title}" required><br>
        
        <label for="content">내용:</label>
        <textarea id="content" name="content" required>${jobPost.content}</textarea><br>
        
        <label for="position">직위:</label>
        <input type="text" id="position" name="position" value="${jobPost.position}"><br>
        
        <label for="salary">연봉:</label>
        <input type="text" id="salary" name="salary" value="${jobPost.salary}"><br>
        
        <label for="experience">경력:</label>
        <input type="text" id="experience" name="experience" value="${jobPost.experience}"><br>
        
        <label for="education">학력:</label>
        <input type="text" id="education" name="education" value="${jobPost.education}"><br>
        
        <label for="address">주소:</label>
        <input type="text" id="address" name="address" value="${jobPost.address}"><br>
        
        <label for="endDate">마감일:</label>
        <input type="date" id="endDate" name="endDate" value="${jobPost.endDate}"><br>
        
        <input type="submit" value="${empty jobPost.jobPostId ? '작성' : '수정'}">
    </form>
    <a href="/jobpost/list">목록으로</a>
</body>
</html>