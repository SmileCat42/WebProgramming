<%-- 
    Document   : showPic
    Created on : Dec 16, 2025, 12:30:06 PM
    Author     : Windows10
--%>
<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Surname</th>
                <th>Picture</th>
            </tr>
            

        <%
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                } catch (Exception e) {
                }
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/good?allowPublicKeyRetrieval=true&useSSL=false", "root", "Golfring02");
                    Statement s = c.createStatement();
                    ResultSet r = s.executeQuery("Select * from pic");
                    java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                    //out.print("**********************************************************<br>");
                    //out.print("     ID        Name           Surname        Address      <br>");
                    //out.print("**********************************************************<br>");
                   // java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                    while (r.next()) {
        %> 
    <tr>
        <td><%=r.getString("id")%></td>
        <td><%=r.getString("name")%></td>
        <td><%=r.getString("surname")%></td>
        <td><%=r.getString("address")%></td>   
        <td>
            <%
                    byte[] imgData = r.getBytes("picture");
                    String base64Image = encoder.encodeToString(imgData);
                %>
                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="bak Image" style="width: 150px; height: auto;">
        </td>   
    </tr>
    <%
                    //    out.print("  " + r.getString("Id") + "   " + r.getString("Name") + "     " + r.getString("Surname")
                    //            + "        " + r.getString("Address") + "<br>");

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
</table>
    </body>
</html>
