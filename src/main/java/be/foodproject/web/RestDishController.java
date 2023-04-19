package be.foodproject.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.foodproject.domain.Category;
import be.foodproject.domain.CategoryRepository;
import be.foodproject.domain.Dish;
import be.foodproject.domain.DishRepository;

@RestController
public class RestDishController {
	
	@Autowired
	DishRepository dishRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/restdishes")
	public Iterable<Dish> getDishes() {
		return dishRepository.findAll();

	}
	
	@GetMapping("/restcategories")
	public Iterable<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/restdishes/{id}")
	Optional<Dish> getDish(@PathVariable Long id) {
		return dishRepository.findById(id);
	}
}
