package com.example.SistemaRilevamentoIncendi.patterns;

import com.example.SistemaRilevamentoIncendi.model.Sonda;

public interface Observer {
    void update(Observable observable);

	void update(Observable observable, Object arg);
}