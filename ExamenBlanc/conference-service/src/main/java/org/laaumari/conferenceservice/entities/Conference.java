package org.laaumari.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.laaumari.conferenceservice.enums.Type;
import org.laaumari.conferenceservice.model.Keynote;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Date date;
    private int duree; // EN minutes
    private int nbreInsc;
    private double score;
    private Long keynoteId;
    @Transient
    private Keynote keynote;
    @OneToMany(mappedBy = "conference", fetch = FetchType.LAZY)  // Relation OneToMany
    private List<Review> reviews; // Liste des reviews associées
}
