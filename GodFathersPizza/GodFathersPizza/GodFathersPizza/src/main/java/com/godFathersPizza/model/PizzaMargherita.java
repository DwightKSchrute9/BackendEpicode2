
package com.godFathersPizza.model;

import java.math.BigDecimal;

public class PizzaMargherita extends Pizza {
    private final static String DESCRIPTION = "Pizza Margherita (Tomato, Cheese)";
    private final static double BASE_PRICE = 4.99;
    private final static int BASE_CALORIES = 1104;

    public PizzaMargherita() {
        super(DESCRIPTION, new ProductDetails(BASE_PRICE, BASE_CALORIES));
        addIngredient(new Tomato());
        addIngredient(new Cheese());
    }

	public void setCalories(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
}

