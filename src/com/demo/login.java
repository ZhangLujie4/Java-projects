package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Student;
import com.demo.StudentDao;
import com.demo.Teacher;
import com.demo.TeacherDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String url = null;
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String yonghu = request.getParameter("yonghu");
		try{
			if(yonghu.equals("1")){
				StudentDao dao = new StudentDao();
				Student student = dao.findBySno(username);
				if(student.getSno()!=null){
					if(password.trim().equals(student.getSpassword().trim())){
						message = student.getSpassword();
						request.getSession().setAttribute("student", student);
						request.getSession().setAttribute("realname", student.getSname());
						request.getSession().setAttribute("yonghu",yonghu);
						url = "/studentcenter.jsp";
					}
					else{
						message = "密码错误，请重新输入!";
						url = "/home.jsp";
					}
				}
				else{
					message = "用户名不存在！";
					url = "/home.jsp";
				}
			}
			else{
				TeacherDao dao = new TeacherDao();
				Teacher teacher = dao.findByTno(username);
				if(teacher.getTno()!=null){
					if(password.trim().equals(teacher.getTpassword().trim())){
						message = teacher.getTpassword();
						request.getSession().setAttribute("teacher", teacher);
						request.getSession().setAttribute("realname", teacher.getTname());
						request.getSession().setAttribute("yonghu",yonghu);
						url = "/teachercenter.jsp";
					}
					else{
						message = "密码错误，请重新输入!";
						url = "/home.jsp";
					}
				}
				else{
					message = "用户名不存在！";
					url = "/home.jsp";
				}
			}
		}
		catch(Exception e){
			message = "操作异常！";
			url = "/home.jsp";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
