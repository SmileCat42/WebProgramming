<%-- 
    Document   : checkforward
    Created on : Nov 30, 2025, 11:31:33 AM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Forward</title>
    </head>
    <body>
        <%
            String x=request.getParameter("id");
            String y = request.getParameter("pass");
        %>
        <%
            out.println("Your ID : "+x+"<br>");
            out.println("Your Password : "+y+"<br>");
        %>
        <%
            if(x != null && y != null && x.equals("1234") && y.equals("1234")){
        %>
                <jsp:forward page="T1.jsp"/>
        <%
            }else {
        %>
                <jsp:forward page="T2.jsp"/>
        <%
            }
        %>
    </body>
</html>
