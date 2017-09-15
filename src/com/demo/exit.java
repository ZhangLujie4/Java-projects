package com.demo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class exit
 */
@WebServlet("/exit")
public class exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choose = request.getParameter("choose");
		HttpSession session = request.getSession();
		String yonghu = (String)session.getAttribute("yonghu");
		if(choose.equals("1")==true){
			session.removeAttribute("xueqi");
			session.removeAttribute("lessonlist");
			session.removeAttribute("studentlessonlist");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentcenter.jsp");
			rd.forward(request, response);
		}
		if(choose.equals("2")==true){
			session.removeAttribute("yonghu");
			session.removeAttribute("student");
			session.removeAttribute("realname");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}
		if(choose.equals("3")==true){
			session.removeAttribute("yonghu");
			session.removeAttribute("teacher");
			session.removeAttribute("realname");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}
		if(choose.equals("4")==true){
			session.removeAttribute("xueqi");
			session.removeAttribute("lessonlist");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teachercenter.jsp");
			rd.forward(request, response);
		}
		if(choose.equals("5")==true){
			String url = null;
			if(yonghu.equals("1")==true){
				url = "/studentcenter.jsp";
			}
			else if(yonghu.equals("2")==true){
				url = "/teachercenter.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
        if(choose.equals("6")==true){
        	if(yonghu.equals("1")==true){
        		session.removeAttribute("student");
        	}
        	else if(yonghu.equals("2")==true){
        		session.removeAttribute("teacher");
        	}
        	session.removeAttribute("yonghu");
			session.removeAttribute("realname");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
        }
        if(choose.equals("7")==true){
        	String url = null;
        	if(yonghu.equals("1")==true){
        		url = "/updateScredit";
        	}
        	else if(yonghu.equals("2")==true){
        		url = "/teacherinformation.jsp";
        	}
        	RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
