package org.example.kunden_bestellungen.Bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bestellungen")
public class BestellungController {
    @Autowired
    private BestellungService bestellungService;

    @GetMapping("/{id}")
    public Bestellung getBestellungById(@PathVariable Long id) {
        return bestellungService.findBestellungById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return bestellungService.existsById(id);
    }

    @GetMapping
    public List<Bestellung> getAllBestellungen() {
        return bestellungService.findAllBestellungen();
    }

    @GetMapping("/count")
    public long countBestellungen() {
        return bestellungService.countBestellungen();
    }

    @PostMapping
    public Bestellung createBestellung(@RequestBody Bestellung bestellung) {
        return bestellungService.saveBestellung(bestellung);
    }

    @PutMapping("/{id}")
    public Bestellung updateBestellung(@PathVariable Long id, @RequestBody Bestellung bestellung) {
        return bestellungService.updateBestellung(id, bestellung);
    }

    @DeleteMapping("/{id}")
    public void deleteBestellungById(@PathVariable Long id) {
        bestellungService.deleteBestellungById(id);
    }

    @DeleteMapping
    public void deleteAllBestellungen() {
        bestellungService.deleteAllBestellungen();
    }
}
