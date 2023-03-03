package com.godFathersPizza.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza extends Prodotto {
    private List<String> ingredientiAggiunti = new ArrayList<>();

    public Pizza(String nome, double prezzo) {
        super(nome, prezzo);
    }

    public void aggiungiIngrediente(String ingrediente) {
        ingredientiAggiunti.add(ingrediente);
    }

    public List<String> getIngredientiAggiunti() {
        return ingredientiAggiunti;
    }

    public void setCalories(int i) {
        // TODO Auto-generated method stub

    }

    public abstract void setPrice(BigDecimal bigDecimal);
}


