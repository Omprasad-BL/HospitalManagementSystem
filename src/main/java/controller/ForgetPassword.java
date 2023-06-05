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
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		long mobile= Long.parseLong(req.getParameter("mobile"));
		Date  date= Date.valueOf(req.getParameter("dob"));
		String password= req.getParameter("passowrd");
		
		Dao dao= new Dao();
		Doctor doctor= dao.fetcDoctor(id);
		Staff staff=dao.fetcStaff(id);
		if (staff==null && doctor==null) {
			resp.getWriter().print("<h1> invalid </h1>");
			req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
			
		}
		else {
			if (doctor!=null) {
				if (  doctor.getName().equals(name) && doctor.getMobile()==mobile && doctor.getDob().equals(date)
						&& doctor.getId()==id
						) {
					doctor.setPassowrd(password);
					dao.updateDoctor(doctor);
					resp.getWriter().print("<h1> Updated</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
					
				}
				else {
					resp.getWriter().print("<h1> invalid Details</h1>");
					req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
				}
				
			}
			
			
			else {
				
				if (staff!=null) {
					if ( staff.getName().equals(name) && staff.getMobile()==mobile && staff.getDob().equals(date)
							&& staff.getId()==id
							) {
						staff.setPassowrd(password);
						dao.updateStaff(staff);
						
					}
					else {
						resp.getWriter().print("<h1> invalid staff details </h1>");
						req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
						
					}
				}
			}
		}
		
	}
	

}
