package com.godFathersPizza.model;

public class Bevanda extends Prodotto {
    private String marca;
    private double volume;

    public Bevanda(String nome, double prezzo, String marca, double volume) {
        super(nome, prezzo);
        this.marca = marca;
        this.volume = volume;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

