package com.example.EPIC.ENERGY.SERVICES.DataLoaderCSV;

import java.io.FileReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.EPIC.ENERGY.SERVICES.model.Comune;
import com.example.EPIC.ENERGY.SERVICES.model.Provincia;
import com.example.EPIC.ENERGY.SERVICES.model.repository.ComuneRepository;
import com.example.EPIC.ENERGY.SERVICES.model.repository.ProvinciaRepository;

import io.jsonwebtoken.io.IOException;

@Component
public class DataLoader<CSVParser, CSVReader> {
   @Autowired
   private ProvinciaRepository provinciaRepository;
   
   @Autowired
   private ComuneRepository comuneRepository;
   
   public void load() {
      try (Reader reader = new FileReader("path/to/file.csv")) {
         CSVParser parser = ((Object) new CSVParserBuilder(reader).withSeparator(',')).withIgnoreQuotations(true).build();
         CSVReader csvReader = new CSVParserBuilder(reader).withCSVParser(parser).build();
         String[] line;
         while ((line = ((Object) csvReader).readNext()) != null) {
            // crea la provincia se non esiste
            Provincia provincia = provinciaRepository.findByNome(line[0]).orElseGet(() -> {
               Provincia newProvincia = new Provincia();
               newProvincia.setNome(line[0]);
               return provinciaRepository.save(newProvincia);
            });
            // crea il comune
            Comune comune = new Comune();
            comune.setNome(line[1]);
            comune.setProvincia(provincia);
            comuneRepository.save(comune);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
