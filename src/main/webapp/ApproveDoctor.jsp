<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="dto.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  table, td{
	table-layout: auto;

  }
  th,td{
  border:1px solid black;
  padding: 10px;
  }

  table{
	background-color: #095d7e;
  }

  body{
        display: grid;
        height: 100svh;
        width: 100svw;
        justify-content: center;
        align-items: center;
        background-color: #095d7e;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 20px;
    }
table{
    display: grid;
    gap: 10px;
    text-align:center;
    padding: 10px;
    justify-content: center;
    font-size: 20px;
    align-items: center;
    background-color: #256D85;
    border-radius: 10px;
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;

}
*{
	color: white;
	font-family: Arial, Helvetica, sans-serif;
	text-transform: capitalize;
}

/* CSS */
.button-15 {
    width: max-content;
    margin: 5px;
    text-decoration: none;
  background-image: linear-gradient(#42A1EC, #0070C9);
  border: 1px solid #0077CC;
  border-radius: 4px;
  box-sizing: border-box;
  color: #FFFFFF;
  cursor: pointer;
  direction: ltr;
  display: block;
  font-family: "SF Pro Text","SF Pro Icons","AOS Icons","Helvetica Neue",Helvetica,Arial,sans-serif;
  font-size: 17px;
  font-weight: 400;
  letter-spacing: -.022em;
  line-height: 1.47059;
  min-width: 30px;
  overflow: visible;
  padding: 4px 15px;
  text-align: center;
  vertical-align: baseline;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  white-space: nowrap;
}

.button-15:disabled {
  cursor: default;
  opacity: .3;
}

.button-15:hover {
  background-image: linear-gradient(#51A9EE, #147BCD);
  border-color: #1482D0;
  text-decoration: none;
}

.button-15:active {
  background-image: linear-gradient(#3D94D9, #0067B9);
  border-color: #006DBC;
  outline: none;
}

.button-15:focus {
  box-shadow: rgba(131, 192, 253, 0.5) 0 0 0 3px;
  outline: none;
}
.button-15{
margin:auto;}
</style>
</head>
<body>


<% List<Doctor> list = (List<Doctor>) request.getAttribute("list");%>

<table>
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
	   	   	<th>  <a href="ChangeDoctorStatus?id=<%= doctor.getId()%>" class="button-15">Change</a> </th>
	     	   </tr>   
	   
 <% }
   %>
</table>
<a href="Admin.jsp" class="button-15">Back</a>
</body>
</html>