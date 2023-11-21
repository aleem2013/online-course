package com.myedtech.models.dto;

import java.io.Serializable;
import java.util.Date;

public class CourseDto implements Serializable {

	private int id;

	private String title;

	private String image;

	private int hourCount;

	private int viewCount;

	private double price;

	private String description;

	private String content;

	private int categoryId;

	private Date lastUpdate;

	private String category;

	public CourseDto() {

	}
	
	public CourseDto(
			int id, 
			String title, 
			String image,
			int hourCount, 
			int viewCount, 
			double price,
			String desc, 
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.hourCount = hourCount;
		this.viewCount = viewCount;
		this.price = price;
		this.description = desc;
		this.content = content;
	}

	public CourseDto(
			int id, 
			String title, 
			String image, 
			int hourCount, 
			int viewCount, 
			double price,
			String desc, 
			String content, 
			int cateId, 
			Date lastUpdate, 
			String cateName) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.hourCount = hourCount;
		this.viewCount = viewCount;
		this.price = price;
		this.description = desc;
		this.content = content;
		this.categoryId = cateId;
		this.lastUpdate = lastUpdate;
		this.category = cateName;
	}

	public CourseDto(
			int id, 
			String title, 
			String image, 
			int hourCount, 
			int viewCount, 
			double price,
			String desc, 
			String content, 
			int cateId, 
			Date lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.hourCount = hourCount;
		this.viewCount = viewCount;
		this.price = price;
		this.description = desc;
		this.content = content;
		this.categoryId = cateId;
		this.lastUpdate = lastUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getHourCount() {
		return hourCount;
	}

	public void setHourCount(int hourCount) {
		this.hourCount = hourCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
