<%@page import="dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dto.Patient"%>
<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int pid = Integer.parseInt(request.getParameter("id"));
		Dao dao = new Dao();
		Patient patient = dao.fetchPatient(pid);
		List<Appointment> list = patient.getAppointments();
		if (list.isEmpty()) {
			response.getWriter().print("<h1 style='color:red'>No Apppoinments Yet</h1>");
			request.setAttribute("list", dao.fetchAllPatient());
			request.getRequestDispatcher("ViewPatientHistory.jsp").include(request, response);
		} else {
	%>

	<h1>Appointment Details</h1>
	<table border="1">
		<tr>
			<th>Appointment Id</th>
			<th>Patient</th>
			<th>Problem</th>
			<th>Doctor</th>
			<th>Appointment Date</th>
		</tr>
		<%
			for (Appointment appointment : list) {
		%>
		<tr>
			<th><%=appointment.getId()%></th>
			<th><%=appointment.getPatient().getName()%></th>
			<th><%=appointment.getProblem()%></th>
			<th><%=appointment.getDoctor().getName()%></th>
			<th>
			<%if(appointment.getTime()==null) {%>
			Not Yet Visited Doctor
			<%}else{ %>
			<%=appointment.getTime()%>
			<%} %>
			</th>
		</tr>
		<%}%>
	</table>
	<br>
	<a href="adminfetcallpatient"><button>Back</button></a>
	<%} %>
</body>
</html>