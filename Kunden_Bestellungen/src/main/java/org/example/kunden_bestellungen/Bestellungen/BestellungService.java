package org.example.kunden_bestellungen.Bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellungService {
    @Autowired
    private BestellungRepository bestellungRepository;

    public Bestellung findBestellungById(Long id) {
        return bestellungRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id) {
        return bestellungRepository.existsById(id);
    }

    public List<Bestellung> findAllBestellungen() {
        return bestellungRepository.findAll();
    }

    public long countBestellungen() {
        return bestellungRepository.count();
    }

    public Bestellung saveBestellung(Bestellung bestellung) {
        return bestellungRepository.save(bestellung);
    }

    public void deleteBestellungById(Long id) {
        bestellungRepository.deleteById(id);
    }

    public void deleteAllBestellungen() {
        bestellungRepository.deleteAll();
    }
}
