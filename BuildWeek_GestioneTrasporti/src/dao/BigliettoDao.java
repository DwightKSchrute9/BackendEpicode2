package dao;

import java.util.Date;
import java.util.List;

import model.Biglietto;

public interface BigliettoDao {
    
    
   
    public List<Biglietto> getAllTickets();
    public List<Biglietto> getTicketsByPeriod(Date startDate, Date endDate);
    public List<Biglietto> getTicketsByPointOfSale(int pointOfSaleId);
    
	void aggiungiBiglietto(Biglietto biglietto);
	void aggiornaBiglietto(Biglietto biglietto);
	Biglietto getBigliettoById(int bigliettoId);
	List<Biglietto> getBigliettiByPeriod(Date startDate, Date endDate);
	List<Biglietto> getBigliettiByPointOfSale(int pointOfSaleId);
}

 