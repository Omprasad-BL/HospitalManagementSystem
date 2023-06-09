<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="dto.Staff" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% List<Staff> list = (List<Staff>) request.getAttribute("list");%>
<table border="1">
   <tr>
   <td>Id </td>
   <td>Name</td>
   <td>Mobile</td>
   <td>Status</td>
   <td>Change status</td>
   </tr>
   
   <%   for(Staff staff:list){  %>
   
	   <tr>
	   <th><%= staff.getId() %></th>
	   	   <th><%= staff.getName()%></th>
	   	   <th><%= staff.getMobile()%></th>
	   	   <th><%= staff.isStatus()%></th>
	   	   	<th> <button > <a href="ChangeStaffStatus?id=<%=staff.getId()%>">Change</a> </button> </th>
	     	   </tr>   
	   
 <% }
   %>
</table>
</body>
</html>