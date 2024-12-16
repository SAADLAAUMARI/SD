package org.laaumari.conferenceservice.web;

import org.laaumari.conferenceservice.dtos.ConferenceDTO;
import org.laaumari.conferenceservice.dtos.ReviewDTO;
import org.laaumari.conferenceservice.entities.Review;
import org.laaumari.conferenceservice.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    // Récupérer toutes les conférences
    @GetMapping
    public List<ConferenceDTO> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    // Récupérer une conférence par ID
    @GetMapping("/{id}")
    public ConferenceDTO getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id);
    }

    // Ajouter une conférence
    @PostMapping
    public ConferenceDTO addConference(@RequestBody ConferenceDTO conferenceDTO) {
        return conferenceService.addConference(conferenceDTO);
    }

    // Ajouter une review à une conférence
    @PostMapping("/{conferenceId}/reviews")
    public Review addReviewToConference(@PathVariable Long conferenceId, @RequestBody Review review) {
        return conferenceService.addReviewToConference(conferenceId, review);
    }
}