package com.comercio.comercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercio.comercio.food.Food;
import com.comercio.comercio.food.FoodRepository;
import com.comercio.comercio.food.FoodRequestDTO;
import com.comercio.comercio.food.FoodResponseDTO;

@RestController
@RequestMapping("food")

public class foodcontroller {
	@Autowired
	private FoodRepository repository;
	
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
	}
	
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;
	}
}
