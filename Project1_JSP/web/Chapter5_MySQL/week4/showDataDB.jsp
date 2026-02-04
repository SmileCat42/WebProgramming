<%-- 
    Document   : showDataDB
    Created on : Sep 5, 2024, 1:09:03 PM
    Author     : chouv
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MySQL&JSP</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (Exception e) {
                }
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/students2568?allowPublicKeyRetrieval=true&useSSL=false", "root", "Golfring02");
                    Statement s = c.createStatement();
                    ResultSet r = s.executeQuery("Select * from stu");
                    out.print("**********************************************************<br>");
                    out.print("     ID        Name           Room       Teacher      <br>");
                    out.print("**********************************************************<br>");
                    while (r.next()) {
                        out.print("  " + r.getString("Id") + "   " + r.getString("Name") + "     " + r.getString("Room")
                                + "        " + r.getString("Teacher") + "<br>");
                    }
                    s.close();
                    r.close();
                } catch (SQLException e) {
                    out.print(e);
                }
            } finally {
                out.close();
            }
        %>
    </body>
</html>
