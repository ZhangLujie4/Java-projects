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
 * Servlet implementation class inputstudentgrades
 */
@WebServlet("/inputstudentgrades")
public class inputstudentgrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputstudentgrades() {
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
		String[] Sno = request.getParameterValues("Sno");
		String[] Cno = request.getParameterValues("Cno");
		String[] Sgrade = request.getParameterValues("Sgrade");
		try{ 
			GradeDao dao = new GradeDao();
			for(int i=0; i<Sno.length; i++){
				Grade grade = new Grade();
				grade.setSno(Sno[i]);
				grade.setCno(Cno[i]);
				if(Sgrade[i]=="")
				{
					grade.setSgrade(null);
				}
				else{
					grade.setSgrade(Sgrade[i]);
				}
				dao.updateSno_Cno(grade);
			}
			message = "提交保存成功！";
		}
		catch(Exception e){
			message = "上传失败！";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/inputstudentgrades.jsp");
		rd.forward(request, response);
	}

}
