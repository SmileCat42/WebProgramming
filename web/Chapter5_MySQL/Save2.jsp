<%-- 
    Document   : Save
    Created on : Sep 5, 2024, 2:13:22 PM
    Author     : chouv
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input</title>
    </head>
    <body>
        <h1>เสนอรายชื่อ</h1>
        <%
             request.setCharacterEncoding("UTF-8");
            String SQL = "Insert into stu(id,cc,fname,lname,grade) values("
                    + request.getParameter("id") + ",'" + request.getParameter("เด็กชาย")
                    + "','" + request.getParameter("fname")
                    + "','" + request.getParameter("lname") + "','" + request.getParameter("grade") + "')";
//****************************************
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
            }
            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost/good?allowPublicKeyRetrieval=true&useSSL=false", "root", "Golfring02");
                Statement s = c.createStatement();
                s.execute(SQL);
                out.print(SQL+"<br>");
                out.print("Save Data OK.<br>");
                s.close();
            } catch (SQLException e) {
            }
        %>
        <br>
        <a href="Incraese.jsp" target="_blank"> กลับไปหน้าเดิม</a>
    </body>
</html>
