package util;

import java.text.ParseException;

import dao.LibroDao;
import dao.PrestitoDao;
import dao.RivistaDao;
import dao.UtenteDao;
import model.Libro;
import model.Periodicita;
import model.Prestito;
import model.Rivista;
import model.Utente;

public class ArchivioMain {
    public static void main(String[] args) throws ParseException {
     Libro j4d = new Libro("123456", "Java 4 Dummies", 2022, 503, "Ciccio pasticcio","Programmazione");
     LibroDao.add(j4d);
     
     Rivista cioe = new Rivista("123457", "Cioè", 2022, 65, Periodicita.MENSILE);
     RivistaDao.add(cioe);
     
     Utente marco = new Utente(55596541,"Marco","Barbieri","1990-12-15");
     UtenteDao.add(marco);
     
     Prestito prestito1 = new Prestito(marco, j4d, cioe,"2023-01-15","2023-02-15","");
     PrestitoDao.add(prestito1);
          
     
     
     

    
    }
}
