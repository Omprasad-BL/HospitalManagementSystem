package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/login")
public class Login extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("username"));
	String psw= req.getParameter("passowrd");
	
	Dao dao=new Dao();
	Doctor doctor=dao.fetcDoctor(id);
	Staff staff=dao.fetcStaff(id);
	if(staff==null&& doctor==null && id!=999999) {
		resp.getWriter().print("<h1> Incorrect id </h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
	else {
		
		if(staff!=null) {
			if(staff.getPassowrd().equals(psw)) {
			resp.getWriter().print("<h1> staff success </h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1> staff success </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		if(doctor!=null) {
			if(doctor.getPassowrd().equals(psw)) {
			resp.getWriter().print("<h1> Doctor staff </h1>");
			req.getRequestDispatcher("DoctorHome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1> staff success </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		
		if(id==999999) {
			if("999999"==psw) {
				resp.getWriter().print("<h1> Success </h1>");
				req.getRequestDispatcher("AdminHome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1> staff success </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}
		}
		
		
	}
	
}
	
}
