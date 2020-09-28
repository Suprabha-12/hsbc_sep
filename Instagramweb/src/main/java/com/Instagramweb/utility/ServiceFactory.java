package com.Instagramweb.utility;

import com.Instagramweb.service.InstagramwebService;
import com.Instagramweb.service.InstagramwebServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}
	
	public static InstagramwebServiceInterface createObject(String aa) 
	{
		
		InstagramwebServiceInterface is=null;
		
		if(aa.equals("adminservice")) {
			is=new InstagramwebService();
		}
		return is;
	}

}
