package com.shoes.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ColorShoes")
public class ColorShoes implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "color")
	private String color;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "color")
	@JsonIgnore
	private List<Shoes> shoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ColorShoes(Long id, String color, List<Shoes> shoes) {
		super();
		this.id = id;
		this.color = color;
		this.shoes = shoes;
	}

	public ColorShoes() {
		super();
	}
	
	
}
