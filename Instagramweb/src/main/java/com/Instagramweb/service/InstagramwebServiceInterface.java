package com.Instagramweb.service;

import java.util.List;

import com.Instagramweb.entity.InstagramwebUser;

public interface InstagramwebServiceInterface {

	int createProfileService(InstagramwebUser iu);
	
	boolean loginProfileService(InstagramwebUser iu);

	List<InstagramwebUser> friendProfile(InstagramwebUser iu) ;

}
