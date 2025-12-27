<%-- 
    Document   : mixed
    Created on : Dec 27, 2025, 7:30:52 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="thai1" scope="request" class="First.Country" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mixed</h1>
        <%
            out.println("Name : "+thai1.getName()+"<br>Size : "+thai1.getSize());
        %>
        <jsp:setProperty name="thai1" property="name" value="Thai"/>
        <jsp:setProperty name="thai1" property="size" value="70"/><br>
        
        Name : <jsp:getProperty name="thai1" property="name"/><br>
        Size : <jsp:getProperty name="thai1" property="size"/>
    </body>
</html>
