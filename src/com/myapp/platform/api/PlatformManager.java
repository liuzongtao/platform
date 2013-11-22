package com.myapp.platform.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.myapp.platform.config.ConfigManager;
import com.myapp.platform.config.OauthPlatformConfig;

public class PlatformManager {
	
	private static Map<String, Object> platfromApiMap = new HashMap<String, Object>();
	
	private static PlatformManager platformManager = new PlatformManager();
	
	private PlatformManager(){
		Map<String, OauthPlatformConfig> configMap = ConfigManager.getInstance().getPlatformConfigMap();
		for(Entry<String, OauthPlatformConfig> entry : configMap.entrySet()){
			String key = entry.getKey();
			OauthPlatformConfig config = entry.getValue();
			if(config == null){
				continue ;
			}
			if(StringUtils.isNotBlank(config.getPlatformImplClass())){
				try {
					platfromApiMap.put(key, Class.forName(config.getPlatformImplClass()).newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static PlatformManager getInstance(){
		return platformManager;
	}
	
	public Object getPlatfromHandler(String platfromId){
		return platfromApiMap.get(platfromId);
	}
	
	public void registerPlatForm(String platform, Class<?> platformApiClass){
		platfromApiMap.put(platform, platformApiClass);
	}
	

}
