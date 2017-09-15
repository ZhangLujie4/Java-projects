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
 * Servlet implementation class updatepassword
 */
@WebServlet("/updatepassword")
public class updatepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String message = null;
		String Type = request.getParameter("Type");
		System.out.println(Type);
		String url = request.getParameter("url");
		System.out.println(url);
		request.getSession().setAttribute("Type", Type);
		request.setAttribute("result", message);
		request.setAttribute("url", url);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatepassword.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String message = null;
		HttpSession session = request.getSession(true);
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String Type = (String)session.getAttribute("Type");
		System.out.println(Type);
		System.out.println(password);
		System.out.println(newpassword);
		try{
			if(Type.equals("1")){
				Student student = (Student)session.getAttribute("student");			
				StudentDao dao = new StudentDao();
				if(password.equals(student.getSpassword())==true){
					student.setSpassword(newpassword);
					if(dao.updateSpassword(student)==true){
						request.getSession().setAttribute("student", student);
						message = "修改成功，请记住你的密码！";
					}
					else{
						message = "密码修改异常！";
					}
				}
				else{
					message = "原密码错误！";
				}
			}
			else if(Type.equals("2")){
				TeacherDao dao = new TeacherDao();
				Teacher teacher = (Teacher)session.getAttribute("teacher");
				if(password.equals(teacher.getTpassword())==true){
					teacher.setTpassword(newpassword);
					if(dao.updateTpassword(teacher)){
						message = "修改成功，请记住您的密码！";
						request.getSession().setAttribute("teacher", teacher);
					}
					else{
						message = "密码修改异常!";
					}
				}
				else{
					message = "原密码错误！";
				}
			}
		}
		catch(Exception e){
			message = "操作异常！";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatepassword.jsp");
		rd.forward(request, response);
	}

}
