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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
             request.setCharacterEncoding("UTF-8");
            String SQL = "Insert into Resume(id,name,surname,address) values("
                    + request.getParameter("id") + ",'" + request.getParameter("name")
                    + "','" + request.getParameter("surname") + "','" + request.getParameter("address") + "')";
//****************************************
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
            }
            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test1?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
                Statement s = c.createStatement();
                s.execute(SQL);
                out.print(SQL+"<br>");
                out.print("Save Data OK.<br>");
                s.close();
            } catch (SQLException e) {
            }
        %>
    </body>
</html>
