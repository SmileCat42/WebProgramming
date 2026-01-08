<%-- 
    Document   : logout
    Created on : 13-May-2016, 10:25:48
    Author     : ComSCIv3400
--%>

<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("index.html");
%>
