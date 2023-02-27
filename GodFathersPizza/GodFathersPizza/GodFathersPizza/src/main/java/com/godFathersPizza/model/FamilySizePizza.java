package com.godFathersPizza.model;

import java.util.List;


public class FamilySizePizza extends Pizza {
    private final static String DESCRIPTION = "Family Size Pizza";
    private final static double BASE_PRICE = 0; // non ha un prezzo base
    private final static int BASE_CALORIES = 0; // non ha calorie base

    public FamilySizePizza(List<Ingredient> ingredients) {
        super(DESCRIPTION, calculateProductDetails(ingredients));
        addIngredients(ingredients);
    }

    private void addIngredients(List<Ingredient> ingredients) {
		// TODO Auto-generated method stub
		
	}

	private static ProductDetails calculateProductDetails(List<Ingredient> ingredients) {
        double totalPrice = BASE_PRICE;
        int totalCalories = BASE_CALORIES;

        for (Ingredient ingredient : ingredients) {
            totalPrice += ingredient.getPrice();
            totalCalories += ingredient.getCalories();
        }

        double finalPrice = totalPrice + 4.15;
        int finalCalories = (int) (totalCalories * 1.95);

        return new ProductDetails(finalPrice, finalCalories);
    }
}
