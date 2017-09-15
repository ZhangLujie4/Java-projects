package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lessondetail
 */
@WebServlet("/lessondetail")
public class lessondetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lessondetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		request.setCharacterEncoding("UTF-8");
		String Cno = request.getParameter("Cno");
		System.out.println(Cno);
		try{
			LessonDao dao = new LessonDao();
			Lesson lesson = dao.findByCno(Cno);
			request.setAttribute("lesson", lesson);
		    url = "/updatelesson.jsp";
	    }
		catch(Exception e){
			e.printStackTrace();
		}
	    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
