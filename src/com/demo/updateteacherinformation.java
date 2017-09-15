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
 * Servlet implementation class updateteacherinformation
 */
@WebServlet("/updateteacherinformation.do")
public class updateteacherinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateteacherinformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;
		request.setCharacterEncoding("UTF-8");
		String Tname = request.getParameter("Tname");
		String Tsex = request.getParameter("Tsex");
		String Tage = request.getParameter("Tage");
		String Ttitle = request.getParameter("Ttitle");
		String Tphone = request.getParameter("Tphone");
		try{ 
			TeacherDao dao = new TeacherDao();
			HttpSession session = request.getSession(true);
			Teacher teacher = (Teacher)session.getAttribute("teacher");
			teacher.setTname(Tname);
			teacher.setTsex(Tsex);
			teacher.setTage(Tage);
			teacher.setTtitle(Ttitle);
			teacher.setTphone(Tphone);	
			if(dao.updateTeacher(teacher)==true){
				message = "修改成功！";
			}
			request.getSession().setAttribute("teacher", teacher);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("updateresult", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacherinformation.jsp");
		rd.forward(request, response);
	}

}
