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

import com.demo.Lesson;
import com.demo.LessonDao;
import com.demo.Teacher;

/**
 * Servlet implementation class teacherlessonsServlet
 */
@WebServlet("/teacherlessonsServlet.do")
public class teacherlessonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherlessonsServlet() {
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
		HttpSession session = request.getSession(true);
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		try{
				LessonDao dao = new LessonDao();
                lessonlist = dao.findlessonsByTno_Cterm(teacher.getTno(),xueqi);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("xueqi", xueqi);
		request.setAttribute("lessonlist", lessonlist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacherlessons.jsp");
		rd.forward(request, response);
	}

}
