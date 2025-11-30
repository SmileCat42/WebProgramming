<%-- 
    Document   : Param
    Created on : Nov 30, 2025, 4:12:12 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Include & Param</title>
    </head>
    <body>
        <jsp:include page="T1.jsp">
            <jsp:param name="name" value="Krittaya"/>
            <jsp:param name="sur" value="tantichaiyakul"/>
        </jsp:include>
    </body>
</html>
