package com.Instagramweb.dao;

import java.util.List;

import com.Instagramweb.entity.InstagramwebUser;

public interface InstagramwebDaoInterface {

	int createProfileDao(InstagramwebUser iu);

	boolean loginProfileDao(InstagramwebUser iu);

	List<InstagramwebUser> friendListDao(InstagramwebUser iu);

}
