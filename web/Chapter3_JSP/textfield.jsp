<%-- 
    Document   : textfield
    Created on : Nov 25, 2025, 12:59:26 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>กรุณากรอกข้อมูล</h1><br>
        <form action="showdata.jsp">
            <label for="fname">First name:</label><br>
            <input type="text" id="fname" name="fname"><br>
            <label for="lname">Last name:</label><br>
            <input type="text" id="lname" name="lname"><br><br><br>
            <input type= "submit" value="Enter" name="input" />
        </form>
    </body>
</html>
