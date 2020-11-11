package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Doctor;
import Entity.P;
import websocket.user;

/**
 * Servlet implementation class sToRequest
 */
@WebServlet("/sToRequest")
public class sToRequest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String index = request.getParameter("index");
		HttpSession session = request.getSession();
		user user = null;
		if("p".equals(index)){
			P p =  (P) session.getAttribute("p");
			user = new user(Integer.toString(p.getPno()), request.getParameter("ksno"), "p", p.getPname(), request.getParameter("ksname"));
			request.setAttribute("user", user);
		}
		if("doctor".equals(index)){
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			user = new user(Integer.toString(doctor.getDno()), doctor.getkSno(), "doctor", doctor.getDname(), doctor.getKsname());
			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("chat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
