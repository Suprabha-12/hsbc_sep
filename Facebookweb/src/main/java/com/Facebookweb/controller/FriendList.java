package com.Facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Facebookweb.entity.FacebookwebUser;
import com.Facebookweb.service.FacebookwebServiceInterface;
import com.Facebookweb.utility.ServiceFactory;

public class FriendList extends HttpServlet {
	
    private FacebookwebServiceInterface fs;
	
	public FriendList(){
		
		fs=ServiceFactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ss=request.getSession(true);
		
		String name=ss.getAttribute("userid").toString();
        System.out.println(name);
		
        FacebookwebUser fu=new FacebookwebUser();
		fu.setName(name);
		
		List<FacebookwebUser> i=fs.friendProfile(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i.size()>0) {
			
			for(FacebookwebUser ff:i) {
				out.println(ff.getName());
			}
		}
		else {
			out.println("No friend found!");
		}
		out.println("</body></html>");
	}

}
