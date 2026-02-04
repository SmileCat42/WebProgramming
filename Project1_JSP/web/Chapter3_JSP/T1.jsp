<%-- 
    Document   : T1
    Created on : Nov 30, 2025, 1:09:29 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login success</title>
    </head>
    <body background="BG9.jpg">
        <h1 style="font-size: 3em; color: lime">LOGIN SUCCESS</h1>
        <div style="color: black"><h2>WELCOME TO MY WORLD</h2></div>
        <%
            String x=request.getParameter("name");
            String y=request.getParameter("sur");
        %>
        <%= (x != null) ? x : "" %>
        <%= (y != null) ? y : "" %>
    </body>
</html>
