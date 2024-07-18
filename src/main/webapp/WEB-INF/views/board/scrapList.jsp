<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="now" value="<%= new java.util.Date() %>" />
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>
    <script src="<c:url value='${contextPath}/resources/assets/js/color-modes.js' />"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>Album example · Bootstrap v5.3</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/album/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="${contextPath}/resources/assets/dist/css/bootstrap.min.css" rel="stylesheet">


    <style>
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
    
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }

      .bd-mode-toggle {
        z-index: 1500;
      }

      .bd-mode-toggle .dropdown-menu .active .bi {
        display: block !important;
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
    
    <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
     <!--  <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
              id="bd-theme"
              type="button"
              aria-expanded="false"
              data-bs-toggle="dropdown"
              aria-label="Toggle theme (auto)">
        <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#circle-half"></use></svg>
        <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
      </button> -->
      <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#sun-fill"></use></svg>
            Light
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
            Dark
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#circle-half"></use></svg>
            Auto
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
      </ul>
    </div>



<main>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">My Scrap</h1>
        <p class="lead text-body-secondary">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
        <p>
          <a href="#" class="btn btn-primary my-2">공고 보러가기</a>
          <a href="#" class="btn btn-secondary my-2">이력서 작성</a>
        </p>
      </div>
    </div>
  </section>

  <div class="album py-5 bg-body-tertiary">
   <div class="container">
    <div class="row row-cols-1 row-cols-md-3 g-3">
        <c:if test="${not empty scrapList}">
            <c:forEach var="jobPosts" items="${scrapList}">
                <div class="col">
                    <div class="card shadow-sm">
                        <!-- Placeholder image, adjust as needed -->
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
    <title>Placeholder</title>
    <rect width="100%" height="100%" fill="#55595c"/>
    <!-- 이미지 삽입 -->
    <image xlink:href="${contextPath}/resources/image/10.png" width="100%" height="100%" />
</svg>

                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${jobPosts.title}" /></h5>
                            <p class="card-text">게시물 번호: <c:out value="${jobPosts.jobPostId}" /></p>
                            <p class="card-text">작성일자: <fmt:formatDate value="${jobPosts.created}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href="<c:url value='/board/view?jobPostId=${jobPosts.jobPostId}'/>" class="btn btn-sm btn-outline-secondary">View</a>
                                    <!-- Add other buttons as needed -->
                                </div>
                                <small class="text-body-secondary">9 mins</small> <!-- Replace with actual timestamp or remove if not needed -->
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty scrapList}">
            <div class="col">
                <div class="card shadow-sm">
                    <!-- Placeholder image, adjust as needed -->
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                        <title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"/>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                    </svg>
                    <div class="card-body">
                        <p class="card-text">스크랩한 게시물이 없습니다.</p>
                    </div>
                </div>
            </div>
        </c:if>
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
    </footer>

    </body>
</html>
