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
 * Servlet implementation class selectindexgrade
 */
@WebServlet("/selectindexgrade")
public class selectindexgrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectindexgrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if(request.getAttribute("gradelist")!=null){
			request.removeAttribute("gradelist");
		}
		String xueqi = request.getParameter("xueqi");
		if(xueqi==null){
			xueqi="2016/2017(1)";
		}
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		HttpSession session = request.getSession(true);
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		try{
				LessonDao dao = new LessonDao();
                lessonlist = dao.findlessonsByTno_Cterm(teacher.getTno(),xueqi);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("xueqi", xueqi);
		request.getSession().setAttribute("lessonlist", lessonlist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexaveragegrade.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String xueqi = (String)session.getAttribute("xueqi");
		String kecheng = request.getParameter("kecheng");
		if(kecheng==null){
			kecheng="0";
	    }   
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		double average = 0;
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		try{
				GradeDao dao = new GradeDao();
                gradelist = dao.findgradesByDESCNOTNULL(kecheng, xueqi, teacher.getTno());
                average = dao.findaveragegrade(kecheng, xueqi, teacher.getTno());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("kecheng", kecheng);
		request.setAttribute("gradelist", gradelist);
		request.setAttribute("average", average);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexaveragegrade.jsp");
		rd.forward(request, response);
	}

}
