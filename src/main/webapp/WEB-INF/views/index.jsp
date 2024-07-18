<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DelTopia - 개발자들의 천국으로 가다!</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
	padding: 2em;
	background-color: #f4f4f4;
}

.categories {
	display: flex;
	justify-content: space-between;
	margin-bottom: 1em;
}
.categories h2 {
	text-align: center;
	color: white;
}

.category-btn {
    position: relative;
    background-color: #333;
    color: black;
    padding: 0.5em 1em; /* 줄여진 패딩 */
    border: none;
    border-radius: 5px;
    flex: 1;
    margin: 0 0.3em; /* 줄여진 마진 */
    cursor: pointer;
    font-size: 0.8em; /* 줄여진 글자 크기 */
    text-align: center; /* 텍스트 중앙 정렬 */
    transition: background-color 0.3s, transform 0.3s;
}

.category-btn:hover {
	background-color: green;
	transform: scale(1.1); /* 크기 조정 */
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f0f0f0;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: green;
}

.category-btn:hover .dropdown-content {
	display: block;
}

.banner {
    max-width: 600px; /* 최대 너비 설정 */
    margin: 20px auto; /* 중앙 정렬을 위한 마진 설정 */
    background-color: #f0f0f0;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.banner-link {
    display: flex; /* 이미지와 내용을 가로로 정렬하기 위해 플렉스 박스 사용 */
    text-decoration: none; /* 링크 밑줄 제거 */
}

.banner-img {
    width: 200px; /* 이미지 너비 설정 */
    height: auto; /* 자동으로 높이 조정 */
    border-radius: 8px; /* 둥근 모서리 설정 */
    margin-right: 20px; /* 이미지와 텍스트 간격 설정 */
}

.banner-content {
    flex: 1; /* 텍스트와 버튼이 남은 공간을 모두 채우도록 설정 */
}

.banner-content h2 {
    font-size: 1.5em;
    color: green;
    margin-bottom: 10px;
    animation: textZoom 2s infinite alternate; /* 2초 간격으로 반복되며 텍스트가 크기 변화 */
}

.banner-content p, h3 {
    font-size: 1em;
    color: #666;
    line-height: 1.5;
    margin-bottom: 15px;
}

.banner-content .btn {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1em;
    transition: background-color 0.3s;
}

.banner-content .btn:hover {
    background-color: #0056b3;
}


.job-section {
	background-color: white;
	padding: 1em;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.job-section h1 {
    text-align: center;
    font-size: 2em; /* 초기 글꼴 사이즈 */
    color: green; /* 초기 글자색 */
    margin-bottom: 0.5em; /* 아래 여백 */
    animation: textZoom 2s infinite alternate; /* 2초 간격으로 반복되며 텍스트가 크기 변화 */
}

@keyframes textZoom {
    0% {
        font-size: 2em; /* 시작 크기 */
    }
    100% {
        font-size: 3em; /* 최대 크기 */
    }
}

.job-section input[type="text"] {
	width: calc(100% - 100px);
	padding: 0.5em;
	margin-right: 0.5em;
}

.job-section button {
	padding: 0.5em 1em;
}

.job-listings {
	display: flex;
	flex-wrap: wrap;
	gap: 1em;
	margin-top: 1em;
}

/* 호버 기능 추가 */
.job-card {
	background-color: white;
	padding: 1em;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: flex;
	align-items: center;
	width: calc(50% - 1em);
	margin-bottom: 1em;
	transition: transform 0.3s, box-shadow 0.3s;
}

.job-card a {
        text-decoration: none; /* 링크 밑줄 제거 */
        color: inherit; /* 링크 기본 색상 상속 */
    }
    
.job-card:hover {
	transform: scale(1.05); /* 호버 시 확대 */
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); /* 호버 시 그림자 효과 */
}

.job-card {
	background-color: white;
	padding: 1em;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: flex;
	align-items: center;
	width: calc(33% - 1em);
	box-sizing: border-box;
}

.job-card img {
	width: 80px;
	height: 80px;
	margin-right: 1em;
}

.job-info {
	flex-grow: 1;
}

.job-info h3 {
	margin: 0;
	font-size: 1.2em;
}

.job-info p, .job-info h5 {
	margin: 0.2em 0;
}

footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 1em;
}

.footer-info {
	display: flex;
	justify-content: space-around;
	margin-bottom: 1em;
}

