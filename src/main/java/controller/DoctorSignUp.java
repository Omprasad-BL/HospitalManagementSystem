package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/doctorSignUp")
	public class DoctorSignUp  extends HttpServlet{
	   @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    	int id= Integer.getInteger(req.getParameter("")a);
	    	String name=req.getParameter("name");
	    	long mobile= Long.parseLong(req.getParameter("mobile"));
	    	String email= req.getParameter("email");
	    	String password= req.getParameter("password");
	    	Date dob=Date.valueOf(req.getParameter("date"));
	    	String gender= req.getParameter("gender");
	    	String qualification=req.getParameter("qualification");
	    	String specification=req.getParameter("specialization");
	    	Doctor doctor=new Doctor();
	    	Dao access= new Dao();


	    	if (access.searchByDoctorMobile(mobile)==null && access.searchByDoctorEmail(email)==null) {
				
	    
	            	
//	    	int age= LocalDate.now().getYear()-dob.toLocalDate().getYear();   Approximate
//	    	Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
	    	doctor.setName(name);
	    	doctor.setMobile(mobile);
	    	doctor.setEmail(email);
	    	doctor.setPassowrd(password);
	    	doctor.setDob(dob);
	    	doctor.setGender(gender);
	    	doctor.setQualification(qualification);
	    	doctor.setSpecialization(specification);
	    
	    	
	    	
//	    	Dao access= new Dao();
	    	access.saveDoctor(doctor);
	    		
	    	resp.getWriter().print("<h1>Waiting for Approval</h1>");
	    	resp.getWriter().print("<h1> your id is "+ doctor.getId()  +"</h1>");
	    	
	    	req.getRequestDispatcher("Login.html").include(req, resp);
	    	}
	    	else {
	    		resp.getWriter().print("<h1>Data already exist</h1>");
	        	resp.getWriter().print("<h1> your id is "+ doctor.getId()  +"</h1>");
	        	
	        	req.getRequestDispatcher("Login.html").include(req, resp);
	    	}
	    	 
	    	
	    }
}
