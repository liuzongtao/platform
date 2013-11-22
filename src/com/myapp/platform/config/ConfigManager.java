package com.myapp.platform.config;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.nutz.lang.Files;

public class ConfigManager {
	
	private static Map<String, OauthPlatformConfig> platformConfigMap = new HashMap<String, OauthPlatformConfig>();
	
	private static final String OAUTH_PLATFORM_CONFIG_FILE = "oauth_platform.properties";
	private static final String CONFIG_PLATFORM_IMP_PRE = "platform.";
	private static final String CONFIG_PLATFORM_TYPE_SEPARATOR = "\\.";
	
	private static final ConfigManager configManager = new ConfigManager();
	private ConfigManager(){
		System.out.println("111");
		init();
	}
	public static ConfigManager getInstance(){
		return configManager;
	}
		
	private void init(){
		Properties oauthPro = new Properties();
		InputStream in = Files.findFileAsStream(OAUTH_PLATFORM_CONFIG_FILE);
		try {
			oauthPro.load(in);
			registerProviders(oauthPro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<String, OauthPlatformConfig> getPlatformConfigMap(){
		return platformConfigMap;
	}
	
	private void registerProviders(Properties properties) throws Exception {
		for (Object key : properties.keySet()) {
			String keyStr = key.toString();
			getPlatformConfigMap(keyStr, properties.get(keyStr).toString(), platformConfigMap);
		}
	}
	
	private void getPlatformConfigMap(String key,String value,Map<String, OauthPlatformConfig> platformConfigMap){
		if(key.startsWith(CONFIG_PLATFORM_IMP_PRE)){
			return;
		}
		String[] keyArray = key.split(CONFIG_PLATFORM_TYPE_SEPARATOR);
		if(keyArray.length != 2){
			return;
		}
		OauthPlatformConfig config = platformConfigMap.get(keyArray[0]);
		if(config == null){
			config = new OauthPlatformConfig();
		}
		Class<?> configClazz =  config.getClass();
		String firstCharStr = keyArray[1].substring(0, 1);
		String tempKeyName = keyArray[1].replaceFirst(firstCharStr, firstCharStr.toUpperCase());
		try {
			Method method = configClazz.getDeclaredMethod("set" + tempKeyName, String.class);
			method.invoke(config, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		platformConfigMap.put(keyArray[0], config);
	}
}
