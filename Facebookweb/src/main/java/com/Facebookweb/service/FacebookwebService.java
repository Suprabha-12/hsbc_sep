package com.Facebookweb.service;

import java.util.List;

import com.Facebookweb.dao.FacebookwebDaoInterface;
import com.Facebookweb.entity.FacebookwebUser;
import com.Facebookweb.utility.DaoFactory;


public class FacebookwebService implements FacebookwebServiceInterface{
	
   private FacebookwebDaoInterface fd;
	
	public FacebookwebService(){
		
		fd=DaoFactory.createObject("adminservice");

	}

	@Override
	public int createProfileService(FacebookwebUser fu) {
		
		return fd.createProfileDao(fu);
	}
	

	@Override
	public boolean loginProfileService(FacebookwebUser fu) {

		return fd.loginProfileDao(fu);
	}
	

	@Override
	public List<FacebookwebUser> friendProfile(FacebookwebUser fu) {
		
		return fd.friendListDao(fu);
	}

}
