<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 컨텍스트패스(진입점폴더) 변수 설정 -->
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm.jsp</title>
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



    main {
        max-width: 400px;
        margin: 50px auto;
        padding: 30px;
        border: 1px solid #ccc;
        border-radius: 8px;
        background-color: #f9f9f9;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h3 {
        font-size: 1.5em;
        margin-bottom: 20px;
        text-align: center;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    form > div {
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
    }

    input[type="text"], input[type="password"], input[type="email"] {
         width: 100%;
        padding: 8px;
        font-size: 0.9em; /* 입력 필드의 폰트 사이즈도 맞추어 줄입니다 */
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 0.7em;
    }

    input[type="submit"] {
        padding: 10px 20px;
        font-size: 1em;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        background-color: green;
        color: #fff;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    
    #btnSubmit {
        margin-top: 15px;
        text-align: center;
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
    <main>
    <h3>회원가입</h3>
    <form id="regForm" action="<c:url value='/jobSeeker/create'/>" method="post">
        <div>
            <label for="jobSeekerId">아이디 :</label>
            <input type="text" name="jobSeekerId" id="jobSeekerId" placeholder="영문자로 시작하고 5자리에서 8자리로 입력하세요." required>
        </div>    
        <div>
            <label for="password">비밀번호 :</label>
            <input type="password" name="password" id="password" placeholder="영문 대소문자와 숫자, 특수문자가 포함 5자리에서 8자리까지 입력하세요." required>
        </div>    
        <div>
            <label for="pwdConfirm">비밀번호 확인 :</label>
            <input type="password" id="pwdConfirm" placeholder="비밀번호를 한 번 더 입력하세요." required>
        </div>    
        <div>
            <label for="name">이름 :</label>
            <input type="text" name="name" id="name" placeholder="한글 2자 이상 5자 이하로 입력하세요." required>
        </div>    
        <div>
            <label for="tel">연락처 :</label>
            <input type="text" name="tel" id="tel" placeholder="'-'를 포함해서 연락처를 입력하세요." required>
        </div>        
        <div>
            <label for="email">이메일 :</label>
            <input type="email" name="email" id="email" placeholder="이메일을 입력하세요." required>
        </div>
        <div style="text-align: center;">
            <input type="submit" id="btnSubmit" value="회원가입완료">
        </div>
    </form>
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
    <script>
        // form 태그 submit 이벤트 핸들러 설정
        // id속성이 regForm요소에 이벤트 핸들러 설정(regForm -> regForm5)
        const form = document.getElementById("regForm"); 
        form.addEventListener("submit", function(event) { // 이벤트의 종류는 "submit"
            event.preventDefault();	// 폼 submit 방지
			// 각 입력 요소들의 참조 주소값을 변수에 할당
			// getElementById("id") : 메소드 자체가 id 속성으로 찾기 때문에 ("#id")와 같이 사용 안함. 
            const idInput = document.getElementById("jobSeekerId");
            const pwdInput = document.getElementById("password");
            const pwdConfirmInput = document.getElementById("pwdConfirm");
            const nameInput = document.getElementById("name");
            const telInput = document.getElementById("tel");
            const emailInput = document.getElementById("email");
			// 입력 요소들의 값을 추출(trim 함수로 값 좌우측 공백 제거)
            const id = idInput.value.trim();
            const pwd = pwdInput.value.trim();
            const pwdConfirm = pwdConfirmInput.value.trim();
            const name = nameInput.value.trim();
            const tel = telInput.value.trim();
            const email = emailInput.value.trim();

            //// 정규표현식
            // 아이디는 첫 글자는 영문자, 나머지는 영문자 또는 숫자로 5자리에서 8자리까지
            const regExpId = /^[a-zA-Z][a-zA-Z0-9]{4,7}$/;
            // 이름이 반드시 한글로 시작하고, 2자 이상 5자 이하의 길이
            const regExpName = /^[가-힣]{2,5}$/;
            // 비밀번호는 특수문자와 영어 대문자, 소문자, 숫자를 모두 포함해야 하면 전체 자릿수는 5자리에서 8자리까지
            const regExppwd = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)
            (?=.*[!@#$%^&*])[a-zA-Z\d!@#$%^&*]{5,8}$/;
            // 휴대폰 연락처
            const regExpTel = /^\d{3}-\d{3,4}-\d{4}$/;
            // 이메일 정규식
            const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]
            ([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

            // 아이디 검증
            if (id === '') {
                alert('아이디를 입력하세요.');
                idInput.focus();
                return;
            }
            if (!regExpId.test(id)) {
                alert("아이디는 영문자로 시작하고 5자리에서 8자리로 입력하세요");
                idInput.focus();
                return;
            }
            // 비밀번호 검증
            if (pwd === '') {
                alert('비밀번호를 입력하세요.');
                pwdInput.focus();
                return;
            }
            if (!regExppwd.test(pwd)) {
                alert("비밀번호는 영문 대소문자와 숫자, 특수문자가 포함 5자리에서 8자리까지 입력하세요.");
                pwdInput.focus();
                return;
            }
            if (pwd !== pwdConfirm) {
                alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
                pwdConfirmInput.focus();
                return;
            }
            
            // 이름 검증
            if (name === '') {
                alert('이름을 입력하세요.');
                nameInput.focus();
                return;
            }
            if (!regExpName.test(name)) {
                alert("이름은 한글 2자 이상 5자 이하로 입력하세요.");
                nameInput.focus();
                return;
            }

            // 연락처 검증
            if (tel === '') {
                alert("연락처를 입력해주세요");
                telInput.focus();
                return;
            }
            if (!regExpTel.test(tel)) {
                alert("연락처를 확인해주세요");
                telInput.focus();
                return;
            }

            // 이메일 검증
            if (!regExpEmail.test(email)) {
                alert("이메일을 확인해주세요");
                emailInput.focus();
                return;
            }

            // 모든 검증이 끝난 경우 폼 제출
            form.submit();
        });
    </script>    
    
</body>
</html>
