package com.myapp.platform.baseModel;

public class BaseRechargeInfo {
	
	private String id;//标示
	private String title;//标题
	private String pluralTitle;//副标题
	private String image;//购买物品地址
	private String description;//描述
	
	private String priceAmount;//钱数
	private String priceCurrency;//币种
	
	private int gainCoinNum ;//获得金币数量
	private int presentCoinNum;//赠送金币数量
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPluralTitle() {
		return pluralTitle;
	}
	public void setPluralTitle(String pluralTitle) {
		this.pluralTitle = pluralTitle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(String priceAmount) {
		this.priceAmount = priceAmount;
	}
	public String getPriceCurrency() {
		return priceCurrency;
	}
	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	public int getGainCoinNum() {
		return gainCoinNum;
	}
	public void setGainCoinNum(int gainCoinNum) {
		this.gainCoinNum = gainCoinNum;
	}
	public int getPresentCoinNum() {
		return presentCoinNum;
	}
	public void setPresentCoinNum(int presentCoinNum) {
		this.presentCoinNum = presentCoinNum;
	}
	
	

}
