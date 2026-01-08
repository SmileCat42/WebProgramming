<%-- 
    Document   : reg
    Created on : 13-May-2016, 10:15:14
    Author     : ComSCIv3400
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="registration.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="user" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td>ชื่อจริง</td>
                        <td><input type="text" name="fnamel" value="" /></td>
                    </tr>
                    <tr>
                        <td>นามสกุล</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>อีเมล</td>
                        <td><input type="password" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>วันเดือนปีเกิด</td>
                        <td><input type="password" name="birth" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.html">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
