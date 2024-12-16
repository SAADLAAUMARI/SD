package org.laaumari.conferenceservice.mappers;

import org.laaumari.conferenceservice.dtos.ReviewDTO;
import org.laaumari.conferenceservice.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewDTO fromEntity(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setDate(review.getDate());
        dto.setTexte(review.getTexte());
        dto.setNote(review.getNote());
        dto.setConferenceId(review.getConference().getId());
        return dto;
    }

    public Review fromDTO(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId());
        review.setDate(dto.getDate());
        review.setTexte(dto.getTexte());
        review.setNote(dto.getNote());
        return review;
    }
}
