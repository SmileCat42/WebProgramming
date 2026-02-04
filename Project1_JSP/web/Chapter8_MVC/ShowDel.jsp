<%-- 
    Document   : showData
    Created on : 01-Mar-2016, 10:33:46
    Author     : ComSCIv3400
--%>
<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Resume" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1 style="text-align: center; font-family: kanit; font-size: 35px; color: firebrick">จัดการรายชื่อ</h1>


    <table width="600" border="1">
        <tr>
            <th width="91"> <div align="center">ID </div></th>
            <th width="98"> <div align="center">Name </div></th>
            <th width="198"> <div align="center">Surname </div></th>
            <th width="97"> <div align="center">Grade </div></th>
            <th width="71"> <div align="center">Delete </div></th>
        </tr>
        <%
            List<Resume> list = (List<Resume>) request.getAttribute("list");
            if (list != null) {
                for (Resume r : list) {
        %>	
        <tr>
            <td><%=r.getCC()%></td>
            <td><%=r.getName()%></td>
            <td><%=r.getSurname()%></td>
            <td><div align="center"><%=r.getGrade()%></div></td>
            <td align="center"> <a href="mvc?action=delete&id=<%=r.getId()%>">ลบ</a></td>
        </tr>
        <% }} %>
    </table>      
    <br><br>
    <a href="DataBase.jsp"> กลับไปที่รายชื่อ</a>
    <% //while(r.next()) 
        // out.print("ID:"+r.getString("Id")+"   Name:"+r.getString("Name")+ " Surname:"+r.getString("Surname")+ 
        //     "   Address:"+r.getString("Address")+"<br>");       
        // s.close(); 
        // r.close(); 

    %>

</html>
