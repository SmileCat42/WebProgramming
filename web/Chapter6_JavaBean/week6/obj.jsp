<%-- 
    Document   : obj
    Created on : Dec 23, 2025, 12:09:20 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="First.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Country Thailand = new Country();
            Thailand.setName("Thailand");
            Thailand.setSize(60);
            out.println("Name : "+Thailand.getName()+"<br>Size : "+Thailand.getSize());
        %>
    </body>
</html>
