package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.SessionIdGenerator;

import Entity.Admin;
import Entity.Doctor;
import Entity.P;
import Service.AdminService;
import Service.PService;
import Service.doctorService;

public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();		
		String index = request.getParameter("index");
		if("p".equals(index)){
			PService service = new PService();
			P p = new P();
			String pno =request.getParameter("pno");
			String pwd = request.getParameter("ppwd");	
			if (service.loginP(pno, pwd)) {
				p = service.queryPByPno(pno);	
				session.setAttribute("p", p);
				response.sendRedirect("zhuzhan.jsp");
			}
			else {
				request.setAttribute("p", "0");
				request.getRequestDispatcher("zhuzhan.jsp").forward(request, response);
			}			
		}
		else if("doctor".equals(index)){
			doctorService service = new doctorService();
			Doctor doctor = new Doctor();
			String dno = request.getParameter("dno");
			String dpwd = request.getParameter("dpwd");		
			if (service.loginDoctor(dno, dpwd)) {
				doctor = service.queryDoctorByDno(dno);	
				session.setAttribute("doctor", doctor);
				response.sendRedirect("Doctor.jsp");
			}
			else {
				request.setAttribute("doctor", "0");	
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		else if("adm".equals(index)){
			AdminService service = new AdminService();
			String gno = request.getParameter("gno");
			String gpwd = request.getParameter("gpwd");
			if(service.login(gno, gpwd)){
				Admin admin = service.queryAdminByGno(gno);
				session.setAttribute("admin", admin);
				response.sendRedirect("admin.jsp");
			}
			else {
				request.setAttribute("doctor", "0");	
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if("clear".equals(index)){
			 session.invalidate();
			 response.sendRedirect("zhuzhan.jsp");
		}
	}

}
