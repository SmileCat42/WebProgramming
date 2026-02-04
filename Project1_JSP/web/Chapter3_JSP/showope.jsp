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
        <h1>Result Page</h1><br>
        <%
            String n1=request.getParameter("numberone");
            String n2=request.getParameter("numbertwo");
            int result1=Integer.parseInt(n1)+Integer.parseInt(n2);
            int result2=Integer.parseInt(n1)-Integer.parseInt(n2);
            int result3=Integer.parseInt(n1)*Integer.parseInt(n2);
            int result4=Integer.parseInt(n1)/Integer.parseInt(n2);
        %>
        <%
            out.println("number 1 : "+n1+"<br>");
            out.println("number 2 : "+n2+"<br><br>");
            out.println("Plus result :  "+result1+"<br>");
            out.println("Minus result : "+result2+"<br>");
            out.println("Multyply result : "+result3+"<br>");
            out.println("Divide result : "+result4+"<br>");
        %>
    </body>
</html>
