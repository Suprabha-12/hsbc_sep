package com.Facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Facebookweb.entity.FacebookwebUser;
import com.Facebookweb.service.FacebookwebServiceInterface;
import com.Facebookweb.utility.ServiceFactory;

public class LoginServlet extends HttpServlet {
	
	private FacebookwebServiceInterface fs;
	
	public LoginServlet(){
		
		fs=ServiceFactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
        FacebookwebUser fu=new FacebookwebUser();
		
		fu.setName(name);
		fu.setPassword(password);
		
		boolean i=fs.loginProfileService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i){
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			
			out.println("Welcome "+name+"!"+"<a href=TimeLine>TimeLine</a>   <a href=FriendList>FriendList</a>");
		
		}
		
		else{

			out.println("Invalid user ID and password!");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
		
	}

}
