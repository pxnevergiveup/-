package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Doctor;
import Entity.P;
import Service.PService;
import Service.doctorService;

/**
 * Servlet implementation class pwdServlet
 */
public class pwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doctorService dService = new doctorService();
		PService pService =new PService();
		P p = new P();
		Doctor doctor = null;
		String index = request.getParameter("index");
		if("doctor".equals(index)){
			String dno = request.getParameter("no");
			String pwd = request.getParameter("pwd");
			String newpwd = request.getParameter("newpwd");
			if(dService.loginDoctor(dno, pwd)){
				doctor = dService.queryDoctorByDno(dno);
				doctor.setDpwd(newpwd);
				if(dService.updateDoctor(doctor)) out.write("true");
				else out.write("false");
			}
			else{
				out.write("false");
			}
		}
		if("p".equals(index)){
			String pno = request.getParameter("no");
			String pwd = request.getParameter("pwd");
			String newpwd = request.getParameter("newpwd");
			if(pService.loginP(pno, pwd)){
				p = pService.queryPByPno(pno);
				p.setPpwd(newpwd);
				pService.updatePByPno(p);
				out.write("true");
			}
			else{
				out.write("false");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
