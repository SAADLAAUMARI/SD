package org.laaumari.conferenceservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {
    private Long id;
    private LocalDate date;
    private String texte;
    private int note; // 1 à 5
    private Long conferenceId; // ID de la conférence associée
}
