package com.example.EPIC.ENERGY.SERVICES.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Cliente;
import com.example.EPIC.ENERGY.SERVICES.model.StatoFattura;
import com.example.EPIC.ENERGY.SERVICES.model.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
    
    public List<Cliente> searchClienti(String search) {
        return clienteRepository.findByNomeContainingIgnoreCase(search);
    }
    
    public List<Cliente> getClientiByFilters(LocalDate dataInizio, LocalDate dataFine, StatoFattura stato, BigDecimal importoMin, BigDecimal importoMax) {
        return clienteRepository.findByFilters(dataInizio, dataFine, stato, importoMin, importoMax);
    }
    
    public List<Cliente> getClientiByFatturatoAnnuale(Integer anno) {
        return clienteRepository.findFatturatoAnnualeByAnno(anno)
                .stream()
                .map(object -> (Cliente)object[0])
                .collect(Collectors.toList());
    }
    
    public List<Cliente> getClientiOrderedByNome() {
        return clienteRepository.findAllOrderedByNome();
    }
    
    public List<Cliente> getClientiOrderedByFatturatoAnnuale() {
        return clienteRepository.findAllOrderedByFatturatoAnnuale();
    }
    
    public List<Cliente> getClientiOrderedByDataInserimento() {
        return clienteRepository.findAllOrderedByDataInserimento();
    }
    
    public List<Cliente> getClientiOrderedByDataUltimoContatto() {
        return clienteRepository.findAllOrderedByDataUltimoContatto();
    }
    
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
