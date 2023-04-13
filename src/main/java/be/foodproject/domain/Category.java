package be.foodproject.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String name;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
@JsonIgnore
private List<Dish> dishes;


public Category() {
	super();
	// TODO Auto-generated constructor stub
}

public Category(long id, String name) {
	super();
	this.id = id;
	this.name = name;
}



public Category(String name) {
	super();
	this.name = name;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Dish> getDishes() {
	return dishes;
}

public void setBooks(List<Dish> dishes) {
	this.dishes = dishes;
}

@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + "]";
}



}
 
 

 
