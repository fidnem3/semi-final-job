<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용공고 수정</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
        }
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        div {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #2c3e50;
        }
        input[type="text"], input[type="number"], input[type="date"], textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            height: 100px;
            resize: vertical;
        }
        input[type="submit"], button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"]:hover, button:hover {
            background-color: #2980b9;
        }
        button {
            background-color: #e74c3c;
            margin-left: 10px;
        }
        button:hover {
            background-color: #c0392b;
        }
    </style>

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
			<form:label path="job">직업</form:label>
			<form:input path="job" required="required" />
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
    document.querySelector('form').addEventListener('submit', function(e) {
        e.preventDefault(); // 기본 제출 동작 방지
        var form = this;
        
        // 폼 데이터를 서버로 전송
        fetch(form.action, {
            method: form.method,
            body: new FormData(form)
        }).then(response => {
            if (response.ok) {
                // 성공적으로 처리되었을 때
                alert('수정이 완료되었습니다.');
                window.opener.location.reload(); // 부모 창 새로고침
                window.close(); // 현재 창 닫기
            } else {
                // 서버에서 오류 응답을 받았을 때
                throw new Error('수정 중 오류가 발생했습니다.');
            }
        }).catch(error => {
            // 네트워크 오류 등 예외 발생 시
            console.error('Error:', error);
            alert(error.message);
        });
    });
</script>

</body>
</html>