package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="shoe")
public class Shoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	

	@Column(name = "code")
	private String code;
	
	@Column(name = "title")
	private String title;
	

	
	
	
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "price")
	private double price;

	@Transient
	private int quantity;

	@Transient
	private double amount;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "color_shoe", nullable = false, foreignKey = @ForeignKey(name = "color_shoe_FK"), updatable = true, insertable = true)
	private List<ColorShoes> color;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "size_shoe", nullable = false, foreignKey = @ForeignKey(name = "size_shoe_FK"), updatable = true, insertable = true)
	private List<SizeShoes> size;
	
	
	@OneToMany(mappedBy = "shoes", fetch = FetchType.EAGER)
	//@JsonIgnore bỏ qua field này khi trả về
	private List<ImageShoes> listimage;

	public Shoes() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public List<ImageShoes> getListimage() {
		return listimage;
	}

	public void setListimage(List<ImageShoes> listimage) {
		this.listimage = listimage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}





	public List<ColorShoes> getColor() {
		return color;
	}

	public void setColor(List<ColorShoes> color) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<SizeShoes> getSize() {
		return size;
	}

	public void setSize(List<SizeShoes> size) {
		this.size = size;
	}

	public Shoes(Long id, String name, String code, String title, List<SizeShoes> size, String image, double price,
			int quantity, double amount, List<ColorShoes> color, List<ImageShoes> listimage) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.title = title;
		this.size = size;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.color = color;
		this.listimage = listimage;
	}




	
	
}
