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
 * Servlet implementation class yearaveragegrade
 */
@WebServlet("/yearaveragegrade")
public class yearaveragegrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yearaveragegrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String xuenian = request.getParameter("xuenian");
		double averagexuenian = 0;
		if(xuenian==null){
			xuenian="2016/2017";
		}
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
		try{
				GradeDao dao = new GradeDao();
                gradelist = dao.findgradesBySno_year(student.getSno(), xuenian);
                averagexuenian = dao.findyearaverageBySno_year(student.getSno(), xuenian);
        }
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("xuenian", xuenian);
		request.setAttribute("gradelist", gradelist);
		request.setAttribute("averagexuenian",averagexuenian);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/yearaveragegrade.jsp");
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
