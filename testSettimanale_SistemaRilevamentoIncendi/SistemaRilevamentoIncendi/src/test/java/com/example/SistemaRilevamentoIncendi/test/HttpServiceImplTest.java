package com.example.SistemaRilevamentoIncendi.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

import com.example.SistemaRilevamentoIncendi.rete.HttpServiceImpl;

public class HttpServiceImplTest {

    @Test
    public void testSendNotification() throws Exception {
        String expectedUrl = "http://host/alarm?idsonda=123456&lat=45.123456&lon=9.123456&smokelevel=7";
        URL urlMock = mock(URL.class);
        HttpURLConnection conMock = mock(HttpURLConnection.class);
        when(urlMock.openConnection()).thenReturn(conMock);
        when(conMock.getResponseCode()).thenReturn(200);

        HttpServiceImpl httpService = new HttpServiceImpl();
        httpService.sendNotification("123456", 45.123456, 9.123456, 7);

        verify(urlMock).openConnection();
        verify(conMock).setRequestMethod("GET");
        verify(conMock).getResponseCode();
    }
}