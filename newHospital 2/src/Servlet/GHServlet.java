package Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import Dao.GHDao;
import Dao.KSDao;
import Entity.Doctor;
import Entity.DoctorWorktime;
import Entity.GH;
import Entity.KS;
import Entity.P;
import Service.PService;
import Service.WorktimeService;
import Service.doctorService;


public class GHServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		GHDao dao = new GHDao();
		doctorService dService = new doctorService();
		PService pService = new PService();
		WorktimeService wtService = new WorktimeService();
		HttpSession session=request.getSession();
		String index = request.getParameter("index");
		
		if ("doctor".equals(index)) {
			int a = Integer.parseInt(request.getParameter("a"));
			String b = request.getParameter("b");
			List<GH> ghsd= dao.queryAllGHByDksnoDao(Integer.toString(a));
			List<GH> ghsk= dao.queryAllGHByDksnoDao(b);
			session.setAttribute("ghsd", ghsd);
			session.setAttribute("ghsk", ghsk);
			response.sendRedirect("D_iframe_1.jsp");
		}
		else if("del".equals(index)){
			int ghno= Integer.parseInt(request.getParameter("ghno"));
			if(!dao.delGHByGHnoDao(ghno)){
				out.write("false");
			}
			else {
				out.write("true");
			}
		}
		else if("search".equals(index)){			
			int dno = Integer.parseInt(request.getParameter("dno"));
			Map<String, ArrayList<String>> map = wtService.queryWTByDno(dno);
			request.setAttribute("map", map);
			Doctor serDoctor = dService.queryDoctorByDno(Integer.toString(dno));
			request.setAttribute("serDoctor", serDoctor);			
			request.getRequestDispatcher("Register.jsp").forward(request, response);	
		}
		else if("yuyue".equals(index)) {
			String reg = request.getParameter("register");
			int dno = Integer.parseInt(request.getParameter("dno"));
			String[] split = reg.split("\\&");
			String timedate = split[0];
			String timetime = split[1];
			DoctorWorktime doctorWorktime = new DoctorWorktime(timetime);
			int timereg = doctorWorktime.getTimereg();
			doctorWorktime = new DoctorWorktime(dno,timedate,timereg);
			int timeno = wtService.queryWorktimeByWT(doctorWorktime);
			if(" ".equals(timetime)||timetime.isEmpty()){
				out.write("医生没有在该时段上班");
			}
			else {
				if(timeno > 0){
					P p = (P) session.getAttribute("p");		
					GH gh = new GH(p.getPno(),dno,timeno);
					if(!dao.queryAllGHByGHnoDao(gh))
					{
						if(dao.addDGHDao(gh)){
							out.write("预约成功！");
						}
						else {
							out.write("未知错误，预约失败");
						}
					}
					else {
						out.write("请误重复挂号");
					}
				}
				else {
					out.write("该工作表已改变，请刷新");
				}
			}			
		}
		else if("my_reg".equals(index)){
			P p = (P) session.getAttribute("p");
			List<GH> pghs = dao.queryAllGHByPnoDao(p.getPno());
			session.setAttribute("pghs", pghs);
			response.sendRedirect("center/my_reg.jsp");
		}
		else if ("ks_ser".equals(index)) {//查询科室所属的所有医生
			String ksno = request.getParameter("ks");
			KSDao ksDao = new KSDao();
			List<Doctor> ks_doctors = ksDao.queryDoctorByksnoDao(ksno);
			request.setAttribute("ksno", ksno);
			request.setAttribute("ks_doctors", ks_doctors);
			request.getRequestDispatcher("ks_doctor.jsp").forward(request, response);
		}
		else if ("ks_inner".equals(index)) {//科室预约界面
			String ksno = request.getParameter("ks");
			KSDao ksDao = new KSDao();
			KS ks = ksDao.queryKSByKSnoDao(ksno);
			List<String> weeks = new ArrayList<String>();
			weeks.add("星期一");
			weeks.add("星期二");
			weeks.add("星期三");
			weeks.add("星期四");
			weeks.add("星期五");
			weeks.add("星期六");
			weeks.add("星期日");
			request.setAttribute("weeks", weeks);
			request.setAttribute("ks", ks);
			request.getRequestDispatcher("Register2.jsp").forward(request, response);
		}
		else if ("gh".equals(index)) {//挂号科室，遍历是否存在工作表
			String ksno = request.getParameter("ks");
			String reg = request.getParameter("register");
			String[] split = reg.split("\\&");
			String timedate = split[0];
			int timereg = Integer.parseInt(split[1]);
			KSDao ksDao = new KSDao();
			List<Doctor> ks_doctors = ksDao.queryDoctorByksnoDao(ksno);
			int timeno = -1;
			for (Doctor doctor:ks_doctors) {
				int dno = doctor.getDno();
				DoctorWorktime doctorWorktime = new DoctorWorktime(dno,timedate,timereg);
				timeno = wtService.queryWorktimeByWT(doctorWorktime);
				if(timeno > 0){
					P p = (P) session.getAttribute("p");		
					GH gh = new GH(p.getPno(),ksno,timeno);
					if(!dao.queryAllGHByGHnoDao(gh))
					{
						if(dao.addKSGHDao(gh)){
							out.write("挂号成功！");
						}
						else {
							out.write("挂号失败！");
						}
					}
					else {
						out.write("你已经挂号过啦！");
					}
					break;
				}
			}
			if (timeno < 0) {
				out.write("该时段暂时没有医生工作！");
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
