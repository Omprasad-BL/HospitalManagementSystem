package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Staff;

@WebServlet("/staffSignUp")
public class StaffSignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	int id= Integer.getInteger(req.getParameter("")a);
    	String name=req.getParameter("name");
    	long mobile= Long.parseLong(req.getParameter("mobile"));
    	String email= req.getParameter("email");
    	String password= req.getParameter("password");
    	Date dob=Date.valueOf(req.getParameter("dob"));
    	String gender= req.getParameter("gender");
    	Dao access= new Dao();
    	Staff staff=new Staff();

    	if (access.searchByMobile(mobile)==null && access.searchByEmail(email)==null) {
			
    
            	
//    	int age= LocalDate.now().getYear()-dob.toLocalDate().getYear();   Approximate
//    	Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
    	
    	staff.setName(name);
    	staff.setMobile(mobile);
    	staff.setEmail(email);
    	staff.setDob(dob);
    	staff.setPassowrd(password);
    	staff.setGender(gender);
    	
    	
//    	Dao access= new Dao();
    	access.saveStaff(staff);
    	
//    	resp.getWriter().print("<h1>Data saved Successfully</h1>");
    	resp.getWriter().print("<h1> your id is "+ staff.getId()  +"</h1>");
    	
    	req.getRequestDispatcher("Login.html").include(req, resp);
    	}
    	else {
//    		resp.getWriter().print("<h1>Data already exist</h1>");
        	resp.getWriter().print("<h1> your id is "+ staff.getId()  +"</h1>");
        	
        	req.getRequestDispatcher("Login.html").include(req, resp);
    	}
    	 
    	
    }
}
