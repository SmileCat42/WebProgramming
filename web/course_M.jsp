<%-- 
    Document   : course
    Created on : Jan 24, 2026, 10:39:27 AM
    Author     : Windows10
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> //เปิดใช้งานฟังก์ชั่น c ในการดึง DB
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >

    </head>
    <body>
        <jsp:include page="FrontPageF_M.html">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <script src="js/bootstrap.bundle.min.js"></script>
        <section class="hero-section">
            <div class="hero-overlay"></div>
            <div class="container mt-4">
                <div class="row g-4">

                    <c:forEach var="c" items="${courses}"> //วนลูป List ที่จัดเก็บกลุ่มวิชาจากหน้า CourseDAO ด้วยตัวแปร c
                        <div class="col-md-3"> //เว้นระยะ
                            <div class="card h-100"> //ขนาดตามเนื้อหา
                                <div class="card-body">
                                    <h5 class="card-title">${c.courseName}</h5>
                                    <p class="card-text">วันเรียน: ${c.days}</p>
                                    <p class="card-text">เวลา: ${c.times}</p>
                                    <!-- ปุ่ม -->
                                    <div class="card-footer bg-white border-0">
                                <button class="btn btn-primary w-100">
                                    ลงทะเบียนเรียน
                                </button>
                            </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="col-md-3">
                        <div class="card shadow-sm h-100">

                            <!-- รูป -->
                            <img src="img/pt2.png" class="card-img-top" alt="Java Course">

                            <!-- เนื้อหา -->
                            <div class="card-body">
                                <h5 class="card-title">Python Programming</h5>
                                <p class="card-text text-muted">
                                    เรียนรู้การสร้างเว็บด้วย JSP, MVC และ DAO
                                </p>

                                <!-- รายละเอียด -->
                                <ul class="list-unstyled small">
                                    <li>📅 <strong>วันเรียน:</strong> 1–2 มี.ค. 2026</li>
                                    <li>👥 <strong>ที่นั่ง:</strong> 
                                        <span class="text-success fw-bold">เหลือ 5 / 30</span>
                                    </li>
                                </ul>
                            </div>

                            <!-- ปุ่ม -->
                            <div class="card-footer bg-white border-0">
                                <button class="btn btn-primary w-100">
                                    ลงทะเบียนเรียน
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <!-- card ใบที่ 3 -->
                    </div>

                    <div class="col-md-3">
                        <!-- card ใบที่ 3 -->
                    </div>

                </div>
            </div>
        </div>
    </section>
</body>
</html>
