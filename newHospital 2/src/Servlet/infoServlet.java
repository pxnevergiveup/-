package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Doctor;
import Entity.P;
import Service.PService;
import Service.doctorService;

/**
 * Servlet implementation class infoServlet
 */
public class infoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		doctorService dService = new doctorService();
		PService pService = new PService();
		Doctor doctor = null;
		P p = null;
		String index = request.getParameter("index");
		if("Dsub".equals(index)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int no = Integer.parseInt(request.getParameter("no"));
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String sex = request.getParameter("sex");
			String js = request.getParameter("js");
			try{
				Date date2 = sdf.parse(date);
				doctor = dService.queryDoctorByDno(Integer.toString(no));
				doctor.info(no,id,name,date2,sex,js);
				if(dService.updateDoctor(doctor)){
					doctor = dService.queryDoctorByDno(doctor.getDid());
					session.setAttribute("doctor", doctor);
					out.write("true");
				}
				else {
					out.write("false");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				out.write("false");
			}
		}
		else if("Psub".equals(index)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int no = Integer.parseInt(request.getParameter("no"));
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String sex = request.getParameter("sex");
			String js = request.getParameter("js");
			try{
				Date date2 = sdf.parse(date);
				p = pService.queryPByPno(Integer.toString(no));
				p.info(no, id, name, date2, sex, js);
				if(pService.updatePByPno(p)) {
					p = pService.queryPByPno(p.getPid());
					session.setAttribute("p", p);
					out.write("true");
				}
				else{
					out.write("false");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				out.write("false");
			}
		}
		else if ("ser_doctor".equals(index)) {
			String dno = request.getParameter("no");
			doctor = dService.queryDoctorByDno(dno);
			session.setAttribute("doctor", doctor);
			response.sendRedirect("dinfo.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
