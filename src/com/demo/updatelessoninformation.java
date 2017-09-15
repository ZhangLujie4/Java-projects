package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updatelessoninformation
 */
@WebServlet("/updatelessoninformation.do")
public class updatelessoninformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatelessoninformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;
		request.setCharacterEncoding("UTF-8");
		String Cname = request.getParameter("Cname");
		String Cterm = request.getParameter("Cterm");
		String Cexam = request.getParameter("Cexam");
		String Ctime = request.getParameter("Ctime");
		String Ccredit = request.getParameter("Ccredit");
		String Cclass = request.getParameter("Cclass");
		try{ 
			LessonDao dao = new LessonDao();
			HttpSession session = request.getSession(true);
			Lesson lesson = (Lesson)session.getAttribute("lesson");
			lesson.setCname(Cname);
			lesson.setCterm(Cterm);
			lesson.setCexam(Cexam);
			lesson.setCtime(Ctime);
			lesson.setCcredit(Ccredit);
			lesson.setCclass(Cclass);
			if(dao.updateLesson(lesson)==true){
				message = "修改成功！";
			}
			request.getSession().setAttribute("lesson", lesson);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("updateresult", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatelesson.jsp");
		rd.forward(request, response);
	}

}
