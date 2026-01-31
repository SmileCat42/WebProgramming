<%-- 
    Document   : course
    Created on : Jan 24, 2026, 10:39:27 AM
    Author     : Windows10
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/Kanit.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="FrontPageF_G.html">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <script src="js/bootstrap.bundle.min.js"></script>
        <section class="hero-section">
            <div class="hero-overlay"></div>
            <div class="container mt-4" style="font-family: kanit;">
                <div class="row g-4">

                    <c:forEach var="c" items="${courses}" varStatus="s">
                        <div class="col-md-3 mb-4"> <div class="card h-100 d-flex flex-column">
                                <img src="img/${c.picture}" class="card-img-top" alt="${c.courseName}" style="height: 200px; object-fit: cover;">

                                <div class="card-body d-flex flex-column flex-grow-1">
                                    <h5 class="card-title" style="color: #0050ff">
                                        ${c.courseName}
                                    </h5>
                                    <br>
                                    <div class="mb-2">
                                        <p class="card-text mb-1">📅 <strong>วันเรียน : </strong>${c.days}</p>
                                        <p class="card-text mb-0">⏰ <strong>เวลา : </strong>${c.times}</p>
                                    </div>
                                </div>

                                <div class="card-footer bg-white border-0 mt-auto pb-3">
                                    <button class="btn btn-outline-secondary w-100" disabled>
                                        🔒 เข้าสู่ระบบเพื่อจองที่นั่ง
                                    </button>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
    </section>
</body>
</html>
