package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class classlessonsServlet
 */
@WebServlet("/classlessonsServlet.do")
public class classlessonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classlessonsServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String xueqi = request.getParameter("xueqi");
		if(xueqi==null){
			xueqi="2016/2017(1)";
		}
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		ArrayList<Lesson> studentlessonlist = new ArrayList<Lesson>();
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
		try{
				LessonDao dao = new LessonDao();
                lessonlist = dao.findlessonsByCclass_Cterm(student.getSclass(), xueqi);	
                studentlessonlist = dao.findlessonsBySno_Cterm_Sclass(student.getSno(), xueqi,student.getSclass());		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("xueqi", xueqi);
		request.getSession().setAttribute("lessonlist", lessonlist);
		request.getSession().setAttribute("studentlessonlist", studentlessonlist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/classlessons.jsp");
		rd.forward(request, response);
	}

}
