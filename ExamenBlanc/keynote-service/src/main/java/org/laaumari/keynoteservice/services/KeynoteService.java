package org.laaumari.keynoteservice.services;

import org.laaumari.keynoteservice.DTO.KeynoteDTO;
import org.laaumari.keynoteservice.entities.Keynote;
import org.laaumari.keynoteservice.mappers.KeynoteMapper;
import org.laaumari.keynoteservice.repositories.KeynoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeynoteService {

    @Autowired
    private KeynoteRepository keynoteRepository;

    @Autowired
    private KeynoteMapper keynoteMapper;

    // Ajouter un keynote
    public Keynote addKeynote(KeynoteDTO dto) {
        Keynote keynote = Keynote.builder()
                .nom(dto.getNom())          // Utilisation des getters
                .prenom(dto.getPrenom())
                .email(dto.getEmail())
                .fonction(dto.getFonction())
                .build();

        return keynoteRepository.save(keynote);
    }

    // Récupérer un keynote par ID
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Keynote not found"));
        return keynoteMapper.fromEntity(keynote);
    }
}
