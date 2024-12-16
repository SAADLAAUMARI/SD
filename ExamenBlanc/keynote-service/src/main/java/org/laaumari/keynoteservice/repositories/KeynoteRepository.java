package org.laaumari.keynoteservice.repositories;

import org.laaumari.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}
