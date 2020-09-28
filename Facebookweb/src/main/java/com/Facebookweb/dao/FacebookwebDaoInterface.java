package com.Facebookweb.dao;

import java.util.List;

import com.Facebookweb.entity.FacebookwebUser;

public interface FacebookwebDaoInterface {
	
	int createProfileDao(FacebookwebUser fu);

	boolean loginProfileDao(FacebookwebUser fu);

	List<FacebookwebUser> friendListDao(FacebookwebUser fu) ;

}
