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
				out.write("ҽ��û���ڸ�ʱ���ϰ�");
			}
			else {
				if(timeno > 0){
					P p = (P) session.getAttribute("p");		
					GH gh = new GH(p.getPno(),dno,timeno);
					if(!dao.queryAllGHByGHnoDao(gh))
					{
						if(dao.addDGHDao(gh)){
							out.write("ԤԼ�ɹ���");
						}
						else {
							out.write("δ֪����ԤԼʧ��");
						}
					}
					else {
						out.write("�����ظ��Һ�");
					}
				}
				else {
					out.write("�ù������Ѹı䣬��ˢ��");
				}
			}			
		}
		else if("my_reg".equals(index)){
			P p = (P) session.getAttribute("p");
			List<GH> pghs = dao.queryAllGHByPnoDao(p.getPno());
			session.setAttribute("pghs", pghs);
			response.sendRedirect("center/my_reg.jsp");
		}
		else if ("ks_ser".equals(index)) {//��ѯ��������������ҽ��
			String ksno = request.getParameter("ks");
			KSDao ksDao = new KSDao();
			List<Doctor> ks_doctors = ksDao.queryDoctorByksnoDao(ksno);
			request.setAttribute("ksno", ksno);
			request.setAttribute("ks_doctors", ks_doctors);
			request.getRequestDispatcher("ks_doctor.jsp").forward(request, response);
		}
		else if ("ks_inner".equals(index)) {//����ԤԼ����
			String ksno = request.getParameter("ks");
			KSDao ksDao = new KSDao();
			KS ks = ksDao.queryKSByKSnoDao(ksno);
			List<String> weeks = new ArrayList<String>();
			weeks.add("����һ");
			weeks.add("���ڶ�");
			weeks.add("������");
			weeks.add("������");
			weeks.add("������");
			weeks.add("������");
			weeks.add("������");
			request.setAttribute("weeks", weeks);
			request.setAttribute("ks", ks);
			request.getRequestDispatcher("Register2.jsp").forward(request, response);
		}
		else if ("gh".equals(index)) {//�Һſ��ң������Ƿ���ڹ�����
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
							out.write("�Һųɹ���");
						}
						else {
							out.write("�Һ�ʧ�ܣ�");
						}
					}
					else {
						out.write("���Ѿ��ҺŹ�����");
					}
					break;
				}
			}
			if (timeno < 0) {
				out.write("��ʱ����ʱû��ҽ��������");
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
