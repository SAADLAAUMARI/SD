package org.laaumari.keynoteservice.DTO;

import lombok.*;

@Data
@Builder
public class KeynoteDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
