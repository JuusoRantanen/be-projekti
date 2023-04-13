package be.foodproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Dish {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String name;
	private int price;
	private int timeMin;
	private String difficultLevel;
	
	@ManyToOne
	 @JoinColumn(name="categoryid")
	 private Category category;
	
	
	
	public Dish() {
		super();
		
	}
	
	public Dish(String name, int price, int timeMin, String difficultLevel, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.timeMin = timeMin;
		this.difficultLevel = difficultLevel;
		this.category = category;
	}
	
	public Dish(String name, int price, int timeMin, String difficultLevel) {
		super();
		this.name = name;
		this.price = price;
		this.timeMin = timeMin;
		this.difficultLevel = difficultLevel;
	}
	
	public Dish(Long id, String name, int price, int timeMin, String difficultLevel) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.timeMin = timeMin;
		this.difficultLevel = difficultLevel;
	}
	
	
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTimeMin() {
		return timeMin;
	}
	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}
	public String getDifficultLevel() {
		return difficultLevel;
	}
	public void setDifficultLevel(String difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + ", timeMin=" + timeMin + ", difficultLevel="
				+ difficultLevel + ", category=" + category + "]";
	}

	
	


}
