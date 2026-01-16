<%@ page import="java.util.*,model.Resume" %>
<h2>Resume List</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Surname</th><th>Address</th><th>Action</th></tr>
<%
List<Resume> list=(List<Resume>)request.getAttribute("list");
for(Resume r:list){
%>
<tr>
<td><%=r.getId()%></td>
<td><%=r.getName()%></td>
<td><%=r.getSurname()%></td>
<td><%=r.getAddress()%></td>
<td><a href="resume?action=delete&id=<%=r.getId()%>">Delete</a></td>
</tr>
<% } %>
</table>
<a href="index.jsp">Add New</a>