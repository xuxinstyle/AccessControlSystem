package com.system.service;

import com.system.po.User;

public interface UserFaceService {

	void getFace(String username);

	void getFeatures(String username);
	
	User CheckFace();
}
