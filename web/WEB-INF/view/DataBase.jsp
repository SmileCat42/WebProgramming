<%-- 
    Document   : Incraese
    Created on : Dec 13, 2025, 4:19:56 PM
    Author     : Windows10
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Resume" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Increase</title>
        <style>
            table{
                align-items: center;
                font-size: 20px;
                background: lightgoldenrodyellow;
                text-align: center;
            }
            td{
                padding: 20px 30px;
            }
        </style>
        
    </head>
    <body>
        <jsp:include page="../FrontPage.html">
            <jsp:param name="name" value="Krittaya"/>
        </jsp:include>
        <div class="content">
            <hr>
                <h1 style="font-size: 40px; color: gold; font-family: kanit; text-align: center">นักเรียนดีเด่น</h1>
                <hr><br>
                <a href="InputIncrease.jsp" class="btn" style="background: brown"> เสนอรายชื่อนักเรียน</a><br>
                <a href="ShowDel.jsp" class="btn" style="background: pink"> จัดการรายชื่อ</a>
                <br>
        <table border>
            <tr style="font-size: 30px; background: yellow; color:orange; padding: 25px 35px;">
                <th>คำนำหน้า</th>
                <th>ชื่อ</th>
                <th>นามสกุล</th>
                <th>เกรด</th>
            </tr>
            <%
List<Resume> list=(List<Resume>)request.getAttribute("list");
if(list!=null){
for(Resume r:list){
%>
    <tr>
        <td><%=r.getCC()%></td>
        <td><%=r.getName()%></td>
        <td><%=r.getSurname()%></td>
        <td><%=r.getGrade()%></td>
    </tr>
    <% }} %>
    </table>
        </div>
    </body>
</html>
