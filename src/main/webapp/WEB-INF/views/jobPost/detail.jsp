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
<title>${jobPost.title}- 채용 상세</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	line-height: 1.6;
	color: #333;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.job-detail-container {
	max-width: 800px;
	margin: 0 auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #2c3e50;
	border-bottom: 2px solid #3498db;
	padding-bottom: 10px;
	margin-bottom: 20px;
}

.job-info {
	display: grid;
	grid-template-columns: 120px 1fr;
	gap: 10px;
	margin-bottom: 20px;
}

.job-info strong {
	color: #3498db;
}

.button-container {
	display: flex;
	gap: 10px;
	margin-top: 20px;
}

button, input[type="submit"] {
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

button {
	background-color: #3498db;
	color: white;
}

button:hover {
	background-color: #2980b9;
}

.scrap-button {
	font-size: 24px;
	color: #f39c12;
	cursor: pointer;
	transition: color 0.3s;
}

.scrap-button:hover {
	color: #f1c40f;
}

.on-Clicked {
	color: #f1c40f;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="job-detail-container">
		<h1>${jobPost.title}</h1>
		<div class="job-info">
			<strong>회사:</strong> <span>${jobPost.compId}</span> <strong>내용:</strong>
			<span>${jobPost.content}</span> <strong>직위:</strong> <span>${jobPost.position}</span>
			<strong>연봉:</strong> <span>${jobPost.salary}</span> <strong>경력:</strong>
			<span>${jobPost.experience}</span> <strong>지역:</strong> <span>${jobPost.location}</span>
			<strong>학력:</strong> <span>${jobPost.education}</span> <strong>기업주소:</strong>
			<span>${jobPost.address}</span> <strong>마감일:</strong> <span>${jobPost.endDate}</span>
		</div>

		<div class="button-container">
			<button onclick="window.close()">창 닫기</button>
			<c:if
				test="${sessionScope.JobSeekerVo.jobSeekerId == JobPost.compId}">
				<button onclick="editJobPost(${jobPost.jobPostId})">수정</button>
				<button onclick="confirmDelete(${jobPost.jobPostId})">삭제</button>
			</c:if>
			<div id="scrapButton" class="scrap-button">
				<c:choose>
					<c:when test="${not empty sessionScope.jobSeekerVo}">
						<c:choose>
							<c:when test="${jobSeekerScrapVo.scrapId > 0}">
								<i id="scrapIcon" class="fa-solid fa-star on-Clicked"
									onclick="toggleScrap('${jobPostVo.jobPostId}', '${jobSeekerScrapVo.scrapId}')"></i>
							</c:when>
							<c:otherwise>
								<i id="scrapIcon" class="fa-regular fa-star"
									onclick="toggleScrap('${jobPostVo.jobPostId}', 0)"></i>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="<c:url value='/login'/>"> <i id="scrapIcon"
							class="fa-regular fa-star"></i>
						</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<!-- JavaScript 코드는 그대로 유지 -->
	<script>
	function toggleScrap(jobPostId, scrapId) {
	    let jobSeekerId = '${sessionScope.jobSeekerVo.jobSeekerId}';
	    
	    // Check if jobSeekerId is available in session
	    if (jobSeekerId) {
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
	    } else {
	        // Redirect to login page if jobSeekerId is not available
	        window.location.href = "<c:url value='/login'/>";
	    }
	}

    function navigateTo(url) {
        window.location.href = url;
    }
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