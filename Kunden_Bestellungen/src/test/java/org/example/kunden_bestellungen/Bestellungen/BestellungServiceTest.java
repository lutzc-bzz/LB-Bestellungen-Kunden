package org.example.kunden_bestellungen.Bestellungen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BestellungServiceTest {

    @Autowired
    private BestellungService bestellungService;

    @Autowired
    private BestellungRepository bestellungRepository;

    @BeforeEach
    void setUp() {
        bestellungRepository.deleteAll();
    }

    //READ
    @Test
    public void testFindBestellungById() {
        // Objekt erstellen
        Bestellung bestellung = new Bestellung();
        bestellung.setProdukt("Produkt1");
        bestellung.setMenge(10);
        bestellung.setPreis(99.99);
        bestellung.setBestelldatum(LocalDateTime.now());

        // Objekt abspeichern
        Bestellung savedBestellung = bestellungService.saveBestellung(bestellung);
        // abgespeichertes Objekt mit "findById" suchen und abspeichern
        Bestellung foundBestellung = bestellungService.findBestellungById(savedBestellung.getId());
        // ist gefundenes Objekt nicht null?
        assertNotNull(foundBestellung);
    }

    @Test
    public void testExistById() {
        Bestellung bestellung = new Bestellung();
        bestellung.setProdukt("Produkt1");
        bestellung.setMenge(10);
        bestellung.setPreis(99.99);
        bestellung.setBestelldatum(LocalDateTime.now());

        Bestellung savedBestellung = bestellungService.saveBestellung(bestellung);
        boolean exists = bestellungService.existsById(savedBestellung.getId());
        assertTrue(exists);
    }

    @Test
    public void testFindAllBestellungen() {
        Bestellung bestellung1 = new Bestellung();
        bestellung1.setProdukt("Produkt1");
        bestellung1.setMenge(10);
        bestellung1.setPreis(99.99);
        bestellung1.setBestelldatum(LocalDateTime.now());

        Bestellung bestellung2 = new Bestellung();
        bestellung2.setProdukt("Produkt2");
        bestellung2.setMenge(5);
        bestellung2.setPreis(49.99);
        bestellung2.setBestelldatum(LocalDateTime.now());

        Bestellung savedBestellung1 = bestellungService.saveBestellung(bestellung1);
        Bestellung savedBestellung2 = bestellungService.saveBestellung(bestellung2);

        List<Bestellung> bestellungen = bestellungService.findAllBestellungen();

        assertTrue(bestellungen.stream().anyMatch(b -> b.getId().equals(savedBestellung1.getId()))
                && bestellungen.stream().anyMatch(b -> b.getId().equals(savedBestellung2.getId())));
    }

    @Test
    public void testFindBestellungenByBestelldatum() {
        LocalDateTime date = LocalDateTime.now();

        // Objekt erstellen
        Bestellung bestellung = new Bestellung();
        bestellung.setProdukt("Produkt1");
        bestellung.setMenge(10);
        bestellung.setPreis(99.99);
        bestellung.setBestelldatum(date);

        // Objekt abspeichern
        Bestellung savedBestellung = bestellungService.saveBestellung(bestellung);
        // abgespeichertes Objekt mit "findByBestelldatum" suchen und abspeichern
        List<Bestellung> foundBestellungen = bestellungService.findBestellungenByBestelldatum(date);

        // ist gefundenes Objekt nicht null und enthält es die gespeicherte Bestellung?
        assertTrue(foundBestellungen.stream().anyMatch(b -> b.getId().equals(savedBestellung.getId())));
    }

    //CREATE
    @Test
    public void testCreateBestellung() {
        Bestellung bestellung = new Bestellung();
        bestellung.setProdukt("Produkt1");
        bestellung.setMenge(10);
        bestellung.setPreis(99.99);
        bestellung.setBestelldatum(LocalDateTime.now());

        Bestellung savedBestellung = bestellungService.saveBestellung(bestellung);
        assertNotNull(savedBestellung.getId());
    }

    //UPDATE

    //DELETE
    @Test
    public void testDeleteBestellungById() {
        Bestellung bestellung = new Bestellung();
        bestellung.setProdukt("Produkt1");
        bestellung.setMenge(10);
        bestellung.setPreis(99.99);
        bestellung.setBestelldatum(LocalDateTime.now());

        Bestellung savedBestellung = bestellungService.saveBestellung(bestellung);
        bestellungService.deleteBestellungById(savedBestellung.getId());

        Bestellung foundBestellung = bestellungService.findBestellungById(savedBestellung.getId());
        assertNull(foundBestellung);
    }
}
