package com.myedtech.models.dto;

public class SearchDto {
	private String key;
	private String[] category;
	private String[] duration;
	private String[] price;
	
	public SearchDto(String key, String[] category, String[] duration, String[] price) {
		super();
		this.key = key;
		this.category = category;
		this.duration = duration;
		this.price = price;
	}

	public SearchDto() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String[] getDuration() {
		return duration;
	}

	public void setDuration(String[] duration) {
		this.duration = duration;
	}

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

}
