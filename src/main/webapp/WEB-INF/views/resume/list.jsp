<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resume List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="mt-5">이력서 목록</h1>
    <div class="mb-3">
        <a href="/resumes/new" class="btn btn-primary">이력서 작성</a>
    </div>
    <table class="table table-striped mt-3">
        <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>제목</th>
                <th>이메일</th>
                <th>생년월일</th>
                <th>연락처</th>
                <th>주소</th>
                <th>학력</th>
                <th>경력</th>
                <th>자세히 보기</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resume" items="${resumes}">
                <tr>
                    <td>${resume.resumeId}</td>
                    <td>${jobSeekerVo.name}</td>
                    <td>${resume.title}</td>
                    <td>${jobSeekerVo.email}</td>
                    <td>${resume.birth}</td>
                    <td>${jobSeekerVo.tel}</td>
                    <td>${jobSeekerVo.address}</td>
                    <td>${resumeVo.education}</td>
                    <td>${resumeVo.experience}</td>
                    <td>
                        <a href="/resumes/${resume.resumeId}" class="btn btn-info">보기</a>
                        <a href="/resumes/${resume.resumeId}/edit" class="btn btn-warning">수정</a>
                        <form action="/resumes/${resume.resumeId}/delete" method="post" style="display:inline;">
                            <button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
