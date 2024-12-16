package org.laaumari.conferenceservice.services;

import org.laaumari.conferenceservice.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service", url = "http://localhost:8081/api/keynotes") // Remplace l'URL par celle de ton service keynote
public interface KeynoteClient {

    @GetMapping("/{id}")
    Keynote getKeynoteById(@PathVariable("id") Long id);
}
