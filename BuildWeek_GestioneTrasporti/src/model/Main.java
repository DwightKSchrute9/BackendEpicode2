package model;

import java.time.LocalDateTime;

public class Main {
    
    public static void main(String[] args) {
        // creazione di un utente
        User user = new User("Mario", "Rossi", "mr@gmail.com");
        System.out.println("Nome utente: " + user.getName());
        System.out.println("Password corretta: " + user.check_password("12345"));
        System.out.println();
        
        // creazione di una stazione
        Stazione stazione1 = new Stazione("Milano Centrale");
        Stazione stazione2 = new Stazione("Roma Termini");
        System.out.println("Nome stazione 1: " + stazione1.toString());
        System.out.println("Nome stazione 2: " + stazione2.toString());
        System.out.println();
        
        // creazione di una tratta
        Tratta tratta = new Tratta();
        System.out.println("Tratta: " + tratta.toString());
        System.out.println("Distanza: " + tratta.get_distance());
        System.out.println();
        
        // creazione di un biglietto
        @SuppressWarnings("rawtypes")
        Biglietto biglietto = new Biglietto(tratta, LocalDateTime.of(2023, 2, 22, 10, 30), 25.0);
        System.out.println("Prezzo biglietto: " + biglietto.getPrezzo());
        System.out.println();
        
        // creazione di un abbonamento
        @SuppressWarnings("rawtypes")
        Abbonamento abbonamento = new Abbonamento(tratta, LocalDateTime.of(2023, 3, 1, 0, 0), LocalDateTime.of(2023, 3, 31, 23, 59), 80.0);
        System.out.println("Prezzo abbonamento: " + abbonamento.getPrezzo());
        System.out.println();
        
        // creazione di una tessera
        Tessera tessera = new Tessera("12345678", LocalDateTime.of(2023, 12, 31, 23, 59), user);
        System.out.println("Saldo tessera: " + tessera.get_saldo());
        tessera.aggiungi_saldo(50.0);
        System.out.println("Saldo tessera dopo ricarica: " + tessera.get_saldo());
        System.out.println();
        
        // creazione di un distributore automatico
        @SuppressWarnings("rawtypes")
        DistributoreAutomatico distributore = new DistributoreAutomatico("Piazza Duomo");
        System.out.println("Nome distributore: " + distributore.toString());
        distributore.carica_cassa(100.0);
        System.out.println("Cassa distributore: " + distributore.get_cassa());
        System.out.println();
        
        // creazione di un viaggio
        Viaggio viaggio = new Viaggio(biglietto, abbonamento, tessera, distributore);
        System.out.println("Prezzo viaggio: " + viaggio.getPrezzo());
        System.out.println("Sconto abbonamento: " + viaggio.get_sconto_abbonamento());
        System.out.println("Sconto tessera: " + viaggio.get_sconto_tessera());
        System.out.println("Cambio restituito: " + viaggio.paga(30.0));
        System.out.println();
        
        // creazione di una prenotazione
       // Prenotazione prenotazione = new P
    }
}
