<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body{
    height: 100svh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    font-family: Arial, Helvetica, sans-serif;
    background: #095d7e;
    margin: 0;
    gap: 0;
  }
  a{
    text-decoration: none;
    color: #f1f9ff;
    background:#14967f;
   padding:20px 30px;
   border-radius: 8px;
   margin: 10px;
  }
  a:hover{
    background: #095d7e;
  }
  a:active{
    background:#14967f;
  }

.container{
  display: flex;
  flex-direction: column;
  height: max-content;
  padding: 15px;
  width:max-content;
  justify-content: center;
  text-align: center;
  background:#ccecee;
  border-radius: 8px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px, rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
}
</style>
</head>
<body>
	<div class="container">
        <a href="fetchAllStaff">Approve Staff</a>
        <a href="fetchAllDoctor">Approve Doctor</a> 
        
        <a href="adminfetchallpatient">Fetch all patient</a> 
    <a href="logout">Logout</a>
    </div>
</body>
</html>