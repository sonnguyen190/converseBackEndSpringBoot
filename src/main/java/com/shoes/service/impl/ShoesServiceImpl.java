package com.shoes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoes.entity.Shoes;
import com.shoes.repository.ShoesRepository;
import com.shoes.service.ShoesService;

@Service
@Transactional
public class ShoesServiceImpl implements ShoesService{

	@Autowired
	private ShoesRepository shoesRepository;
	
	@Override
	public List<Shoes> getShoes() {
		 return shoesRepository.findAllByOrderByTitle();
	}

	@Override
	public List<Shoes> getShoesContainingText(String text) {
		return shoesRepository.findByCodeContainingOrSizeContainingOrderByTitle(text, text);
	}

	@Override
	public Shoes findByCode(String code) {
		return shoesRepository.findByCode(code);
	}

	@Override
	public Shoes saveShoes(Shoes shoes) {
		Shoes shoees = shoesRepository.findByCode(shoes.getCode());
		if(shoes != null) {
			shoees.setName(shoes.getName());
			shoees.setPrice(shoes.getPrice());
			shoees.setTitle(shoes.getTitle());
		}
		return shoees != null ? shoesRepository.save(shoees) : shoesRepository.save(shoes);
	}

	@Override
	public void deleteShoes(Shoes shoes) {
		// TODO Auto-generated method stub
		
	}

	

}
