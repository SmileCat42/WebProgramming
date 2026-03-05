<%-- 
    Document   : Input
    Created on : Dec 13, 2025, 5:28:50 PM
    Author     : Windows10
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Write Detail</title>
    </head>
    <body>
        <jsp:include page="../FrontPage.html">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <div class="content">
            <hr>
            <h1 style="color: green; font-family: kanit; font-size: 35px; text-align: center;">
                แก้ไขรายชื่อ
            </h1>
            <hr><br>

            <form action="mvc?action=update" method="post">

                <input type="hidden" name="id" value="${resume.id}">

                First Name
                <input type="text" name="fname" value="${resume.name}"><br>

                Last Name
                <input type="text" name="lname" value="${resume.surname}"><br>

                Grade
                <input type="text" name="grade" value="${resume.grade}"><br>

                <button type="submit">Update</button>

            </form>


        </div>
    </body>
</html>
