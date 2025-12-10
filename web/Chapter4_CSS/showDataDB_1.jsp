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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Surname</th>
            </tr>
            

        <%
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                } catch (Exception e) {
                }
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test?allowPublicKeyRetrieval=true&useSSL=false", "root", "Golfring02");
                    Statement s = c.createStatement();
                    ResultSet r = s.executeQuery("Select * from Resume1");
                    //out.print("**********************************************************<br>");
                    //out.print("     ID        Name           Surname        Address      <br>");
                    //out.print("**********************************************************<br>");
                   // java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                    while (r.next()) {
        %>
    <tr>
        <td><%=r.getString("Id")%></td>
        <td><%=r.getString("Name")%></td>
        <td><%=r.getString("Surname")%></td>
        <td><%=r.getString("Address")%></td>   
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
