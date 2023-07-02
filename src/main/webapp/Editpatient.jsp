<%@page import="dto.Patient"%>
<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		font-family: Arial, Helvetica, sans-serif;
      display: grid;
      height: 100svh;
      width: 100svw;
      align-items: center;
      background:#095d7e;
      justify-content: center;
      overflow: hidden;

	}
	form {
	display: grid;
	width: max-content;
	height:max-content;
	padding: 20px;
	justify-items: center;
	font-size: 20px;
	align-items: center;
	background-color: #256D85;
	border-radius: 10px;
	box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

input::placeholder,input {
    /* all: unset; */
	background-color: white;  /*This will apply the white background color of the placeholder*/
	color: gray;	/*This will set the gray color of the placeholder text*/
        text-align: center;   /*This will align the text of placeholder in the center*/
        padding:5px 5px;
        font-size: 15px;
        border: none;
        border-radius: 10px;
    } 
	/* CSS */
.button-15 {
    width: 100%;
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
input[name="id"]:focus{
outline:none;
border:3px double red;
}
</style>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); 
Dao dao=new Dao();
Patient patient=dao.fetchPatient(id);
if(patient==null)
{
	response.getWriter().print("<h1>Enter Valid id</h1>");
	request.getRequestDispatcher("Enterpatientid.html").include(request, response);
}
else{
%>

<form action="updatepatient" method="post">
<label for="id">Enter id</label><input type="text" name="id" name="id-data" value="<%=patient.getId()%>" readonly="readonly">
<label for="name">Enter Name</label><input type="text" id="name" name="name" value="<%=patient.getName()%>">

<label for="mobile">Mobile</label><input type="text" name="mobile" value="<%=patient.getMobile()%>" readonly="readonly">

<label for="dob">Date of Birth</label><input type="date" name="dob" value="<%=patient.getDob()%>">
<div class="buttons">
	<button type="submit" class="button-15">Update</button><button class="button-15" type="reset">Cancel</button>

</div>
</form>
<a href="EnterPatientid.html" class="button-15">Back</a>
<%} %>
</body>
</html>