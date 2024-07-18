<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용 공고 작성</title>

    <style>
        body {
            font-family: 'Noto Sans KR', Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
            font-weight: 700;
        }
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        div {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: 600;
            color: #34495e;
        }
        input[type="text"], input[type="date"], textarea, input[type="file"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        textarea {
            height: 150px;
            resize: vertical;
        }
        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 18px;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #3498db;
            text-decoration: none;
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<h1>채용 공고 작성</h1>

	<form:form action="/jobPost/create" method="post"
		modelAttribute="jobPost" enctype="multipart/form-data">
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
			<label for="job">직업:</label>
			<form:input path="job" />
		</div>
		<div>
			<label for="function">기능:</label>
			<form:input path="function" />
		</div>
		<div>
			<label for="location">지역:</label>
			<form:input path="location" />
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
			<label for="file">이미지 첨부:</label> <input type="file" name="file"
				accept="image/*">
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form:form>

	<a href="/jobPost/list">목록으로 돌아가기</a>
</body>
</html>