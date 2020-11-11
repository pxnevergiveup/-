package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.KSDao;
import Entity.KS;
import Entity.P;
import Entity.YD;
import Service.PService;
import Service.doctorService;

/**
 * Servlet implementation class zhuceServlet
 */
public class zhuceServlet extends HttpServlet {
	public void zhuce(HttpServletRequest request, HttpServletResponse response) {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PrintWriter out = response.getWriter();
		P p = null;
		YD yd = null;
		String index = request.getParameter("index");
		if("p".equals(index)){
			PService service = new PService();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String date = request.getParameter("date");
			String sex = request.getParameter("sex");
			Date date2=null;
			try{
				if(date!=null)
				date2 = sdf.parse(date);
				p=new P(id,name,date2,pwd,sex);
				if(service.addP(p))
				{
					out.write("true");
				}
				else{
					out.write("false");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("doctor".equals(index)){
			doctorService service = new doctorService();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String ksno = request.getParameter("ksno");
			String pwd = request.getParameter("pwd");
			String sex = request.getParameter("sex");
			int sfzj = Integer.parseInt(request.getParameter("sfzj"));
			Date date2=null;
			try{
				if(date!=null)
				date2 = sdf.parse(date);
				yd = new YD(id,name,date2,ksno,pwd,sex,sfzj);
				if (service.isExist(yd.getYdid())) {
					out.write("false");
				}
				else if(service.addYD(yd))
				{
					out.write("true");
				}
				else{
					out.write("false");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ("adminSearch".equals(index)) {
			doctorService service = new doctorService();
			List<YD> YDS = service.queryAllYD();
			request.setAttribute("YDS", YDS);
			request.getRequestDispatcher("YDExamine.jsp").forward(request, response);
		}
		else if ("agree".equals(index)) {
			doctorService service = new doctorService();
			String did = request.getParameter("did");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String Ksno = request.getParameter("ksno");
			String pwd = request.getParameter("pwd");
			String sex = request.getParameter("sex");
			int sfzj =Integer.parseInt(request.getParameter("sfzj"));
			Date date2=null;			
			try {
				date2 = sdf.parse(date);
				yd = new YD(did, name, date2, Ksno, pwd, sex, sfzj);
				if(service.addDoctor(yd)){
					out.write("true");
				}
				else {
					out.write("false");
				}
			} catch (ParseException e) {	
				out.write("false");
				e.printStackTrace();
			}			
		}
		else if ("refuse".equals(index)) {
			doctorService service = new doctorService();
			String did = request.getParameter("did");
			if(service.delYDByDno(did)){
				out.write("true");
			}
			else {
				out.write("false");
			}
		}
		else if ("serks".equals(index)) {
			KSDao ksDao = new KSDao();
			List<KS> KSs = ksDao.queryAllKSDao();
			request.setAttribute("KSs", KSs);
			request.getRequestDispatcher("Dzhuce.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
