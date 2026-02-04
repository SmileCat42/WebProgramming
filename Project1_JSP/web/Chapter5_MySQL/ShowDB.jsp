<%-- 
    Document   : ShowDB
    Created on : Dec 13, 2025, 2:47:44 PM
    Author     : Windows10
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShowData from MySQL</title>
        <style>
        table{
                font-size: 20px;
                background: lightgreen;
                border: midnightblue;
        }
        tr,td{
            padding: 12px 20px;
        }
        </style>
    </head>
    <body>
        <jsp:include page="../FrontPage.html">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <div class="content">
            <hr>
                <h1 style="font-size: 40px; color: darkolivegreen; font-family: kanit; text-align: center">ข่าวสาร</h1>
                <hr><br>
        <table border>
            <tr style="font-size: 30px; background: darkgreen; color:white; padding: 18px 25px;">
                <th>วันที่</th>
                <th>เรื่อง</th>
                <th>รายละเอียด</th>
            </tr>
            

        <%
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                } catch (Exception e) {
                }
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/news?allowPublicKeyRetrieval="
                            + "true&useSSL=false", "root", "Golfring02");
                    Statement s = c.createStatement();
                    ResultSet r = s.executeQuery("Select * from school");
                    while (r.next()) {
        %> 
    <tr>
        <td><%=r.getString("วันที่")%></td>
        <td><%=r.getString("เรื่อง")%></td>
        <td><%=r.getString("รายละเอียด")%></td>
    </tr>
    <%

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
        </div>
    </body>
</html>
