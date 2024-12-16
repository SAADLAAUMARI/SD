package org.laaumari.conferenceservice;

import org.laaumari.conferenceservice.entities.Conference;
import org.laaumari.conferenceservice.entities.Review;
import org.laaumari.conferenceservice.model.Keynote;
import org.laaumari.conferenceservice.repositories.ConferenceRepository;
import org.laaumari.conferenceservice.repositories.ReviewRepository;
import org.laaumari.conferenceservice.services.KeynoteClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.laaumari.conferenceservice.enums.Type;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(KeynoteClient keynotes, ConferenceRepository conferenceRepository, ReviewRepository reviewRepository){
        return args -> {
            // Récupération des keynotes via le client
            Keynote keynote1 = keynotes.getKeynoteById(1L);
            Keynote keynote2 = keynotes.getKeynoteById(2L);

            // Création de deux conférences
            Conference conference1 = new Conference(
                    null, // ID généré automatiquement
                    "Conference 1", // Titre
                    Type.academique, // Type (vous pouvez changer le type selon vos besoins)
                    new Date(), // Date actuelle
                    60, // Durée en minutes
                    100, // Nombre d'inscriptions
                    4.5, // Score moyen
                    keynote1.getId(), // ID du keynote associé
                    null, // Liste des reviews (vide pour l'instant)
                    null // Liste des reviews associées
            );

            Conference conference2 = new Conference(
                    null, // ID généré automatiquement
                    "Conference 2", // Titre
                    Type.commerciale, // Type
                    new Date(), // Date actuelle
                    120, // Durée en minutes
                    200, // Nombre d'inscriptions
                    4.7, // Score moyen
                    keynote2.getId(), // ID du keynote associé
                    null, // Liste des reviews (vide pour l'instant)
                    null // Liste des reviews associées
            );

            // Enregistrement des conférences dans le repository
            conferenceRepository.save(conference1);
            conferenceRepository.save(conference2);

            // Création et ajout des reviews pour la conférence 1
            Review review1 = new Review(null, LocalDate.now(), "Excellent conférence sur les nouvelles technologies.", 5, conference1);
            Review review2 = new Review(null, LocalDate.now(), "Très intéressant, mais un peu trop long.", 4, conference1);

            reviewRepository.save(review1);
            reviewRepository.save(review2);

            // Création et ajout des reviews pour la conférence 2
            Review review3 = new Review(null, LocalDate.now(), "Conférence utile pour les professionnels du business.", 5, conference2);
            Review review4 = new Review(null, LocalDate.now(), "Contenu intéressant, mais manque de détails.", 3, conference2);

            reviewRepository.save(review3);
            reviewRepository.save(review4);
        };
    }

}
