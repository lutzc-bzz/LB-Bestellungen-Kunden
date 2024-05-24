package org.example.kunden_bestellungen.Bestellungen;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.example.kunden_bestellungen.Kunden.Kunde;
import java.time.LocalDateTime;

@Entity
public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String produkt;

    @NotEmpty
    private int menge;
    private double preis;
    private LocalDateTime bestelldatum;

    @ManyToOne
    @JoinColumn(name = "kunden_id")
    private Kunde kunde;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public LocalDateTime getBestelldatum() {
        return bestelldatum;
    }

    public void setBestelldatum(LocalDateTime bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
