package com.Instagramweb.service;

import java.util.List;

import com.Instagramweb.dao.InstagramwebDaoInterface;
import com.Instagramweb.entity.InstagramwebUser;
import com.Instagramweb.utility.DaoFactory;

public class InstagramwebService implements InstagramwebServiceInterface {
	
	private InstagramwebDaoInterface id;
	
	public InstagramwebService(){
		
		id=DaoFactory.createObject("adminservice");

	}

	@Override
	public int createProfileService(InstagramwebUser iu) {

		return id.createProfileDao(iu);
		
	}

	@Override
	public boolean loginProfileService(InstagramwebUser iu) {
		
		return id.loginProfileDao(iu);
		
	}

	@Override
	public List<InstagramwebUser> friendProfile(InstagramwebUser iu) {

		return id.friendListDao(iu);
		
	}

}
