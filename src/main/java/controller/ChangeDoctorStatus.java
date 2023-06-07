 package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Doctor;
import dto.Doctor;
@WebServlet("/ChangeDoctorStatus")
public class ChangeDoctorStatus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= Integer.parseInt(req.getParameter("id"));
		Dao dao= new Dao();
		Doctor doctor=dao.fetcDoctor(id);
		if (doctor.isStatus()) {
			doctor.setStatus(false);
			
		}
		else {
			doctor.setStatus(true);
			
			dao.updateDoctor(doctor);
			resp.getWriter().print("<h1>Updated successfully </h1>");
			req.setAttribute("list", dao.fetcAllDoctor());
			req.getRequestDispatcher("ApproveDoctor.jsp").include(req, resp);
		}
		
	}
	

}
