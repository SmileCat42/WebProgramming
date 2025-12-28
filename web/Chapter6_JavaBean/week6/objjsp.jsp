<%-- 
    Document   : objjsp
    Created on : Dec 27, 2025, 7:22:08 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Thailand" scope="page" class="First.Country">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaBean</title>
    </head>
    <body>
        <h1>JSP only</h1>
        <jsp:setProperty id="Thailand" Property="name" Value="Thai"/>
        <jsp:getProperty id="Thailand" Property="size" />
    </body>
</html>
