package com.Instagramweb.utility;

import com.Instagramweb.dao.InstagramwebDao;
import com.Instagramweb.dao.InstagramwebDaoInterface;

public class DaoFactory {
	
private DaoFactory() {
		
	}
	
	public static InstagramwebDaoInterface createObject(String aa) 
	{
		
		InstagramwebDaoInterface id=null;
		
		if(aa.equals("adminservice")) {
			id=new InstagramwebDao();
		}
		return id;
	}

}
