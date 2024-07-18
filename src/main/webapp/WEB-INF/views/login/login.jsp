<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 컨텍스트패스(진입점폴더) 변수 설정 -->
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<style>
    body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

header {
	background-color: #333;
	color: white;
	padding: 1em;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

header .logo {
	display: flex;
	align-items: center;
}

header .logo h1 {
	margin: 0;
	margin-right: 1em;
}

header nav ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

header nav ul li {
	margin-left: 1em;
}

header nav ul li a {
	color: white;
	text-decoration: none;
	padding: 0.5em 1em;
	border-radius: 4px;
	transition: background-color 0.3s, color 0.3s;
}

header nav ul li a:hover {
	background-color: #555;
	color: #fff;
}

.login-container {
    max-width: 400px;
    margin: 50px auto; /* 세로 중앙 정렬을 위해 margin 조정 */
    padding: 30px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #f9f9f9;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}


    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group input[type="password"] {
        width: 100%;
        padding: 8px;
        font-size: 1em;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .button-group {
        margin-top: 15px;
        text-align: center;
    }

    .button-group input[type="submit"],
    .button-group input[type="reset"],
    .button-group button {
        padding: 10px 20px;
        font-size: 1em;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
        background-color: green;
        color: #fff;
        transition: background-color 0.3s;
    }

    .button-group input[type="submit"]:hover,
    .button-group input[type="reset"]:hover,
    .button-group button:hover {
        background-color: #0056b3;
    }

    .error-message {
        color: red;
        margin-top: 10px;
    }
    
   footer {
    background-color: #f9f9f9;
    color: white;
    text-align: center;
    padding: 0.5em;
    
    bottom: 0;
    width: 100%;
    z-index: 1000; /* 다른 요소 위에 위치하도록 설정 */
}

.footer-info {
	display: flex;
	justify-content: space-around;
	margin-bottom: 1em;
}

.footer-btn {
	background-color: #f9f9f9;
	color: white;
	border: none;
	padding: 0.5em 1em;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s, transform 0.3s;
}

.footer-btn:hover {
	background-color: #555;
	transform: scale(1.05);
}

.footer-details {
	margin: 0 auto;
	color: #ccc;
}

footer .sns {
	margin-top: 30px;
}

footer .sns i {
	font-size: 24px;
	margin-right: 20px;
}
</style>
</head>
<body>
<header>
        <div class="logo">
            <h1>DelTopia</h1>
            <span>개발자들의 천국으로 가다!</span>
        </div>
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="<c:url value='/jobSeeker/create'/>">Sign-up</a></li>
                <li><a href="#">Company-Service</a></li>
            </ul>
        </nav>
    </header>
    <main style="max-width: 1200px; margin: auto;">
    <div class="login-container">
        <h3>로그인</h3>
        <form action="<c:url value='/login'/>" method="post">
            <div class="form-group">
                <label for="jobSeekerId">아이디:</label>
                <input type="text" id="jobSeekerId" name="jobSeekerId" placeholder="아이디를 입력하세요."value="${jobSeekerVo.jobSeekerId}" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." value="${jobSeekerVo.password}" required>
            </div>

            <div class="button-group">
                <input type="submit" value="로그인">
                <input type="reset" value="다시쓰기">
                <input type="reset" value="아이디/비밀번호 찾기">
            </div>
        </form>

        <%-- 오류 메시지 출력 --%>
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>
    </div>
</main>


	<footer>
        <div class="footer-info">
            <button class="footer-btn" onclick="location.href='#'">회사소개</button>
            <button class="footer-btn" onclick="location.href='#'">인재채용</button>
            <button class="footer-btn" onclick="location.href='#'">회원약관</button>
            <button class="footer-btn" onclick="location.href='#'">개인정보처리방침</button>
            <button class="footer-btn" onclick="location.href='#'">제휴문의</button>
            <button class="footer-btn" onclick="location.href='#'">고객센터</button>
        </div>

        <div class="footer-details">
            <p>(주)DelTopia</p>
            <h5>기업번호: 123-45-67890</h5>
            <h5>우편번호 : 12345, 구로구 디지털로 77길 88, 60층, 대표 : EHYJ</h5>
            <h5>사업자등록 : 222-33-6666, 직업정보제공사업 : 서울 관악 제 800-9호, 통신판매업 : 제 6006-98564호</h5>
            <h5>고객센터: 1234-5678</h5>
        </div>

        <div class="sns">
            <i class="fab fa-twitter"></i>
            <i class="fab fa-facebook-square"></i>
            <i class="fab fa-instagram"></i>
            <i class="fab fa-github"></i>
        </div>
    </footer>
</body>
</html>