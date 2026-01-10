<%-- 
    Document   : login
    Created on : 13-May-2016, 09:47:50
    Author     : ComSCIv3400
--%>

<%@ page import ="java.sql.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?autoReconnect=true&useSSL=false", "root", "Golfring02");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from list where user='" + userid + "' and pass='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);//rs.getString("name")
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.html'>try again</a>");
    }
%>