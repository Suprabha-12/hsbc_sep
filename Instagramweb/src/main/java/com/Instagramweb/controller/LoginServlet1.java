package com.Instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Instagramweb.entity.InstagramwebUser;
import com.Instagramweb.service.InstagramwebServiceInterface;
import com.Instagramweb.utility.ServiceFactory;

public class LoginServlet1 extends HttpServlet {
	
	private InstagramwebServiceInterface is;

	public LoginServlet1(){
		
		is=ServiceFactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		InstagramwebUser iu=new InstagramwebUser();
		
		iu.setName(name);
		iu.setPassword(password);
		
		boolean i=is.loginProfileService(iu);
		
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
