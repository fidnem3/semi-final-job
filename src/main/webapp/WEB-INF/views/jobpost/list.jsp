<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용 공고 목록</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/jobpost-list.css">

</head>
<body>
	<h1>채용 공고 목록</h1>

	<div class="filter-buttons">
		<button onclick="toggleFilterOptions('function')">기능별</button>
		<button onclick="toggleFilterOptions('experience')">경력별</button>
		<button onclick="toggleFilterOptions('job')">직업별</button>
		<button onclick="toggleFilterOptions('location')">지역별</button>
	</div>

	<div id="functionFilter" class="filter-options" style="display: none;">
		<button>IT</button>
		<button>마케팅</button>
		<button>영업</button>
	</div>

	<div id="experienceFilter" class="filter-options"
		style="display: none;">
		<button>신입</button>
		<button>1~3년</button>
		<button>3~5년</button>
	</div>

	<div id="jobFilter" class="filter-options" style="display: none;">
		<button>프론트엔드 개발자</button>
		<button>백엔드 개발자</button>
		<button>풀스텍 개발자</button>
	</div>

	<div id="locationFilter" class="filter-options" style="display: none;">
		<button>서울</button>
		<button>경기</button>
		<button>부산</button>
	</div>



	<a href="/jobpost/create" class="create-button">새 공고 작성</a>

	<div id="jobPostings">
		<!-- 여기에 필터링된 채용 공고가 동적으로 추가됩니다 -->
	</div>

	<script>
    // 서버에서 전달받은 데이터로 jobPostings 초기화
    var jobPostings = [
        <c:forEach items="${jobPosts}" var="post" varStatus="status">
            {
                jobPostId: "${post.jobPostId}",
                title: "${post.title}",
                compId: "${post.compId}",
                function: "${post.function}",
                experience: "${post.experience}",
                job: "${post.job}",
                location: "${post.location}",
                endDate: "${post.endDate}"
            }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];
</script>


	<script src="/resources/js/jobpost-list.js"></script>
</body>
</html>