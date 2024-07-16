<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.javalab.board.vo.JobSeekerVo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Resume</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <h1>이력서 작성</h1>
    <div class="container">
    
    
    
        <%-- <form id="resumeForm">
            <div class="row">
                <div class="col-12">
                    <br>
                    이력서 작성<br>
                    <hr />
                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">기본 정보</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-3 mt-3" style="text-align: center;">
                                    <img class="" src="${jobSeekerVo.filePath}" alt="" srcset=""
                                         style="width: 80%; height: auto; display: inline-block;" id="photo">
                                </div>
                                <div class="col-2 pt-3">
                                    <div class="mb-2">
                                        이름
                                    </div>
                                    <div class="mb-2">
                                        생년월일
                                    </div>
                                    <div class="mb-2">
                                        Email
                                    </div>
                                    <div class="mb-2">
                                        연락처
                                    </div>
                                    <div class="mb-2">
                                        주소
                                    </div>
                                </div>
                                <div class="col-7 pt-3">
                                    <div class="mb-2">
                                        ${jobSeekerVo.name}
                                    </div>
                                    <div class="mb-2">
                                        ${jobSeekerVo.birth}
                                    </div>
                                    <div class="mb-2">
                                        ${jobSeekerVo.email}
                                    </div>
                                    <div class="mb-2">
                                        ${jobSeekerVo.tel}
                                    </div>
                                    <div class="mb-2">
                                        ${jobSeekerVo.address}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">학력 사항</div>
                        <div class="card-body">
                            <div class="form-group">
                                <select class="form-select" name="education" id="education">
                                    <option selected disabled>학력 사항을 선택해주세요</option>
                                    <option value="초졸">초졸</option>
                                    <option value="중졸">중졸</option>
                                    <option value="고졸">고졸</option>
                                    <option value="대졸">대졸</option>
                                    <option value="대학원 이상">대학원 이상</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">경력 사항</div>
                        <div class="card-body">
                            <div class="form-group">
                                <select class="form-select" name="career" id="career">
                                    <option selected disabled>경력 사항을 선택해주세요</option>
                                    <option value="신입">신입</option>
                                    <option value="1년차 미만">1년차 미만</option>
                                    <option value="1년">1년</option>
                                    <option value="2년">2년</option>
                                    <option value="3년">3년</option>
                                    <option value="4년">4년</option>
                                    <option value="5년">5년</option>
                                    <option value="6년">6년</option>
                                    <option value="7년">7년</option>
                                    <option value="8년차 이상">8년차 이상</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">보유 기술</div>
                        <div class="card-body">
                            <div class="row my-3">
                                <div id="my-table-body2">
                                    <table class="table table-bordered" style="background-color: white;">
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="Java">Java
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="JavaScript">
                                                            JavaScript
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="Spring"> Spring
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="HTML"> HTML
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="jQuery"> jQuery
                                                        </label>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="JSP"> JSP
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="Vue.js"> Vue.js
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="Oracle"> Oracle
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="MySQL"> MySQL
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-check text-center">
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="skill" value="React"> React
                                                        </label>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">자기소개서</div>
                        <div class="card-body">
                            <div class="form-group">
                                <textarea class="form-control" name="content" id="content" rows="3"></textarea>
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">링크</div>
                        <div class="card-body">
                            <div class="form-group">
                                <input type="text" name="link" id="link" class="form-control">
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">제목</div>
                        <div class="card-body">
                            <div class="form-group">
                                <input type="text" name="title" id="title" class="form-control">
                            </div>
                        </div>
                    </div>

                    <div class="card border-light mb-3" style="max-width: 40rem;">
                        <div class="card-header">이력서 공개 여부</div>
                        <div class="card-body">
                            <fieldset class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="state" id="state" value="1" checked="">
                                    <label class="form-check-label" for="optionsRadios1">
                                        공개
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="state" id="state" value="0">
                                    <label class="form-check-label" for="optionsRadios2">
                                        비공개
                                    </label>
                                </div>
                            </fieldset>
                        </div>
                    </div>

                    <div class="col-3 p-6">
                        <div class="rButton" style="width: 10em;">
                            <br>
                            <div id="resume-render">
                                <div id="resume-remove">
                                    <div class="row mb-2">
                                        <button onclick="writeResume()" type="button"
                                                class="btn btn-success w-100">이력서 저장</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form> --%>
        
        <form id="resumeForm">
    <input type="text" id="jobSeekerId" name="jobSeekerId" placeholder="Job Seeker ID">
    <input type="text" id="title" name="title" placeholder="Title">
    <textarea id="content" name="content" placeholder="Content"></textarea>
    <input type="text" id="education" name="education" placeholder="Education">
    <input type="text" id="experience" name="experience" placeholder="Experience">
    <input type="text" id="link" name="link" placeholder="Link">
    <input type="text" id="hitNo" name="hitNo" placeholder="Hit Number">
    <input type="text" id="fileName" name="fileName" placeholder="File Name">
    <input type="text" id="filePath" name="filePath" placeholder="File Path">
    <button type="button" onclick="writeResume()">Submit</button>
