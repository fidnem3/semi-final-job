<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.javalab.board.vo.ResumeVo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Resume</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">이력서 수정</h1>
		<form id="resumeForm" method="post" action="/resumes/${resume.resumeId}/edit">
            <input type="hidden" id="resumeId" name="resumeId" value="${resume.resumeId}">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="text" class="form-control" id="title" name="title" value="${resume.title}" required>
            </div>
            <div class="mb-3">
                <label for="education" class="form-label">학력 사항</label>
                <select class="form-select" id="education" name="education" required>
                    <option disabled>학력을 선택하세요</option>
                    <option value="초졸" ${resume.education eq '초졸' ? 'selected' : ''}>초졸</option>
                    <option value="중졸" ${resume.education eq '중졸' ? 'selected' : ''}>중졸</option>
                    <option value="고졸" ${resume.education eq '고졸' ? 'selected' : ''}>고졸</option>
                    <option value="대졸" ${resume.education eq '대졸' ? 'selected' : ''}>대졸</option>
                    <option value="대학원 이상" ${resume.education eq '대학원 이상' ? 'selected' : ''}>대학원 이상</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="experience" class="form-label">경력 사항</label>
                <select class="form-select" id="experience" name="experience" required>
                    <option disabled>경력을 선택하세요</option>
                    <option value="신입" ${resume.experience eq '신입' ? 'selected' : ''}>신입</option>
                    <option value="1년차 미만" ${resume.experience eq '1년차 미만' ? 'selected' : ''}>1년차 미만</option>
                    <option value="1년" ${resume.experience eq '1년' ? 'selected' : ''}>1년</option>
                    <option value="2년" ${resume.experience eq '2년' ? 'selected' : ''}>2년</option>
                    <option value="3년" ${resume.experience eq '3년' ? 'selected' : ''}>3년</option>
                    <option value="4년" ${resume.experience eq '4년' ? 'selected' : ''}>4년</option>
                    <option value="5년" ${resume.experience eq '5년' ? 'selected' : ''}>5년</option>
                    <option value="6년" ${resume.experience eq '6년' ? 'selected' : ''}>6년</option>
                    <option value="7년" ${resume.experience eq '7년' ? 'selected' : ''}>7년</option>
                    <option value="8년차 이상" ${resume.experience eq '8년차 이상' ? 'selected' : ''}>8년차 이상</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="link" class="form-label">링크</label>
                <input type="text" class="form-control" id="link" name="link" value="${resume.link}">
            </div>
<%--             <div class="mb-3">
                <label for="content" class="form-label">자기소개서</label>
                <textarea class="form-control" id="content" name="content" rows="3">${resume.content}</textarea>
            </div> --%>
            <button type="button" onclick="updateResume()" class="btn btn-primary">저장</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
    function updateResume() {
        var resumeId = $('#resumeId').val();
        var title = $('#title').val();
        var education = $('#education').val();
        var experience = $('#experience').val();
        var link = $('#link').val();
        var content = $('#content').val();

        var resumeData = {
            resumeId: resumeId,
            title: title,
            education: education,
            experience: experience,
            link: link,
            content: content
        };

        $.ajax({
            url: '/resumes/' + resumeId,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(resumeData),
            success: function(response) {
                alert('이력서가 성공적으로 업데이트 되었습니다.');
                window.location.href = '/resumes'; // 업데이트 완료 후 목록 페이지로 이동
            },
            error: function(xhr, status, error) {
                alert('이력서 업데이트 중 오류가 발생했습니다.');
            }
        });
    }
    </script>

</body>
</html>
