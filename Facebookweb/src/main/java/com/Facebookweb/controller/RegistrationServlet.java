package com.Facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Facebookweb.entity.FacebookwebUser;
import com.Facebookweb.service.FacebookwebServiceInterface;
import com.Facebookweb.utility.ServiceFactory;

public class RegistrationServlet extends HttpServlet {
	
	private FacebookwebServiceInterface fs;
	
	public RegistrationServlet(){
		
		fs=ServiceFactory.createObject("adminservice");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		FacebookwebUser fu=new FacebookwebUser();
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		
		int i=fs.createProfileService(fu);
		
		out.println("<html><body>");
		if(i>0) {
			
			out.println("Registration complete! \n\n<a href=login.html>Contunue...</a>");
			
			out.println("<br> Your name is "+name);
			out.println("<br> Your password is "+password);
		
		}
		
		else {
			out.println("Could not register!");
		}
		out.println("</body></html>");
		
		
	}

	
}
