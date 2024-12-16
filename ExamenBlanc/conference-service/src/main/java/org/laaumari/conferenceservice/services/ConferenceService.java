package org.laaumari.conferenceservice.services;

import org.laaumari.conferenceservice.dtos.ConferenceDTO;
import org.laaumari.conferenceservice.entities.Conference;
import org.laaumari.conferenceservice.entities.Review;
import org.laaumari.conferenceservice.mappers.ConferenceMapper;
import org.laaumari.conferenceservice.repositories.ConferenceRepository;
import org.laaumari.conferenceservice.model.Keynote;
import org.laaumari.conferenceservice.repositories.ReviewRepository;
import org.laaumari.conferenceservice.services.KeynoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private ConferenceMapper conferenceMapper;

    @Autowired
    private KeynoteClient keynoteClient;

    // Récupérer toutes les conférences
    public List<ConferenceDTO> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        return conferences.stream()
                .map(conferenceMapper::fromEntity)
                .collect(Collectors.toList());
    }

    // Récupérer une conférence par ID avec Keynote
    public ConferenceDTO getConferenceById(Long id) {
        Optional<Conference> conferenceOptional = conferenceRepository.findById(id);
        if (conferenceOptional.isPresent()) {
            Conference conference = conferenceOptional.get();
            Keynote keynote = keynoteClient.getKeynoteById(conference.getKeynoteId()); // Utilisation de FeignClient
            ConferenceDTO conferenceDTO = conferenceMapper.fromEntity(conference);
            conferenceDTO.setKeynote(keynote); // Ajouter les informations de Keynote à la conférence
            return conferenceDTO;
        } else {
            throw new RuntimeException("Conference not found");
        }
    }

    // Ajouter une conférence
    public ConferenceDTO addConference(ConferenceDTO conferenceDTO) {
        Conference conference = conferenceMapper.fromDTO(conferenceDTO);
        conference = conferenceRepository.save(conference);
        return conferenceMapper.fromEntity(conference);
    }

    // Ajouter une review à une conférence
    public Review addReviewToConference(Long conferenceId, Review review) {
        Optional<Conference> conferenceOptional = conferenceRepository.findById(conferenceId);
        if (conferenceOptional.isPresent()) {
            Conference conference = conferenceOptional.get();
            review.setConference(conference);
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Conference not found");
        }
    }
}
