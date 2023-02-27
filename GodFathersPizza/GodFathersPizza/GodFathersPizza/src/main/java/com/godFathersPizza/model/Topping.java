package com.godFathersPizza.model;


public abstract class Topping extends Ingredient {
    protected Topping(String name, ProductDetails details) {
        super(name, details);
    }

    public static class Cheese extends Topping {
        private final static String NAME = "Cheese";
        private final static double PRICE = 0.69;
        private final static int CALORIES = 92;

        public Cheese() {
            super(NAME, new ProductDetails(PRICE, CALORIES));
        }
    }

    // altre classi di Topping (Ham, Onions, Pineapple, Salami)
}
