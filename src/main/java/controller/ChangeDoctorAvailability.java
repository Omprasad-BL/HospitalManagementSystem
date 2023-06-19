package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Doctor;

@WebServlet("/changedoctoravailable")
public class ChangeDoctorAvailability extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctor =(Doctor) req.getSession().getAttribute("doctor");
		
		Dao dao=new Dao();
		
		if(doctor==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else {
			if(doctor.isAvailable())
			{
				doctor.setAvailable(false);
				dao.updateDoctor(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1>Changed to Not Available</h1>");
				req.getRequestDispatcher("DoctorHome.html").include(req, resp);
			}
			else {
				doctor.setAvailable(true);
				dao.updateDoctor(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1>Changed to Available</h1>");
				req.getRequestDispatcher("DoctorHome.html").include(req, resp);
			}
		}
	}
}
