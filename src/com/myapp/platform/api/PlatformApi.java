package com.myapp.platform.api;

import java.util.List;
import java.util.Map;

import org.nutz.web.ajax.AjaxReturn;

import com.myapp.platform.baseModel.BaseAppUser;
import com.myapp.platform.baseModel.BaseParam;
import com.myapp.platform.baseModel.BaseRechargeInfo;

public interface PlatformApi <T extends BaseRechargeInfo> {
	
	/***
	 * 根据id获取订单信息
	 * @param id
	 * @return
	 */
	public abstract T  getRechargeInfo(String id);
	
	/***
	 * 获取所有的充值id
	 * @return
	 */
	public abstract List<String> getRechargeIdList();
	
	/***
	 * 检验参数有效性
	 * @param param
	 * @return
	 */
	public abstract AjaxReturn checkParam(BaseParam param);
	
	/***
	 * 根据account 获得uid
	 * @param account
	 * @param serverId
	 * @return
	 */
	public abstract long getUid(String account,String serverId);
	
	/***
	 * 过滤玩家
	 * @param uid
	 * @return
	 */
	public abstract AjaxReturn filterUser(long uid);
	
	/**
	 * 根据参数获得appUser信息
	 * 并对信息做相应处理，比如:存入内存
	 * @param param
	 * @return
	 */
	public abstract BaseAppUser getAppUser(BaseParam param);
	
	/***
	 * 判断是否是新用户
	 * @param uid
	 * @return
	 */
	public abstract boolean isNewUser(long uid);
	
	/***
	 * 创建用户
	 * @param appUser
	 * @return
	 */
	public abstract boolean createUser(BaseAppUser appUser);
	
	/***
	 * 更新用户
	 * @param appUser
	 * @return
	 */
	public abstract boolean updateUser(BaseAppUser appUser);
	
	/***
	 * 公共处理逻辑
	 * 比如发放道具，触发任务
	 * @param uid
	 */
	public abstract void commenPorcess(long uid);
	
	/***
	 * 获得范围给前端的参数map
	 * @param uid
	 * @return
	 */
	public abstract Map<String, Object> getViewParameterMap(long uid); 
	
	
	
	/***
	 * 刷新好友列表
	 * @param uid
	 */
	public abstract void refreshFriendList(long uid);

}
