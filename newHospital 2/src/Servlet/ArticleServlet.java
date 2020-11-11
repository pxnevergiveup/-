package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ArticleDao;
import Entity.Article;
import Entity.Doctor;
import Util.ArticleUtil;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ArticleDao dao = new ArticleDao();
		String index = request.getParameter("index");
		HttpSession session = request.getSession();
		ArticleUtil util = new ArticleUtil();
		if("push".equals(index)){
			String head = request.getParameter("head");
			int part = Integer.parseInt(request.getParameter("part"));
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			int dno = doctor.getDno();
			Article article = new Article(dno, head, part);
			String text = request.getParameter("text");
			if(!dao.isExist(dno, head)){
				dao.addArticleDao(article);
				Article article2 = dao.queryArticleByAddDao(dno, head);
				String address = Integer.toString(article2.getAddress());
				util.writeToText(text, address);
				out.write("true");
			}
			else {
				out.write("false");
			}
		}
		if("pull".equals(index)){
			List<Article> articles1 = dao.queryArticleByPartDao("½¡¿µ×ÉÑ¯");
			List<Article> articles2 = dao.queryArticleByPartDao("Ñ§ÊõÇ°ÑØ");
			Collections.reverse(articles1);
			Collections.reverse(articles2);
			session.setAttribute("articles1", articles1);
			session.setAttribute("articles2", articles2);
		}
		if("read".equals(index)){
			String address = request.getParameter("add");
			Article article = dao.queryArticleByAddDao(Integer.parseInt(address));
			String Text = util.readToText(address);
			request.setAttribute("art", article);
			request.setAttribute("article", Text);
			int max = Text.length()/300+1;
			String[] array = new String[max];
			for (int i = 0; i<max; i++) {
				int j = i+1;				
				if(j*300<Text.length())
				{
					array[i] = Text.substring(i*300, j*300);
				}
				else {
					array[i] = Text.substring(i*300);
				}
			}
			request.setAttribute("Text", array);
			request.getRequestDispatcher("article.jsp").forward(request, response);
		}
		if("pullme".equals(index)){
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			List<Article> articles = dao.queryArticleByDnoDao(doctor.getDno());
			Collections.reverse(articles);
			session.setAttribute("articles", articles);
			response.sendRedirect("pullme.jsp");
		}
		if("del".equals(index)){
			String address = request.getParameter("add");
			if(util.deleteFile(address)){
				if(dao.delArticleByAddDao(Integer.parseInt(address))){
					out.write("true");
				}
				else {
					out.write("false");
				}
			}
			else {
				out.write("false");
			}
		}
		if("mod".equals(index)){
			int address =Integer.parseInt(request.getParameter("add"));
			String head = request.getParameter("head");
			int part =Integer.parseInt(request.getParameter("part"));
			Doctor doctor = (Doctor) session.getAttribute("doctor");
			Article article = new Article(address, doctor.getDno(), head, part);
			if(dao.updateArticleDao(article)){
				out.write("true");
			}
			else {
				out.write("false");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
