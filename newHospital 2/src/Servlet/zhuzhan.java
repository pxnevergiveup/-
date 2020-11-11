package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.KSDao;
import Entity.Doctor;
import Entity.KS;
import Service.doctorService;

/**
 * Servlet implementation class zhuzhan
 */
@WebServlet("/zhuzhan")
public class zhuzhan extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		if("doctor".equals(index)){
			doctorService d_service = new doctorService();
			List<Doctor> doctors = d_service.queryAllDoctor();
			session.setAttribute("doctors", doctors);
		}
		else if("ks".equals(index)){
			KSDao ksDao = new KSDao();
			List<KS> kss = ksDao.queryAllKSDao();
			session.setAttribute("kss", kss);
			response.sendRedirect("gengduoks.jsp");
		}
		else if("control_doctor".equals(index)){
			doctorService d_service = new doctorService();
			List<Doctor> doctors = d_service.queryAllDoctor();
			request.setAttribute("doctors", doctors);
			request.getRequestDispatcher("adm_doctors.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
