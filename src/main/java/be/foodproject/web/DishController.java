package be.foodproject.web;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import be.foodproject.domain.CategoryRepository;
import be.foodproject.domain.Dish;
import be.foodproject.domain.DishRepository;

@Controller
public class DishController {
	private static final org.slf4j.Logger Log = LoggerFactory.getLogger(DishController.class);

	@Autowired
	DishRepository dishRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@GetMapping("/index")
	 public String home(Model model) {
	return "index";
	}
	
	@GetMapping("dishes")
	public String showDishes(Model model) {
		model.addAttribute("dishes", dishRepository.findAll());
		return "dishes";
	}
	
	@GetMapping("/addDish")
	public String addDish(Model model) {
		Log.info("Moving to create new dish...");
		model.addAttribute("dish", new Dish());
		model.addAttribute("categories", categoryRepository.findAll());
		return "newDish";
	}
	
	@GetMapping("editDish/{id}")
	public String editDish(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editDish", dishRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editDish";
	}
	
	@PostMapping(value="/saveDish")
	public String saveDish(@Valid Dish dish, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Log.info("Validation error happened");
			return "newDish";
		}
		
		dishRepository.save(dish);
		return "redirect:dishes";
	}
	
	@GetMapping("categories")
	public String showCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categories";
	}
	
	@GetMapping("delete/{id}")
	public String deleteDish(@PathVariable("id") Long id, Model model) {
		
		dishRepository.deleteById(id);

		return "redirect:/dishes";
	}

}
