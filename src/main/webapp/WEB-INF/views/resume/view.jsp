<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Resume</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">이력서 상세 정보</h1>
        <div class="card">
            <div class="card-header">
                <h2>${resume.title}</h2>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-3 mt-3" style="text-align: center;">
                        <img src="${jobSeekerVo.filePath}" alt="" style="width: 80%; height: auto; display: inline-block;" id="photo">
                    </div>
                    <div class="col-9">
                        <p><strong>이름:</strong> ${jobSeekerVo.name}</p>
                        <p><strong>Email:</strong> ${jobSeekerVo.email}</p>
                        <p><strong>연락처:</strong> ${jobSeekerVo.tel}</p>
                        <!-- <p><strong>주소:</strong> ${jobSeekerVo.address}</p> -->
                        <p><strong>학력:</strong> ${resume.education}</p>
                        <p><strong>경력:</strong> ${resume.experience}</p>
                        <p><strong>링크:</strong> <a href="${resume.link}" target="_blank">${resume.link}</a></p>
                        <p><strong>자기소개서:</strong></p>
                        <p>${resume.content}</p>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <a href="/resumes/${resume.resumeId}/edit" class="btn btn-warning">수정</a>
                <form action="/resumes/${resume.resumeId}/delete" method="post" style="display:inline;">
                    <button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                </form>
                <a href="/resumes" class="btn btn-secondary">목록으로</a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
