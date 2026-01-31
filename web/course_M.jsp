
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/Kanit.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="FrontPageF_M.jsp">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <script src="js/bootstrap.bundle.min.js"></script>
        <section class="hero-section">
            <div class="hero-overlay"></div>
            <div class="container mt-4" style="font-family: kanit;">
                <div class="row g-4">

                    <c:forEach var="c" items="${courses}" varStatus="s"> 
                        <div class="col-md-3" >
                            <div class="card h-100">
                                <img src="img/${c.picture}" class="card-img-top" alt="${c.courseName}" style="height: 200px; object-fit: cover;">
                                    <div class="card-body d-flex flex-column flex-grow-1">
                                        <h5 class="card-title" style="color: #0050ff">
                                            ${c.courseName}
                                        </h5>
                                        <hr> <div class="mb-3"> <p class="card-text mb-2">📅 <strong>วันเรียน : </strong>${c.days}</p>
                                            <p class="card-text mb-2">⏰ <strong>เวลา : </strong>${c.times}</p>
                                            <p class="card-text mb-0">🖥 <strong>ที่นั่ง : </strong>${c.current}/${c.max}</p>
                                        </div>
                                    </div>

                                    <div class="card-footer bg-white border-0">
                                        <button class="btn btn-info w-100 text-white fw-bold" 
                                                onclick="openBookingModal('${c.courseId}', '${c.courseName}', '${c.days}')">
                                            ลงทะเบียนเรียน
                                        </button>
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
    <div class="modal fade" id="bookingModal" tabindex="-1" aria-labelledby="bookingModalLabel" aria-hidden="true" style="font-family: kanit;">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header bg-primary text-white">
                    <h5 class="modal-title" id="bookingModalLabel border-0">ยืนยันการลงทะเบียน</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <p class="fs-5 mb-1" id="modalCourseName" style="color: #0050ff; font-weight: bold;"></p>
                    <p id="modalCourseDays" class="text-primary fw-bold small"></p>
                    <p class="text-muted">กรุณาเลือกวันที่สะดวกเข้าเรียน</p>
                    <hr>

                    <input type="hidden" id="hiddenCourseId">

                    <div id="sessionButtonsContainer" class="d-grid gap-3">
                        <div class="text-center">
                            <div class="spinner-border text-primary" role="status">
                                <span class="visually-hidden">Loading...</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer border-0">
                    <button type="button" class="btn btn-light w-100" data-bs-dismiss="modal">ยกเลิก</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        function openBookingModal(courseId, courseName, courseDays) {
            document.getElementById('modalCourseName').innerText = courseName;
            document.getElementById('modalCourseDays').innerText = courseDays;
            document.getElementById('hiddenCourseId').value = courseId;

            const container = document.getElementById('sessionButtonsContainer');
            container.innerHTML = 'กำลังโหลดรอบเรียน...'; // ใส่ Loading รอไว้

            // ไปดึงข้อมูล Session จริงๆ จาก Database
            fetch('GetSessions?courseId=' + courseId)
                    .then(response => response.json())
                    .then(sessions => {
                        container.innerHTML = ''; // ล้างคำว่า Loading ออก

                        if (sessions.length === 0) {
                            container.innerHTML = '<p class="text-danger">ยังไม่มีรอบเรียนที่เปิดสอน</p>';
                            return;
                        }

                        sessions.forEach(s => {
                            const btn = document.createElement('button');
                            btn.type = 'button';
                            btn.className = 'btn btn-outline-primary py-2 text-start';
                            // โชว์ทั้ง วัน และ เวลา บนปุ่ม
                            btn.innerHTML = `🗓️ รอบวัน${s.sessionDate} (${s.sessionTime})`;

                            // เมื่อกดปุ่ม ให้ส่ง sessionId ไปบันทึกการจอง
                            btn.onclick = function () {
                                executeBooking(s.sessionId);
                            };

                            container.appendChild(btn);
                        });
                    });

            var myModal = new bootstrap.Modal(document.getElementById('bookingModal'));
            myModal.show();
        }
    </script>
</body>
</html>
