<%-- 
    Document   : newSave
    Created on : 01-Mar-2016, 12:29:30
    Author     : ComSCIv3400
--%>

<%@page import="java.sql.*" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         //   response.setContentType("text/xml;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");%>
        <%	
            request.setCharacterEncoding("UTF-8");
	Connection connect = null;
	Statement s = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		connect =  DriverManager.getConnection("jdbc:mysql://localhost/test1?autoReconnect=true&useSSL=false","root", "1234");
		
		s = connect.createStatement();
		
		String Id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Surname= request.getParameter("Surname");
		String Address = request.getParameter("Address");

                String sql = "UPDATE resume " +
				"SET Name = '"+ Name + "' " +
				", Surname = '"+ Surname + "' " +
				", Address = '"+ Address + "' " +
				" WHERE id = '" + Id + "' ";
                out.println(sql);
         s.execute(sql);
         out.println("Record Update Successfully");       
         response.sendRedirect("showData_index.jsp");
	  		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	
		try {
			if(s!=null){
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
    </body>
</html>
