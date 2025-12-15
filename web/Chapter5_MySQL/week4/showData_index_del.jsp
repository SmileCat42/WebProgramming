<%-- 
    Document   : showData
    Created on : 01-Mar-2016, 10:33:46
    Author     : ComSCIv3400
--%>
<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1>Hello World!</h1>
    <%
       // request.setCharacterEncoding("UTF-8");
             // response.setContentType("text/xml;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/good?autoReconnect=true&useSSL=false", "root", "Golfring02");
        Statement s = c.createStatement();
        ResultSet rec = s.executeQuery("Select * from stu");
    %>


    <table width="600" border="1">
        <tr>
            <th width="91"> <div align="center">ID </div></th>
            <th width="98"> <div align="center">Name </div></th>
            <th width="198"> <div align="center">Surname </div></th>
            <th width="97"> <div align="center">Grade </div></th>
            <th width="71"> <div align="center">Delete </div></th>
        </tr>	
        <%while ((rec != null) && (rec.next())) {%>
        <tr>
            <td><div align="center"><%=rec.getString("id")%></div></td>
            <td><%=rec.getString("fname")%></td>
            <td><%=rec.getString("lname")%></td>
            <td><div align="center"><%=rec.getString("grade")%></div></td>
            <td align="center"> <a href="delete_frm.jsp?id=<%=rec.getString("id")%>">ลบ</a></td>
        </tr>
        <%}%>
    </table>      

    <% //while(r.next()) 
        // out.print("ID:"+r.getString("Id")+"   Name:"+r.getString("Name")+ " Surname:"+r.getString("Surname")+ 
        //     "   Address:"+r.getString("Address")+"<br>");       
        // s.close(); 
        // r.close(); 

    %>

</html>
