
package com.godFathersPizza.model;



public abstract class PizzaDecorator extends Pizza {
    private Pizza pizzaDecorata;

    public PizzaDecorator(Pizza pizzaDecorata) {
        super(pizzaDecorata.getNome(), pizzaDecorata.getPrezzo());
        this.pizzaDecorata = pizzaDecorata;
    }

    public Pizza getPizzaDecorata() {
        return pizzaDecorata;
    }

    public void setPizzaDecorata(Pizza pizzaDecorata) {
        this.pizzaDecorata = pizzaDecorata;
    }

	
	}

