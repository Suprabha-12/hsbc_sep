package com.Facebookweb.utility;

import com.Facebookweb.service.FacebookwebService;
import com.Facebookweb.service.FacebookwebServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}
	
	public static FacebookwebServiceInterface createObject(String aa) 
	{
		
		FacebookwebServiceInterface fs=null;
		
		if(aa.equals("adminservice")) {
			fs=new FacebookwebService();
		}
		return fs;
	}

}
