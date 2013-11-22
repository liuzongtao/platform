package com.myapp.platform.config;

import java.io.Serializable;

public class OauthPlatformConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 874597857970149652L;
	
	private String id;
	private String platformImplClass;
	private String appid;
	private String appkey;
	private String appSecret;
	private String namespace;
	private String reportKey;
	private String reportLoginUserUrl;
	private String reportPayInfoUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlatformImplClass() {
		return platformImplClass;
	}
	public void setPlatformImplClass(String platformImplClass) {
		this.platformImplClass = platformImplClass;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getReportKey() {
		return reportKey;
	}
	public void setReportKey(String reportKey) {
		this.reportKey = reportKey;
	}
	public String getReportLoginUserUrl() {
		return reportLoginUserUrl;
	}
	public void setReportLoginUserUrl(String reportLoginUserUrl) {
		this.reportLoginUserUrl = reportLoginUserUrl;
	}
	public String getReportPayInfoUrl() {
		return reportPayInfoUrl;
	}
	public void setReportPayInfoUrl(String reportPayInfoUrl) {
		this.reportPayInfoUrl = reportPayInfoUrl;
	}
	
	

}
