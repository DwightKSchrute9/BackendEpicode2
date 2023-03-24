package com.example.EPIC.ENERGY.SERVICES.DataLoaderCSV;



import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvImporter {

  public static void importCsvData() throws IOException {
    String filePath = "/path/to/csv/file.csv";
    Reader reader = Files.newBufferedReader(Paths.get(filePath));
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
    for (CSVRecord csvRecord : csvParser) {
      // Process CSV record
    }
  }
}
