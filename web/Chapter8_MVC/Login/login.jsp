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
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?autoReconnect=true&useSSL=false", "root", "1234");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from resume where name='" + userid + "' and surname='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);//rs.getString("name")
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.html'>try again</a>");
    }
%>