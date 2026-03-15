<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <style>
            .kanit{
                font-family: kanit;
            }
            .hero-section {
                position: relative;
                min-height: 100vh;
                background: url("img/bg10.jpg") center/cover no-repeat;
            }

            .hero-overlay {
                position: absolute;
                inset: 0;
                background: linear-gradient(
                    rgba(255,255,255,0.85),
                    rgba(255,255,255,0.6)
                    );
            }

            .hero-content {
                position: relative;
                z-index: 1;
                max-width: 700px;
                padding: 80px 40px;
                font-family: "Kanit", sans-serif;
            }
            .scroll-box {
                white-space: nowrap;
                padding-left: 70%;
                animation: scroll-left 10s linear infinite;
                width: 50px;
                align:center;
            }
            .sidebar {
                background-color: #f8f9fa;
                border-right: 1px solid #e0e0e0;
                box-shadow: 2px 0 8px rgba(0,0,0,0.05);
            }
            @keyframes scroll-left {
                0% {
                    transform: translateX(0);
                }
                100% {
                    transform: translateX(-100%);
                }
            }
        </style>
        <title>HomePage Version 3</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="Chapter7_Bootstrap/32.png">
        <link href="css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-body-tertiary  fixed-top kanit">
            <div class="container-fluid">
                <a class="navbar-brand" href="FrontPageV3.html">
                    <img src="Chapter7_Bootstrap/icon3.png" alt="logo" height="40">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="AboutUs.html">หน้าแรก</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="AboutUs.html">เกี่ยวกับเรา</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="News.html">ข่าวสาร</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="course.jsp" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Course
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="coursel">Web Programming</a></li>
                                <li><a class="dropdown-item" href="course">C++</a></li>
                                <li><a class="dropdown-item" href="course">Python</a></li>
                                <li><a class="dropdown-item" href="course">Java</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/JSPHtml/course">All Course</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ContactUs.html">ติดต่อเรา</a>
                        </li>
                    </ul>
                    <div class="d-flex align-items-center gap-2">

                        <form class="d-flex mb-0" role="search"> <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>

                        <div class="dropdown">
                            <button class="btn btn-outline-secondary dropdown-toggle d-flex align-items-center" 
                                    type="button" 
                                    data-bs-toggle="dropdown" 
                                    aria-expanded="false"
                                    style="padding: 2px 8px; border-radius: 20px;"> <img src="img/profile3.png" 
                                                                                 alt="Profile" 
                                                                                 class="rounded-circle" 
                                                                                 style="width: 30px; height: 30px; object-fit: cover; border: 1px solid #ddd;">

                                <span class="ms-2 d-none d-lg-inline" style="font-size: 0.9rem;">${user.fname}</span>
                            </button>

                            <ul class="dropdown-menu dropdown-menu-end shadow-sm">
                                <li><a class="dropdown-item" href="#">👤 โปรไฟล์ของฉัน</a></li>
                                <li><a class="dropdown-item" href="#">⚙️ ตั้งค่า</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item text-danger" href="logout">🚪 ออกจากระบบ</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <br><br><br>


        <div class="border p-2 overflow-hidden text-success">
            <p class="scroll-box">
                <b style="font-family: Prompt">
                    สวัสดีคุณ ${sessionScope.user.fname} ขอให้สนุกกับการเรียนนะ    Invest in yourself. Education is the best interest.
                </b>
            </p>
        </div>
    </body>
</html>
