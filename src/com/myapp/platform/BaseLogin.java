package com.myapp.platform;

import java.util.Map;

import org.nutz.web.ajax.AjaxReturn;

import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.baseModel.BaseAppUser;
import com.myapp.platform.baseModel.BaseParam;

public class BaseLogin {
	
	/***
	 * 登陆逻辑处理
	 * @param handler
	 * @param param
	 * @return
	 */
	public AjaxReturn login(PlatformApi<?> handler, BaseParam param,BaseAppUser appUser){
		AjaxReturn result = handler.checkParam(param);
		if(!result.isOk()){
			return result;
		}
		long uid = handler.getUid(param.getAccount(),param.getServerid());
		result = handler.filterUser(uid);
		if(!result.isOk()){
			return result;
		}
		boolean isNewUser = handler.isNewUser(uid);
		if(isNewUser){
			handler.createUser(appUser);
		}else {
			handler.updateUser(appUser);
		}
		handler.commenPorcess(uid);
		Map<String, Object> viewParameterMap = handler.getViewParameterMap(uid);
		result.setData(viewParameterMap);
		return result;
	}
}
