package org.example.kunden_bestellungen.Kunden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {
    @Autowired
    private KundeRepository kundeRepository;

    public Kunde findKundeById(Long id) {
        return kundeRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id) {
        return kundeRepository.existsById(id);
    }

    public List<Kunde> findAllKunden() {
        return kundeRepository.findAll();
    }

    public long countKunden() {
        return kundeRepository.count();
    }

    public Kunde saveKunde(Kunde kunde) {
        return kundeRepository.save(kunde);
    }

    public void deleteKundeById(Long id) {
        kundeRepository.deleteById(id);
    }

    public void deleteAllKunden() {
        kundeRepository.deleteAll();
    }
}