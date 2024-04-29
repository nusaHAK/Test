package com.example.kundendatenForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long> {
    // Du kannst benutzerdefinierte Abfragen hier definieren, wenn nötig
	
}