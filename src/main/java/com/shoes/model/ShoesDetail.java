package com.shoes.model;

import java.util.List;
import com.shoes.entity.ImageShoes;

public class ShoesDetail {


	private String name;
	
	
	private List<ImageShoes> listimage;

	
	private String code;
	

	private String title;
	

	private String size;
	
	
	private String color;
	

	private String image;
	

	private double price;


	public ShoesDetail(String name, List<ImageShoes> listimage, String code, String title, String size, String color,
			String image, double price) {
		super();
		this.name = name;
		this.listimage = listimage;
		this.code = code;
		this.title = title;
		this.size = size;
		this.color = color;
		this.image = image;
		this.price = price;
	}


	public ShoesDetail() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ImageShoes> getListimage() {
		return listimage;
	}


	public void setListimage(List<ImageShoes> listimage) {
		this.listimage = listimage;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	

	

}
