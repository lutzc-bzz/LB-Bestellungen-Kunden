package org.example.kunden_bestellungen.Bestellungen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {
    List<Bestellung> findByBestelldatum(LocalDateTime localDateTime);
}
