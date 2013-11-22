package com.myapp.platform.baseModel;

public abstract class BaseAppUser {
	
	private String name;//昵称
	private String account;//账号
	private String email;//邮箱
	private String portraitUrl;//头像url
	private String inviteAccount;//邀请人账号
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPortraitUrl() {
		return portraitUrl;
	}
	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getInviteAccount() {
		return inviteAccount;
	}
	public void setInviteAccount(String inviteAccount) {
		this.inviteAccount = inviteAccount;
	}
	
	
	

}
