<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="dto.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% List<Doctor> list = (List<Doctor>) request.getAttribute("list");%>

<table border="1">
   <tr>
   <td>Id </td>
   <td>Name</td>
   <td>Mobile</td>
   <td>Status</td>
   <td>Change status</td>
   </tr>
   
   <%   for(Doctor doctor:list){  %>
   
	   <tr>
	   <th style="color:red"><%= doctor.getId() %></th>
	   	   <th><%= doctor.getName()%></th>
	   	   <th><%= doctor.getMobile()%></th>
	   	   <th><%= doctor.isStatus()%></th>
	   	   	<th> <button type="submit"> <a href="ChangeDoctorStatus?id=<%= doctor.getId()%>">Change</a> </button> </th>
	     	   </tr>   
	   
 <% }
   %>
</table>
</body>
</html>