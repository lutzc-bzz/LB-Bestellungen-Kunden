package org.example.kunden_bestellungen.Bestellungen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {
}
