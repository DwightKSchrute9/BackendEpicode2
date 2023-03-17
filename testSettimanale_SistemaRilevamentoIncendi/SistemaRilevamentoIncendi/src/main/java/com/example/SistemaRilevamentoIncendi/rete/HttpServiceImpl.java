package com.example.SistemaRilevamentoIncendi.rete;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServiceImpl implements HttpService {

    private String url = "http://host/alarm?idsonda=%s&lat=%s&lon=%s&smokelevel=%s";

    @Override
    public void sendNotification(String idSonda, double lat, double lon, int smokeLevel) throws Exception {
        String formattedUrl = String.format(url, idSonda, lat, lon, smokeLevel);
        URL url = new URL(formattedUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode(); // Esegue la richiesta
    }

	@Override
	public void inviaNotifica(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSmokeLevel(int smokeLevel) {
		// TODO Auto-generated method stub
		
	}
}