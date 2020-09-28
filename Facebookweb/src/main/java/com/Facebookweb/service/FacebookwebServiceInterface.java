package com.Facebookweb.service;

import java.util.List;

import com.Facebookweb.entity.FacebookwebUser;

public interface FacebookwebServiceInterface {
	
	int createProfileService(FacebookwebUser fu);

	boolean loginProfileService(FacebookwebUser fu);

	List<FacebookwebUser> friendProfile(FacebookwebUser fu) ;

}
