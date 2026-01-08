<%-- 
    Document   : registration
    Created on : 13-May-2016, 10:20:19
    Author     : ComSCIv3400
--%>

<%@ page import ="java.sql.*" %>
<%
    String id = request.getParameter("id");    
    String no = request.getParameter("no");    
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradsystem",
            "root", "");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into staflogin(no, id, name, password) values("+ no+", '"+ id + "','" + user + "','" + pwd + "')"); // ("+ no ", '" + id + "','" + user + "','" + pwd + "')");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.html");
    }
%>