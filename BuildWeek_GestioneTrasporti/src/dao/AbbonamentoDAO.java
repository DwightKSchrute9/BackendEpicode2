package dao;


import java.time.LocalDateTime;
import java.util.List;

import model.Abbonamento;

public interface AbbonamentoDAO {

    void addAbbonamento(Abbonamento abbonamento);

    void updateAbbonamento(Abbonamento abbonamento);

    Abbonamento getAbbonamentoById(int abbonamentoId);

    List<Abbonamento> getAllAbbonamenti();

    List<Abbonamento> getAbbonamentiByUser(int userId);

    List<Abbonamento> getAbbonamentiByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime);

}

