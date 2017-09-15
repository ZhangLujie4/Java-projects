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
 * Servlet implementation class studentallcredit
 */
@WebServlet("/studentallcredit")
public class studentallcredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentallcredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		HttpSession session = request.getSession(true);
		double sum = 0;
		Student student = (Student)session.getAttribute("student");
		try{
				LessonDao dao = new LessonDao();
                lessonlist = dao.findlessonsBySno(student.getSno());
                sum = dao.findScreditBySno(student.getSno());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("Scredit", Double.toString(sum));
		request.setAttribute("lessonlist", lessonlist);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentallcredit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
