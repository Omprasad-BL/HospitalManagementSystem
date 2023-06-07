package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Doctor;
import dto.Staff;
@WebServlet("/FetchAllStaff")
public class FetchAllStaff  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Dao dao=new Dao();
		List<Staff> list= dao.fetcAllStaff();
		
		if (list.isEmpty()) {
			resp.getWriter().print("<h1> Nothing is Here </h1>");
			req.getRequestDispatcher("Admin.jsp").include(req, resp);
		}
		else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("ApproveStaff.jsp").include(req, resp);
		}
		
		
		}
	

}
