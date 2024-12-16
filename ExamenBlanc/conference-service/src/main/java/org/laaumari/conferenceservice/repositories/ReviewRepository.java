package org.laaumari.conferenceservice.repositories;

import org.laaumari.conferenceservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByConferenceId(Long conferenceId);  // Rechercher les reviews pour une conférence donnée

}
