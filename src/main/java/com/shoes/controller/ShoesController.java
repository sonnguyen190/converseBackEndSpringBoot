package com.shoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoes.entity.ImageShoes;
import com.shoes.entity.Shoes;
import com.shoes.service.ShoesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoesController {
	@Autowired
	@Qualifier("shoesServiceImpl")
	private ShoesService shoesService;

	@GetMapping("/shoes")
	public List<Shoes> getAllShoes(@RequestParam(value = "text", required = false) String text) {
		List<Shoes> shoes = (text == null) ? shoesService.getShoes() : shoesService.getShoesContainingText(text);
		return shoes;
	}
	
	@GetMapping("/shoess")
	public Shoes getOneShoes(@RequestParam(value = "text", required = false) String text) {
		Shoes shoes = shoesService.findByCode(text);
		for (ImageShoes imageShoes : shoes.getListimage()) {
			System.out.println(imageShoes.getImg());
		}
		return shoes;
	}

	@PostMapping("/shoes")
	public Shoes createBook(@Valid @RequestBody Shoes shoesreq) {
		Shoes newShoes = shoesService.saveShoes(shoesreq);
		return newShoes;
	}

	@DeleteMapping("/shoes/{code}")
	public void deleteShoes(@PathVariable String code) {
		Shoes shoes = shoesService.findByCode(code);
		if (shoes == null) {
			//throw new BookNotFoundException(String.format("Book with isbn %s not found", id));
		}
		shoesService.deleteShoes(shoes);
	}

}
