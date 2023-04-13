package be.foodproject;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.foodproject.domain.AppUser;
import be.foodproject.domain.AppUserRepository;
import be.foodproject.domain.Category;
import be.foodproject.domain.CategoryRepository;
import be.foodproject.domain.Dish;
import be.foodproject.domain.DishRepository;


@SpringBootApplication
public class FoodprojectApplication {
	
	private static final Logger log = LoggerFactory.getLogger(FoodprojectApplication.class);


	@Autowired
	DishRepository dishRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FoodprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(DishRepository dishRepository, CategoryRepository categoryRepository, AppUserRepository appUserRepository) {
		return (args) -> {
			
			categoryRepository.save(new Category("Pasta"));
			categoryRepository.save(new Category("Salad"));
			categoryRepository.save(new Category("Mexican"));
			categoryRepository.save(new Category("Rice"));
			categoryRepository.save(new Category("Healthy"));
			categoryRepository.save(new Category("Dessert"));
			
			AppUser user1 = new AppUser("USER", "user",
					"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
			AppUser user2 = new AppUser("ADMIN", "admin",
					"$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2");
			AppUser user3 = new AppUser("ADMIN", "juuso",
					"$2a$10$2o7RsdBG5E1.0eIayWXRmeUfcj7cpU.Tjsj5ejYo/WxP0RjkJb8Fq");
			appUserRepository.saveAll(Arrays.asList(user1, user2, user3));
			
			dishRepository.save(new Dish("Makaronilaatikko", 20, 90, "Easy", categoryRepository.findByName("Pasta").get(0)));
			dishRepository.save(new Dish("Pasta Carbonara", 10, 30, "Medium", categoryRepository.findByName("Pasta").get(0)));
			dishRepository.save(new Dish("Uunibataatit", 15, 75, "Easy", categoryRepository.findByName("Healthy").get(0)));
			dishRepository.save(new Dish("Tonnikalasalaatti", 7, 15, "Easy", categoryRepository.findByName("Salad").get(0)));
			dishRepository.save(new Dish("Tortillat", 20, 30, "Easy", categoryRepository.findByName("Mexican").get(0)));
			dishRepository.save(new Dish("Tonnikalasalaatti", 7, 15, "Easy", categoryRepository.findByName("Salad").get(0)));
			dishRepository.save(new Dish("Risotto verigreippi", 18, 60, "Hard", categoryRepository.findByName("Rice").get(0)));
			dishRepository.save(new Dish("Tiramisu", 15, 60, "Hard", categoryRepository.findByName("Dessert").get(0)));

		

			
			
			log.info("print dishes");
			for (Dish dish: dishRepository.findAll()) {
				log.info(dish.toString());
				};};}

}
