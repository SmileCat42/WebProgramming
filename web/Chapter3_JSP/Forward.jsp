<%-- 
    Document   : Forward
    Created on : Nov 30, 2025, 11:26:15 AM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forward&If</title>
    </head>
    <body>
        <h1>Forward to other page</h1>
        <form name="check" action="checkforward.jsp">
            <label for="id">ID : </label><br>
            <input type="text" name="id" value="" /><br>
            <label for="pass">Password : </label><br>
            <input type="password" name="pass" value="" /><br><br>
            <input type="submit" value="enter" name="enter" />
        </form>
    </body>
</html>
