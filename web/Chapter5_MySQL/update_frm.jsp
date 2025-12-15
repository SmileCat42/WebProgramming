<%-- 
    Document   : update_frm
    Created on : 01-Mar-2016, 11:28:07
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
        <h1>Hello World!</h1>
   <%
       //response.setContentType("text/xml;charset=UTF-8");
      request.setCharacterEncoding("UTF-8");
    Connection connect = null;
    Statement s = null;
    //      try {
    Class.forName("com.mysql.jdbc.Driver");
    connect = DriverManager.getConnection("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false", "root", "1234");
    s = connect.createStatement();
    String sql = "SELECT * FROM  resume WHERE id = '" + request.getParameter("id") + "'  ";
    ResultSet rec = s.executeQuery(sql);
    if (rec != null) {
       rec.next();
    %>
  <form name="frmUpdate" method="post" 
        action="newSave.jsp?id=<%=rec.getString("id")%>">	
            Update Form
            <table width="428" border="1">	
                <tr>
                    <th width="181">
                        <div align="left">id </div></th>
                    <td width="231"><%=rec.getString("id")%></td>
                </tr>
                <tr>
                    <th width="181">
                        <div align="left">Name </div></th>
                    <td><input type="text" name="Name" size="20" 
                               value="<%=rec.getString("Name")%>"></td>
                </tr>
                <tr>
                    <th width="181">
                        <div align="left">Surname </div></th>
                <td><input type="text" name="Surname" size="20" 
                           value="<%=rec.getString("Surname")%>"></td>
                </tr>
                <tr>
                    <th width="181">
                        <div align="left">Address </div></th>
                    <td><input type="text" name="Address" size="2" 
                               value="<%=rec.getString("Address")%>"></td>
                </tr>			
            </table> 
            <input type="submit" value="Save">
        </form> 

        <% } %>

        <% /*  } catch (Exception e) {
              // TODO Auto-generated catch block
              out.println(e.getMessage());
              e.printStackTrace();
          }

          try {
              if (s != null) {
                  s.close();
                  connect.close();
              }
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              out.println(e.getMessage());
              e.printStackTrace();
          }*/
        %>
    </body>
</html>
