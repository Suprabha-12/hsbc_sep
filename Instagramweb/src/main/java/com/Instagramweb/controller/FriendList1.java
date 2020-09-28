package com.Instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Instagramweb.entity.InstagramwebUser;
import com.Instagramweb.service.InstagramwebServiceInterface;
import com.Instagramweb.utility.ServiceFactory;

public class FriendList1 extends HttpServlet {
	
	private InstagramwebServiceInterface is;
	
	public FriendList1(){
		
		is=ServiceFactory.createObject("adminservice");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss=request.getSession(true);
		
		String name=ss.getAttribute("userid").toString();
        System.out.println(name);
		
        InstagramwebUser iu=new InstagramwebUser();
		iu.setName(name);
		
		List<InstagramwebUser> i=is.friendProfile(iu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i.size()>0) {
			
			for(InstagramwebUser ii:i) {
				out.println(ii.getName());
			}
		}
		else {
			out.println("No friend found!");
		}
		out.println("</body></html>");
	}

}
