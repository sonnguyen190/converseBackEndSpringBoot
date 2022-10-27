package com.shoes.service;

import java.util.List;


import com.shoes.entity.Shoes;

public interface ShoesService {
	List<Shoes> getShoes();

	List<Shoes> getShoesContainingText(String text);

	Shoes findByCode(String code);

	Shoes saveShoes(Shoes shoes);

	void deleteShoes(Shoes shoes);
}
