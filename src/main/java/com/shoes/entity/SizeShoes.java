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
@Table(name="SizeShoess")
public class SizeShoes implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "size")
	private String size;
	

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "size")
	@JsonIgnore
	private List<Shoes> shoes;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
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


	public SizeShoes(Long id, String size, List<Shoes> shoes) {
		super();
		this.id = id;
		this.size = size;
		this.shoes = shoes;
	}


	public SizeShoes() {
		super();
	}
	
	
}
