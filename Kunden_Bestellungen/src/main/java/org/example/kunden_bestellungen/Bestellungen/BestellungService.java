package org.example.kunden_bestellungen.Bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BestellungService {
    @Autowired
    private BestellungRepository bestellungRepository;

    //READ
    public Bestellung findBestellungById(Long id) {
        return bestellungRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id) {
        return bestellungRepository.existsById(id);
    }

    public List<Bestellung> findAllBestellungen() {
        return bestellungRepository.findAll();
    }

    public List<Bestellung> findBestellungenByBestelldatum(LocalDateTime localDateTime) {
        return bestellungRepository.findByBestelldatum(localDateTime);
    }

    public long countBestellungen() {
        return bestellungRepository.count();
    }

    //CREATE
    public Bestellung saveBestellung(Bestellung bestellung) {
        return bestellungRepository.save(bestellung);
    }

    //UPDATE
    public Bestellung updateBestellung(Long id, Bestellung bestellung) {
        if (bestellungRepository.existsById(id)) {
            Bestellung existingBestellung = bestellungRepository.findById(id).orElse(null);
            if (existingBestellung != null) {
                existingBestellung.setBestelldatum(bestellung.getBestelldatum());
                existingBestellung.setMenge(bestellung.getMenge());
                existingBestellung.setPreis(bestellung.getPreis());
                existingBestellung.setProdukt(bestellung.getProdukt());
                existingBestellung.setKunde(bestellung.getKunde());

                return bestellungRepository.save(existingBestellung);
            }
        }
        return null;
    }

    //DELETE
     public void deleteBestellungById(Long id) {
            bestellungRepository.deleteById(id);
     }

    public void deleteAllBestellungen() {
        bestellungRepository.deleteAll();
    }
}
