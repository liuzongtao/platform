package com.facebook.test;

import java.util.List;
import java.util.Map;

import org.nutz.web.ajax.AjaxReturn;

import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.baseModel.BaseAppUser;
import com.myapp.platform.baseModel.BaseParam;
import com.myapp.platform.baseModel.BaseRechargeInfo;
import com.myapp.platform.facebook.model.FacebookRechargeInfo;

public class FacebookApiImp implements PlatformApi<BaseRechargeInfo>{

	

	@Override
	public BaseRechargeInfo getRechargeInfo(String id) {
		FacebookRechargeInfo rechargeInfo = new FacebookRechargeInfo();
		rechargeInfo.setId(id);
		rechargeInfo.setTitle("ttt");
		rechargeInfo.setImage("http://192.168.3.12");
		return rechargeInfo;
	}

	@Override
	public List<String> getRechargeIdList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean createUser(BaseAppUser appUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(BaseAppUser appUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void commenPorcess(long uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshFriendList(long uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseAppUser getAppUser(BaseParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNewUser(long uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AjaxReturn checkParam(BaseParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUid(String account, String serverId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AjaxReturn filterUser(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getViewParameterMap(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