</form>
        
        
        
        
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    
    <script>
    let resumeId;
    let jobSeekerId = '${sessionScope.jobSeekerVo.jobSeekerId}';

/**      function writeResume() {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            education: $("#education").val(),
            career: $("#career").val(),
            skillList: skillValues,
            link: $("#link").val(),
            state: $("input[name='state']:checked").val(),
            userId: jobSeekerId,
            resumeId: resumeId
        };

        $.ajax({
            url: '/resumes/write',
            type: 'POST',
            contentType: 'application/json', // Content-Type 설정
            data: JSON.stringify({
                resumeId: $('#resumeId').val(),
                jobSeekerId: $('#jobSeekerId').val(),
                title: $('#title').val(),
                content: $('#content').val(),
                education: $('#education').val(),
                experience: $('#experience').val(),
                link: $('#link').val(),
                hitNo: $('#hitNo').val(),
                fileName: $('#fileName').val(),
                filePath: $('#filePath').val()
            }),
            success: function(response) {
                alert('Success: ' + response.msg);
            },
            error: function(error) {
                alert('Error: ' + error.responseJSON.msg);
            }
        });
    } **/
    
    
    /**
    function writeResume() {
        const resumeData = {
            resumeId: 1, // 실제 데이터로 대체
            jobSeekerId: 'java', // 실제 데이터로 대체
            title: 'Sample Title', // 실제 데이터로 대체
            content: 'Sample Content', // 실제 데이터로 대체
            education: 'Sample Education', // 실제 데이터로 대체
            experience: 'Sample Experience', // 실제 데이터로 대체
            link: 'http://samplelink.com', // 실제 데이터로 대체
            hitNo: 0, // 실제 데이터로 대체
            fileName: 'samplefile.txt', // 실제 데이터로 대체
            filePath: '/path/to/samplefile.txt' // 실제 데이터로 대체
        };

        $.ajax({
            url: 'http://localhost:8080/resumes/write',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(resumeData),
            success: function(response) {
                alert(response.msg);
            },
            error: function(xhr, status, error) {
                alert('Error: ' + xhr.responseText);
            }
        });
    }
    
    **/
    
    function writeResume() {
        const resumeData = {
            jobSeekerId: $('#jobSeekerId').val(),
            title: $('#title').val(),
            content: $('#content').val(),
            education: $('#education').val(),
            experience: $('#experience').val(),
            link: $('#link').val(),
            hitNo: parseInt($('#hitNo').val()),
            fileName: $('#fileName').val(),
            filePath: $('#filePath').val()
        };

        $.ajax({
            url: '/resumes/write',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(resumeData),
            success: function(response) {
                alert(response.msg);
            },
            error: function(xhr, status, error) {
                alert('Error: ' + xhr.responseText);
            }
        });
    }



    function getCheckedValues(name) {
        var checkedValues = [];
        var checkboxes = document.getElementsByName(name);
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                checkedValues.push(checkboxes[i].value);
            }
        }
        return checkedValues;
    };

    let skillValues;

    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener('click', function () {
            skillValues = getCheckedValues("skill");
        })
    });
</script>

</body>
</html>