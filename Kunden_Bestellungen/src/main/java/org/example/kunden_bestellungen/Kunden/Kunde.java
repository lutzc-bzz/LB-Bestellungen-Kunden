package org.example.kunden_bestellungen.Kunden;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.example.kunden_bestellungen.Bestellungen.Bestellung;

import java.util.Set;


@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private String vorname;
    private String adresse;
    private int plz;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bestellung> bestellungen;

    // Getter und Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public Set<Bestellung> getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(Set<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }
}
