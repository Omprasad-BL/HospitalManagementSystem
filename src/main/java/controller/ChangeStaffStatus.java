 package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Staff;
@WebServlet("/ChangeStaffStatus")
public class ChangeStaffStatus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= Integer.parseInt(req.getParameter("id"));
		Dao dao= new Dao();
		Staff staff=dao.fetcStaff(id);
		if (staff.isStatus()) {
			staff.setStatus(false);
			
		}
		else {
			staff.setStatus(true);
			
			dao.updateStaff(staff);
			resp.getWriter().print("<h1>Updated successfully </h1>");
			req.setAttribute("list", dao.fetcAllStaff());
			req.getRequestDispatcher("ApproveStaff.jsp").include(req, resp);
		}
		
	}
	

}
