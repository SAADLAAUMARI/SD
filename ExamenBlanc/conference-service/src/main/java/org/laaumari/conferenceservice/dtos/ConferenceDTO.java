package org.laaumari.conferenceservice.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.laaumari.conferenceservice.model.Keynote;

import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@Builder
public class ConferenceDTO {
    private Long id;
    private String titre;
    private String type;
    private Date date;
    private int duree;
    private int nbreInsc;
    private double score;
    private List<ReviewDTO> reviews;
    private Keynote keynote;
}
