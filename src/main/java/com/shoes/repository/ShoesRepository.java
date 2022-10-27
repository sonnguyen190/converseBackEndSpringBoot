package com.shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoes.entity.Shoes;
@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long> {
	List<Shoes> findAllByOrderByTitle();

	List<Shoes> findByCodeContainingOrSizeContainingOrderByTitle(String code, String size);

	Shoes findByCode(String code);

}
