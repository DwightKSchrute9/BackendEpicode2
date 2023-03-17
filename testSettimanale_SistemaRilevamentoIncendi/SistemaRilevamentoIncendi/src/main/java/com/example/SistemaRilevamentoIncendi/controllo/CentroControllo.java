package com.example.SistemaRilevamentoIncendi.controllo;

import com.example.SistemaRilevamentoIncendi.model.Allarme;
import com.example.SistemaRilevamentoIncendi.model.Sonda;

public class CentroControllo {
    private static String serverUrl = "http://host/alarm?";

    public static void notificaAllarme(Allarme allarme) {
        Sonda sonda = allarme.getSonda();
        String url = serverUrl + "idsonda=" + sonda.getIdSonda() + "&lat=" + sonda.getLatitude() + "&lon=" + sonda.getLongitude() + "&smokelevel=" + sonda.getSmokeLevel();
        System.out.println("Notifica inviata: " + url);
    }
}