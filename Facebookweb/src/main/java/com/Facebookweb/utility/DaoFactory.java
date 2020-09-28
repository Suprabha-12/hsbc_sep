package com.Facebookweb.utility;

import com.Facebookweb.dao.FacebookwebDao;
import com.Facebookweb.dao.FacebookwebDaoInterface;


public class DaoFactory {

	private DaoFactory() {
		
	}
	
	public static FacebookwebDaoInterface createObject(String aa) 
	{
		
		FacebookwebDaoInterface id=null;
		
		if(aa.equals("adminservice")) {
			id=new FacebookwebDao();
		}
		return id;
	}
	
}
