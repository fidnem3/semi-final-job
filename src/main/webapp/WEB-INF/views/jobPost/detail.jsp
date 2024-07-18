<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%=new java.util.Date()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<style>
.button-container {
	display: flex;
	gap: 10px;
}

button, input[type="submit"] {
	cursor: pointer;
}

.my-cursor {
	cursor: pointer;
}

.on-Clicked {
	color: gold;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
			<strong>지역:</strong> ${jobPost.address}
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

		<button onclick="window.close()">창 닫기</button>
		<c:if test="${sessionScope.JobSeekerVo.jobSeekerId == JobPost.compId}">
			<button onclick="editJobPost(${jobPost.jobPostId})">수정</button>
			<button onclick="confirmDelete(${jobPost.jobPostId})">삭제</button>
		</c:if>
	</div>
	<!-- 스크랩 버튼 -->
	<div id="scrapButton">
		<c:choose>
			<c:when test="${not empty sessionScope.jobSeekerVo}">
				<!-- 세션에 로그인 정보가 있는 경우 -->
				<c:choose>
					<c:when test="${jobSeekerScrapVo.scrapId > 0}">
						<i id="scrapIcon" class="fa-solid on-Clicked fa-star my-cursor"
							onclick="toggleScrap('${jobPostVo.jobPostId}', '${jobSeekerScrapVo.scrapId}')"></i>
					</c:when>
					<c:otherwise>
						<i id="scrapIcon" class="fa-regular fa-star my-cursor"
							onclick="toggleScrap('${jobPostVo.jobPostId}', 0)"></i>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<!-- 세션에 로그인 정보가 없는 경우 -->
				<a href="<c:url value='/login'/>"> <i id="scrapIcon"
					class="fa-regular fa-star"></i>
				</a>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- JavaScript 코드 -->
	<script>
    function toggleScrap(bno, scrapId) {
        let jobSeekerId = '${sessionScope.jobSeekerVo.jobSeekerId}';
        let data = {
            jobSeekerId: jobSeekerId,
            jobPostId: jobPostId
        };

        $.ajax({
            type: "POST",
            url: "<c:url value='/jobSeeker/scrap/toggle'/>",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: "json",
            success: function(response) {
                if (response === "canceled") {
                    $('#scrapIcon').removeClass('fa-solid on-Clicked').addClass('fa-regular');
                    alert('스크랩이 취소되었습니다.');
                } else {
                    $('#scrapIcon').removeClass('fa-regular').addClass('fa-solid on-Clicked');
                    alert('게시물이 스크랩되었습니다.');
                }
            },
            error: function(xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    }
    function navigateTo(url) {
        window.location.href = url;
    }
</script>
	<script>
    function editJobPost(jobPostId) {
        window.location.href = "${contextPath}/jobPost/edit/" + jobPostId;
    }

    function confirmDelete(jobPostId) {
        if (confirm("정말로 이 채용공고를 삭제하시겠습니까?")) {
            deleteJobPost(jobPostId);
        }
    }

    function deleteJobPost(jobPostId) {
        $.ajax({
            type: "POST",
            url: "${contextPath}/jobPost/delete",
            data: { id: jobPostId },
            success: function(response) {
                if (response === "success") {
                    alert("채용공고가 삭제되었습니다.");
                    if (window.opener && !window.opener.closed) {
                        window.opener.location.reload(); // 부모 창 새로고침
                    }
                    window.close(); // 현재 창 닫기
                } else {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            },
            error: function(xhr, status, error) {
                alert("삭제 중 오류가 발생했습니다: " + xhr.responseText);
            }
        });
    }
</script>
</body>
</html>