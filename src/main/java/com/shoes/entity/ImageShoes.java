package com.shoes.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ImageShoe")
public class ImageShoes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "img")
	private String img;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shoes_id", nullable = false, foreignKey = @ForeignKey(name = "Shoes_Image_FK"), updatable = true, insertable = true)
	@JsonIgnore//chỗ này khai báo annotation @JsonIgnore để nó ko có lấy Shoes thuộc về ImageShoe, nếu ko có @JsonIgnore thì nó sẽ lặp vô tận ok thay
	private Shoes shoes;

	
	public ImageShoes(Long id, String img, Shoes shoes) {
		super();
		this.id = id;
		this.img = img;
		this.shoes = shoes;
	}
	
	public ImageShoes() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
}
