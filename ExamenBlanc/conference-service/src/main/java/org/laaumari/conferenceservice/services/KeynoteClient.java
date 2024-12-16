package org.laaumari.conferenceservice.services;

import org.laaumari.conferenceservice.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "KEYNOTE-SERVICE") // Remplace l'URL par celle de ton service keynote
public interface KeynoteClient {

    @GetMapping("/api/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable("id") Long id);
}
