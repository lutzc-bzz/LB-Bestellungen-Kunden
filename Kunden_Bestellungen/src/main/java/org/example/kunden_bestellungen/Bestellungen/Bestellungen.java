package org.example.kunden_bestellungen.Bestellungen;

import java.util.Date;
import java.util.Objects;

public class Bestellungen {
    private int id;
    private String Produkt;
    private int Menge;
    private double Preis;
    private Date Bestelldatum;

    public Bestellungen() {}

    public int getMenge() {
        return Menge;
    }

    public void setMenge(int menge) {
        Menge = menge;
    }

    public double getPreis() {
        return Preis;
    }

    public void setPreis(double preis) {
        Preis = preis;
    }

    public Date getBestelldatum() {
        return Bestelldatum;
    }

    public void setBestelldatum(Date bestelldatum) {
        Bestelldatum = bestelldatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestellungen that = (Bestellungen) o;
        return id == that.id && Menge == that.Menge && Double.compare(Preis, that.Preis) == 0 && Objects.equals(Produkt, that.Produkt) && Objects.equals(Bestelldatum, that.Bestelldatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Produkt, Menge, Preis, Bestelldatum);
    }
}
