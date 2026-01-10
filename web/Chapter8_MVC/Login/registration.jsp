<%-- 
    Document   : registration
    Created on : 13-May-2016, 10:20:19
    Author     : ComSCIv3400
--%>

<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<%  
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String User = request.getParameter("user");    
    String Pwd = request.getParameter("pass");
    String Fname = request.getParameter("fname");
    String Lname = request.getParameter("lname");
    String Email = request.getParameter("email");
    String Birth = request.getParameter("birth");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false&serverTimezone=UTC",
            "root", "Golfring02");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into list(user, pass, fname, lname, email, birth) values('"
+ User + "', '"
+ Pwd + "', '"
+ Fname + "', '"
+ Lname + "', '"
+ Email + "', '"
+ Birth + "')");
    
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.html");
    }
%>