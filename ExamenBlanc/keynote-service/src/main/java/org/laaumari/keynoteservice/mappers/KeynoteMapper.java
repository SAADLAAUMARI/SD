package org.laaumari.keynoteservice.mappers;

import org.laaumari.keynoteservice.DTO.KeynoteDTO;
import org.laaumari.keynoteservice.entities.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

    // Mapper de Keynote vers KeynoteDTO
    public KeynoteDTO fromEntity(Keynote keynote) {
        return KeynoteDTO.builder()
                .id(keynote.getId())
                .nom(keynote.getNom())
                .prenom(keynote.getPrenom())
                .email(keynote.getEmail())
                .fonction(keynote.getFonction())
                .build();
    }

    // Mapper de KeynoteDTO vers Keynote
    public Keynote fromDTO(KeynoteDTO keynoteDTO) {
        return Keynote.builder()
                .id(keynoteDTO.getId())
                .nom(keynoteDTO.getNom())
                .prenom(keynoteDTO.getPrenom())
                .email(keynoteDTO.getEmail())
                .fonction(keynoteDTO.getFonction())
                .build();
    }
}
