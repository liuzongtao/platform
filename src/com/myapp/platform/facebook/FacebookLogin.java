package com.myapp.platform.facebook;

import org.nutz.web.ajax.AjaxReturn;

import com.myapp.platform.BaseLogin;
import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.baseModel.BaseParam;
import com.myapp.platform.common.PlatformGloble;
import com.myapp.platform.facebook.model.FacebookAppUser;
import com.myapp.platform.facebook.model.FacebookRechargeInfo;
import com.restfb.types.User;

public class FacebookLogin extends BaseLogin {
	
	private static final FacebookLogin facebookLogin = new FacebookLogin();
	private FacebookLogin(){}
	public static FacebookLogin getInstance(){
		return facebookLogin;
	}

	public AjaxReturn login(PlatformApi<FacebookRechargeInfo> handler, User facebookUser) {
		BaseParam param = getParam(facebookUser);
		FacebookAppUser appUser = new FacebookAppUser(facebookUser);
		return super.login(handler, param,appUser);
	}
	
	public BaseParam getParam(User facebookUser){
		BaseParam param = new BaseParam();
		param.setAccount(facebookUser.getId());
		param.setPf(PlatformGloble.PF_FACEBOOK);
		return param;
	}
	
	

}
