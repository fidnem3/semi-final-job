<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용공고 수정</title>
</head>
<body>
	<h2>채용공고 수정</h2>

	<form:form modelAttribute="jobPost" action="/jobPost/update"
		method="post">
		<form:hidden path="jobPostId" />
		<form:hidden path="compId" />

		<div>
			<form:label path="title">제목</form:label>
			<form:input path="title" required="required" />
		</div>

		<div>
			<form:label path="content">내용</form:label>
			<form:textarea path="content" required="required" />
		</div>

		<div>
			<form:label path="position">직위</form:label>
			<form:input path="position" required="required" />
		</div>

		<div>
			<form:label path="salary">연봉</form:label>
			<form:input path="salary" type="number" required="required" />
		</div>

		<div>
			<form:label path="experience">경력</form:label>
			<form:input path="experience" required="required" />
		</div>
		<div>
			<form:label path="location">지역</form:label>
			<form:input path="location" required="required" />
		</div>

		<div>
			<form:label path="education">학력</form:label>
			<form:input path="education" required="required" />
		</div>

		<div>
			<form:label path="address">주소</form:label>
			<form:input path="address" required="required" />
		</div>

		<div>
			<form:label path="endDate">마감일</form:label>
			<form:input path="endDate" type="date" required="required" />
		</div>

		<div>
			<input type="submit" value="수정" />
			<button type="button" onclick="window.close()">취소</button>
		</div>
	</form:form>

	<script>
        // 수정 완료 후 부모 창 새로고침 및 현재 창 닫기
        document.querySelector('form').addEventListener('submit', function(e) {
            e.preventDefault();
            this.submit();
            window.opener.location.reload();
            window.close();
        });
    </script>
	<script>
    document.querySelector('form').addEventListener('submit', function(e) {
        // e.preventDefault(); // 이 줄을 제거하거나 주석 처리
        // AJAX를 사용하여 폼 데이터를 서버로 전송
        fetch(this.action, {
            method: 'POST',
            body: new FormData(this)
        }).then(response => {
            if (response.ok) {
                window.opener.location.reload();
                window.close();
            } else {
                alert('수정 중 오류가 발생했습니다.');
            }
        }).catch(error => {
            console.error('Error:', error);
            alert('수정 중 오류가 발생했습니다.');
        });
        e.preventDefault(); // 여기로 이동
    });
    </script>

</body>
</html>