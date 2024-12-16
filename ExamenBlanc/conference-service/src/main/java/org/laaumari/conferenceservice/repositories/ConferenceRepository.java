package org.laaumari.conferenceservice.repositories;

import org.laaumari.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
