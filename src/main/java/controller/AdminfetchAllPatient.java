package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Patient;

@WebServlet("/adminfetchallpatient")
public class AdminfetchAllPatient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("admin")==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else{
			Dao dao=new Dao();
			List<Patient> list=dao.fetchAllPatient();
			if(list.isEmpty())
			{
				resp.getWriter().print("<h1 style='color:red'>No Patient Data Found</h1>");
				req.getRequestDispatcher("Admin.jsp").include(req, resp);
			}
			else{
				req.setAttribute("list", list);
				req.getRequestDispatcher("ViewPatientHistory.jsp").forward(req, resp);
			}
		}
	}

}