.footer-btn {
	background-color: #333;
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
        </a>
        </div>
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <c:choose>
                    <c:when test="${not empty sessionScope.jobSeekerVo}">
                        <li><a href="#">환영합니다, ${sessionScope.jobSeekerVo.name}님</a></li>
                        <li><a href="/logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/login">Login</a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="#">Company-Service</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <div class="categories">
            <div class="category-btn" onclick="toggleDropdown('dropdown1')">
                <h2>이력서/커리어</h2>
                <div id="dropdown1" class="dropdown-content">
                    <a href="#">내이력서관리</a>
                    <a href="<c:url value='/resume/new'/>">새이력서작성</a>
                    <a href="#">이력서작성가이드</a>
                    <a href="#">인적성 면접 후기</a>
                    <a href="#">인성역량검사</a>
                    <a href="#">역량테스트(MICT)</a>
                    <a href="#">공기업모의고사</a>
                    <a href="#">취업TOOL</a>
                </div>
            </div>
            <div class="category-btn" onclick="toggleDropdown('dropdown2')">
                <h2>기업/채용</h2>
                <div id="dropdown2" class="dropdown-content">
                    <a href="<c:url value='/jobPost/list'/>">TOP100</a>
                    <a href="#">1000대기업공채</a>
                    <a href="#">공공기관채용일정</a>
                    <a href="#">전문채용관</a>
                    <a href="#">슈퍼채용관</a>
                </div>
            </div>
            <div class="category-btn" onclick="toggleDropdown('dropdown3')">
                <h2>개인정보관리</h2>
                <div id="dropdown3" class="dropdown-content">
                    <a href="#">개인정보수정</a>
                    <a href="#">입사지원현황</a>
                    <a href="#">포지션제안</a>
                    <a href="<c:url value='jobSeeker/scrap/list/java'/>">스크랩공고</a>
                </div>
            </div>
        </div>

		<!-- 홍보용 배너 추가 -->
		<div class="banner">
			<a href="https://recruit.navercloudcorp.com/" target="_blank"
				class="banner-link"> <img src="/resources/image/naver.jpg"
				alt="Banner Image" class="banner-img">
				<div class="banner-content">
					<h2>채용 HOT Promotion!</h2>
					<p>"Naver Cloud" 빠르게 움직이세요, 지금 지원하세요!</p>
					<h4>"최고의 기회가 당신을 기다립니다."</h4>
					<button class="btn">바로가기 "CLICK"</button>
				</div>
			</a>
		</div>

		<div class="job-section">
            <h1>지금 채용중!</h1>

			<div class="search-section">
				<input type="text" id="searchInput" placeholder="관심 기업을 검색해보세요.">
				<button id="searchButton">검색</button>
			</div>
			<div class="job-listings">

				<div class="job-card">
					<a href="https://career.nexon.com/user/recruit/member/postDetail?joinCorp=NX&reNo=20220145"> 
					<img src="/resources/image/nexon.jpg" alt="Company 1 Logo">
						<div class="job-info">
							<h3>[인텔리전스랩스] NCS개발팀 백엔드</h3>
							<p>넥슨코리아</p>
							<h5>대한민국 경기도 성남시 분당구 판교로256번길 7, 넥슨코리아</h5>
							<h5>
								• 사용언어: C#/.NET, Node.js, Python, Serverless Framework, Vue.js,
								jQuery<br>• 개발환경 및 도구: RDS, Redis, Gitlab, Gitlab CI,
								Rundeck, Docker, AWS lambda
							</h5>
						</div>
					</a>
				</div>
				<div class="job-card">
				<a href="https://recruit.passorder.co.kr/careers">
					<img src="/resources/image/패스오더.jpg" alt="Company 2 Logo">
					<div class="job-info">
						<h3>[패스오더] 웹 프론트엔드 개발자</h3>
						<p>페이타랩</p>
						<h5>서울 강남구 영동대로85길 34, (대치동) 6층</h5>
						<h5>
							• 사용언어: TypeScript, JavaScript, HTML, CSS<br>• 개발환경 및 도구:
							Angular, React, Sass, Webpack, Npm, Git, Docker
						</h5>
					</div>
					</a>
				</div>
				
				<div class="job-card">
				<a href="https://www.socarcorp.kr/careers/jobs">
					<img src="/resources/image/socar.jpg" alt="Company 2 Logo">
					<div class="job-info">
						<h3>[쏘카] Senior DevOps Engineer</h3>
						<p>SOCAR</p>
						<h5>대한민국 서울특별시 성동구 83 21 디타워 서울포레스트, 아크로포레스트 디타워, 3~5F</h5>
						<h5>• 사용언어: Go, Python, Java, Kotlin</h5>
					</div>
					</a>
				</div>
				
				<div class="job-card">
				<a href="https://www.lotteinnovate.com/company/careers/recruit">
					<img src="/resources/image/lotte.jpg" alt="Company 2 Logo">
					<div class="job-info">
						<h3>[자동화기술팀] 자동화인프라총괄</h3>
						<p>롯데이노베이트</p>
						<h5>서울특별시 금천구 가산디지털2로 179 (가산동, 롯데센터)</h5>
						<h5>• 사용언어: MSSQL(Microsoft SQL Server), Java, JavaScript</h5>
					</div>
					</a>
				</div>
				
				<div class="job-card">
				<a href="">
					<img src="/resources/image/profile.jpg" alt="Company 2 Logo">
					<div class="job-info">
						<h3>추가 공고</h3>
						<p>뚱이</p>
						<h5>귀엽다</h5>
						<h5>사랑해 건강해</h5>
					</div>
					</a>
				</div>
			</div>
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
        
        <button id="scroll-to-top-btn" class="footer-btn" >맨 위로 이동</button>
        
    </footer>
    <script>
        function toggleDropdown(id) {
            var dropdown = document.getElementById(id);
            dropdown.classList.toggle('show');
        }
        
     // 스크롤을 맨 위로 이동시키는 함수
        function scrollToTop() {
            window.scrollTo({
                top: 0,
                behavior: 'smooth'
            });
        }

        // 'scroll-to-top-btn' 버튼에 클릭 이벤트 추가
        document.getElementById('scroll-to-top-btn').addEventListener('click', scrollToTop);
       
     // 검색 버튼 클릭 시 실행될 함수
        document.getElementById('searchButton').addEventListener('click', function() {
            var searchQuery = document.getElementById('searchInput').value.trim(); // 입력된 검색어 가져오기 (공백 제거)

            // 검색어가 비어 있지 않은 경우에만 처리
            if (searchQuery !== '') {
                // 검색 결과 페이지 URL 생성
                var searchUrl = '/jobpost/list?query=' + encodeURIComponent(searchQuery);
                
                // 검색 결과 페이지로 이동
                window.location.href = searchUrl;
            } else {
                alert('검색어를 입력해주세요.');
            }
        });

        // 엔터 키로도 검색할 수 있도록 설정 (선택사항)
        document.getElementById('searchInput').addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                document.getElementById('searchButton').click(); // 검색 버튼 클릭 이벤트 발생
            }
        });
        
    </script> 
</body>
</html>