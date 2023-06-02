package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RoleType")
public class SelectRole extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= req.getParameter("role");
		if(name.equals("doctor")) {
		req.getRequestDispatcher("DoctorSignUp.html").forward(req, resp);	

		}
		else {
			req.getRequestDispatcher("StaffSignUp.html").forward(req, resp);	
		}
	}

}
