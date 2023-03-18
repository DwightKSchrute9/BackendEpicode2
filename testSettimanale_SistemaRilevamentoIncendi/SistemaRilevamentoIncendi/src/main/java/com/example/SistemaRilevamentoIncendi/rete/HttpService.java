package com.example.SistemaRilevamentoIncendi.rete;

public interface HttpService {
    void inviaNotifica(String url);

	void sendNotification(String idSonda, double lat, double lon, int smokeLevel) throws Exception;

	void setSmokeLevel(int smokeLevel);
}


