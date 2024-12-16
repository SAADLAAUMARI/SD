package org.laaumari.conferenceservice.mappers;

import org.laaumari.conferenceservice.dtos.ConferenceDTO;
import org.laaumari.conferenceservice.entities.Conference;
import org.laaumari.conferenceservice.enums.Type;
import org.laaumari.conferenceservice.mappers.ReviewMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConferenceMapper {

    private final ReviewMapper reviewMapper;

    // Injection de ReviewMapper via le constructeur
    public ConferenceMapper(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public ConferenceDTO fromEntity(Conference conference) {
        // Créer un objet DTO et affecter les valeurs
        return ConferenceDTO.builder()
                .id(conference.getId())
                .titre(conference.getTitre())
                .type(conference.getType().toString())
                .date(conference.getDate())
                .duree(conference.getDuree())
                .nbreInsc(conference.getNbreInsc())
                .score(conference.getScore())
                .reviews(conference.getReviews().stream()
                        .map(reviewMapper::fromEntity)  // Utilisation du mapper pour chaque review
                        .collect(Collectors.toList()))
                .build();  // Retourne l'objet DTO créé
    }

    public Conference fromDTO(ConferenceDTO dto) {
        // Convertir le DTO en entité Conference
        Conference conference = new Conference();
        conference.setId(dto.getId());
        conference.setTitre(dto.getTitre());
        conference.setType(Type.valueOf(dto.getType()));  // Convertir le type en enum
        conference.setDate(dto.getDate());
        conference.setDuree(dto.getDuree());
        conference.setNbreInsc(dto.getNbreInsc());
        conference.setScore(dto.getScore());
        return conference;
    }
}