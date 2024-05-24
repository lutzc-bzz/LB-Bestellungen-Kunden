package org.example.kunden_bestellungen.Kunden;

import org.example.kunden_bestellungen.Bestellungen.Bestellung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunden")
public class KundeController {
    @Autowired
    private KundeService kundeService;

    @GetMapping("/{id}")
    public Kunde getKundeById(@PathVariable Long id) {
        return kundeService.findKundeById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return kundeService.existsById(id);
    }

    @GetMapping
    public List<Kunde> getAllKunden() {
        return kundeService.findAllKunden();
    }

    @GetMapping("/count")
    public long countKunden() {
        return kundeService.countKunden();
    }

    @PostMapping
    public Kunde createKunde(@RequestBody Kunde kunde) {
        return kundeService.saveKunde(kunde);
    }

    @PutMapping("/{id}")
    public Kunde updateBestellung(@RequestBody Long id, Kunde kunde) {
        return kundeService.updateKunde(id, kunde);
    }

    @DeleteMapping("/{id}")
    public void deleteKundeById(@PathVariable Long id) {
        kundeService.deleteKundeById(id);
    }

    @DeleteMapping
    public void deleteAllKunden() {
        kundeService.deleteAllKunden();
    }
}
