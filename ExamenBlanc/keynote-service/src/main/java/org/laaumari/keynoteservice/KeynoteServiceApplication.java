package org.laaumari.keynoteservice;

import org.laaumari.keynoteservice.entities.Keynote;
import org.laaumari.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(KeynoteRepository clientRepository){

        return args -> {
            clientRepository.saveAll(List.of(
                    Keynote.builder().nom("LAAUMARI").prenom("Saad").email("saad@gmail.com").fonction("Dev").build(),
                    Keynote.builder().nom("SA").prenom("Sami").email("sami@gmail.com").fonction("Com").build(),
                    Keynote.builder().nom("mohamed").prenom("Adam").email("mohamed@gmail.com").fonction("Doc").build()
            ));

        };
    }
}
