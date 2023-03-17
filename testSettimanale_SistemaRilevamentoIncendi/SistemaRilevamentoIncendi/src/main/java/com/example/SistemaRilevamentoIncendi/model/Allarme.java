package com.example.SistemaRilevamentoIncendi.model;

public class Allarme {
    private Sonda sonda;
    private boolean isAttivo;

    public Allarme(Sonda sonda) {
        this.sonda = sonda;
        this.isAttivo = false; // l'allarme di default è disattivato
    }

    public Sonda getSonda() {
        return sonda;
    }

    public boolean isAttivo() {
        return isAttivo;
    }

    public void attiva() {
        this.isAttivo = true;
    }

    public void disattiva() {
        this.isAttivo = false;
    }
}