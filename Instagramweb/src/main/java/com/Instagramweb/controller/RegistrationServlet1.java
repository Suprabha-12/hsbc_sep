package com.Instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Instagramweb.entity.InstagramwebUser;
import com.Instagramweb.service.InstagramwebServiceInterface;
import com.Instagramweb.utility.ServiceFactory;

public class RegistrationServlet1 extends HttpServlet {
	
private InstagramwebServiceInterface is;
	
	public RegistrationServlet1(){
		
		is=ServiceFactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		InstagramwebUser iu=new InstagramwebUser();
		
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		
		int i=is.createProfileService(iu);
		
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
