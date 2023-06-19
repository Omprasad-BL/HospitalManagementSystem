package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.*;
import dao.Dao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/login")
public class Login extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("username"));
	String psw= req.getParameter("password");
	

	Dao dao=new Dao();
	Doctor doctor=dao.fetchDoctor(id);
	Staff staff=dao.fetcStaff(id);
	
	
	
	
//	IF CONDITION
	if(staff==null&& doctor==null && id!=999999) {
		resp.getWriter().print("<h1> Incorrect id </h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
//	ELSE CONDITION
	
	else {
		
//		STAFF LOGIN CONDITION
		
		if(staff!=null) {
			if(staff.getPassowrd().equals(psw)) {
				if (staff.isStatus()) {
				req.getSession().setAttribute("staff", staff);
//				PASSING STAFF AS SESSION OBJECT
				
			resp.getWriter().print("<h1> staff success </h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1> wait for controller approval</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
			}
			else {
				resp.getWriter().print("<h1> wrong password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
			
		}
		
		
		
//		DOCTOR LOGIN CONDITION
		
		
		if(doctor!=null) {
			if(doctor.getPassowrd().equals(psw)) {
				if (doctor.isStatus()) {
//					Add session
					req.getSession().setAttribute("doctor", doctor);
			resp.getWriter().print("<h1> Doctor success </h1>");
			req.getRequestDispatcher("DoctorHome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1> wait for approval </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
			}
			else {
				resp.getWriter().print("<h1> wrong password</h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		
		
//		ADMIN LOGIN CONDITION
		
		
		if(id==999999) {
			if(psw.equals("999999")) {
//				session for controller
//				String controller="controller";
//				req.getSession().setAttribute("controller", controller);
				req.getSession().setAttribute("admin", "admin");


				resp.getWriter().print("<h1> Success </h1>");
				req.getRequestDispatcher("Admin.jsp").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>wrong passowrd </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		
		
	}
	
}
	
}
