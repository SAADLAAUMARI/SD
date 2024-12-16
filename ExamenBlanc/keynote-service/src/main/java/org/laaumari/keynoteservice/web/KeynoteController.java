package org.laaumari.keynoteservice.web;

import org.laaumari.keynoteservice.DTO.KeynoteDTO;
import org.laaumari.keynoteservice.entities.Keynote;
import org.laaumari.keynoteservice.services.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteController {

    @Autowired
    private KeynoteService keynoteService;

    @GetMapping("/{id}")
    public KeynoteDTO getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id);
    }

    @PostMapping
    public Keynote addKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.addKeynote(keynoteDTO);
    }
}
