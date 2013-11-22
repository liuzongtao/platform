package com.myapp.platform.facebook.model;

import com.myapp.platform.baseModel.BaseAppUser;
import com.restfb.types.User;

public class FacebookAppUser extends BaseAppUser {
	
	private User user;
	
	public FacebookAppUser (User user){
		this.user = user;
	}
	
	@Override
	public String getName() {
		return user.getName();
	}

	@Override
	public String getAccount() {
		return user.getId();
	}

	@Override
	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPortraitUrl() {
		return user.getLink();
	}

}
