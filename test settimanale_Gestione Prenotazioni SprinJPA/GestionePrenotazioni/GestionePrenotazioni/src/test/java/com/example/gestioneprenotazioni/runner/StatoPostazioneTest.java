package com.example.gestioneprenotazioni.runner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gestioneprenotazioni.service.PostazioneService;

@SpringBootTest
class StatoPostazioneTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private PostazioneService postazioneService;
    private StatoPostazione statoPostazione;

    @BeforeEach
    void setUp() {
        postazioneService = new PostazioneService();
        statoPostazione = new StatoPostazione(postazioneService);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testPostazioneOccupata() throws Exception {
        String[] args = {"", "", "", "", "001", "2023", "03", "05"};
        statoPostazione.run(args);
        assertEquals("OCCUPATA\n", outContent.toString());
    }

    @Test
    void testPostazioneLibera() throws Exception {
        String[] args = {"", "", "", "", "001", "2023", "03", "06"};
        statoPostazione.run(args);
        assertEquals("LIBERA\n", outContent.toString());
    }

}
