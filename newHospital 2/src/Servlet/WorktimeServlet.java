package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Doctor;
import Entity.DoctorWorktime;
import Entity.YD;
import Service.WorktimeService;
import Service.doctorService;

@WebServlet("/WorktimeServlet")
public class WorktimeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		if ("Arrang".equals(index)) {
			String dno = request.getParameter("no");
			WorktimeService service = new WorktimeService();
			Map<String, ArrayList<String>> map = service.queryWTByDno(Integer.parseInt(dno));
			doctorService dService = new doctorService();
			Doctor doctor = dService.queryDoctorByDno(dno);
			request.setAttribute("doctor", doctor);
			request.setAttribute("map", map);
			request.getRequestDispatcher("ArrangWork.jsp").forward(request, response);
		}
		else if("add".equals(index)){
			String reg = request.getParameter("register");		
			String[] split = reg.split("\\&");
			String timedate = split[0];
			int timereg = Integer.parseInt(split[2]);
			int dno = Integer.parseInt(request.getParameter("dno"));
			WorktimeService service = new WorktimeService();
			DoctorWorktime worktime = new DoctorWorktime(dno, timedate, timereg);
			if(service.addWT(worktime)){
				out.write("true");
				
			}
			else {
				out.write("false");
			}
		}
		else if("del".equals(index)){
			String reg = request.getParameter("register");			
			String[] split = reg.split("\\&");
			String timedate = split[0];
			int timereg = Integer.parseInt(split[2]);
			int dno = Integer.parseInt(request.getParameter("dno"));
			WorktimeService service = new WorktimeService();
			DoctorWorktime worktime = new DoctorWorktime(dno, timedate, timereg);
			int ret = service.delWTByWT(worktime);
			switch (ret) {
			case 1:
				out.write("³É¹¦");
				break;
			case 0:
				out.write("ÇëÎðÖØ¸´É¾³ý");
				break;
			case -1:
				out.write("false");
				break;
			default:
				out.write("Î´Öª´íÎóÐÅÏ¢");
				break;
			}
		}
		else if("delmore".equals(index)){
			String reg = request.getParameter("register");			
			String[] split = reg.split("\\&");
			String timedate = split[0];
			int timereg = Integer.parseInt(split[2]);
			int dno = Integer.parseInt(request.getParameter("dno"));
			WorktimeService service = new WorktimeService();
			DoctorWorktime worktime = new DoctorWorktime(dno, timedate, timereg);
			int timeno = service.queryWorktimeByWT(worktime);
			if (service.delGHBytimeno(timeno)) {
				out.write("É¾³ý³É¹¦");
			}
			else {
				out.write("É¾³ýÊ§°Ü");
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
