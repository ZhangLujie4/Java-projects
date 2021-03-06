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
 * Servlet implementation class updatestudentinformation
 */
@WebServlet("/updatestudentinformation.do")
public class updatestudentinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatestudentinformation() {
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
		String Sname = request.getParameter("Sname");
		String Ssex = request.getParameter("Ssex");
		String Smajor = request.getParameter("Smajor");
		String Sclass = request.getParameter("Sclass");
		String Sarea = request.getParameter("Sarea");
		String Splace = request.getParameter("Splace");
		try{ 
			StudentDao dao = new StudentDao();
			HttpSession session = request.getSession(true);
			Student student = (Student)session.getAttribute("student");
			student.setSname(Sname);
			student.setSname(Sname);
			student.setSmajor(Smajor);
			student.setSclass(Sclass);
			student.setSarea(Sarea);
			student.setSplace(Splace);
			if(dao.updateStudent(student)){
				message = "修改成功！";
			}
			request.getSession().setAttribute("student", student);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("updateresult", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentinformation.jsp");
		rd.forward(request, response);
	}

}
