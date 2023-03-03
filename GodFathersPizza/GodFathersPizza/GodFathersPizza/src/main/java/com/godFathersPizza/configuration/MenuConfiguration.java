package com.godFathersPizza.configuration;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.godFathersPizza.model.Bevanda;
import com.godFathersPizza.model.Pizza;
import com.godFathersPizza.model.PizzaMargherita;
import com.godFathersPizza.model.PizzaTopping;
import com.godFathersPizza.model.Prodotto;
import com.godFathersPizza.model.Topping;

@Configuration
public class MenuConfiguration {
	
	// Bean for Pizzas
	@Bean(name = "pizzaMargherita")
	public Pizza pizzaMargherita() {
		PizzaMargherita pizzaMargherita = new PizzaMargherita();
		pizzaMargherita.setCalories(1104);
		pizzaMargherita.setPrice(new BigDecimal("4.99"));
		return pizzaMargherita;
	}

	@Bean(name = "hawaiianPizza")
	public Pizza hawaiianPizza() {
		Pizza pizza = new Pizza("Hawaiian Pizza", 6.49);
		pizza.setCalories(1024);
		List<Topping> toppings = Arrays.asList(
			new Topping("ham", 35, new BigDecimal("0.99")),
			new Topping("pineapple", 24, new BigDecimal("0.79"))
		);
		pizza.setToppings(toppings);
		return pizza;
	}
	
	@Bean(name = "salamiPizza")
	public Pizza salamiPizza() {
		Pizza pizza = new Pizza("Salami Pizza", 5.99);
		pizza.setCalories(1160);
		List<Topping> toppings = Arrays.asList(
			new Topping("salami", 86, new BigDecimal("0.99"))
		);
		pizza.setToppings(toppings);
		return pizza;
	}
	
	@Bean(name = "familySizePizza")
	public Pizza familySizePizza() {
		Pizza pizza = new Pizza("Family Size Pizza", 12.99);
		pizza.setCalories(0);
		List<Topping> toppings = Arrays.asList(
			new Topping("cheese", 92, new BigDecimal("0.69")),
			new Topping("ham", 35, new BigDecimal("0.99")),
			new Topping("onions", 22, new BigDecimal("0.69")),
			new Topping("pineapple", 24, new BigDecimal("0.79")),
			new Topping("salami", 86, new BigDecimal("0.99"))
		);
		pizza.setToppings(toppings);
		return pizza;
	}
	
	// Bean for Toppings
	@Bean(name = "cheeseTopping")
	public Topping cheeseTopping() {
		return new Topping("cheese", 92, new BigDecimal("0.69"));
	}
	
	@Bean(name = "hamTopping")
	public Topping hamTopping() {
		return new Topping("ham", 35, new BigDecimal("0.99"));
	}
	
	@Bean(name = "onionsTopping")
	public Topping onionsTopping() {
		return new Topping("onions", 22, new BigDecimal("0.69"));
	}
	
	@Bean(name = "pineappleTopping")
	public Topping pineappleTopping() {
		return new Topping("Pineapple", 24, new BigDecimal("0.79"));
	}
}
	
	
