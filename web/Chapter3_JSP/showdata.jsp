<%-- 
    Document   : newjsp
    Created on : Nov 25, 2025, 1:12:22 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name = request.getParameter("fname");
            String surname = request.getParameter("lname"); 
        %>
    </body>
</html>
