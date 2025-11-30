<%-- 
    Document   : showope
    Created on : Nov 30, 2025, 10:05:05 AM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Operator</title>
    </head>
    <body style="font-size: 2em; color: blueviolet">
        <h1>Result</h1><br>
        <%
            String x1=request.getParameter("num1");
            String y1=request.getParameter("num2");
            int x=Integer.parseInt(x1);
            int y=Integer.parseInt(y1);
        %>
        <%
            out.println("num1 + num2 = "+(x+y)+"<br>");
            out.println("num1 - num2 = "+(x-y)+"<br>");
            out.println("num1 * num2 = "+(x*y)+"<br>");
            out.println("num1 / num2 = "+(x/y)+"<br>");
        %>
    </body>
</html>
