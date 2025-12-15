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
            <form action="Save2.jsp" method="GET">
            ID : <br><input type="text" name="id" value="" size="50" /><br> 
            First Name :<br><input type="text" name="fname" value="" size="50" /><br>
            Last Name :<br><input type="text" name="lname" value="" size="10" /><br>
            Grade :<br><input type="text" name="grade" value="" size="5" /><br><br>
            <input style="background: lightgoldenrodyellowyellow" type="submit" value="ส่ง"/><br>
        </form>
        </div>
    </body>
</html>
