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
 * Servlet implementation class lessondelete
 */
@WebServlet("/lessondelete")
public class lessondelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lessondelete() {
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
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
		String Cno = request.getParameter("Cno");
		String xueqi = request.getParameter("xueqi");
		try{
			GradeDao dao = new GradeDao();
			Grade grade = new Grade();
			grade.setCno(Cno);
			grade.setSno(student.getSno());
			if(dao.compareSno_Cno(grade)==true&&dao.deleteSno_Cno(grade)==true){
				url="/classlessonsServlet.do";
			}
			else{
				url="/classlessons.jsp";
			}
	    }
		catch(Exception e){
			e.printStackTrace();
		}
		request.getSession().setAttribute("xueqi", xueqi);
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
