package com.example.walletservice;

import com.example.walletservice.entities.Client;
import com.example.walletservice.entities.Wallet;
import com.example.walletservice.repositories.ClientRepository;
import com.example.walletservice.repositories.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository, WalletRepository walletRepository){

        return args -> {
            clientRepository.saveAll(List.of(
                    Client.builder().nom("saad").email("saad@gmail.com").build(),
                    Client.builder().nom("sami").email("sami@gmail.com").build(),
                    Client.builder().nom("mohamed").email("mohamed@gmail.com").build()
            ));

            clientRepository.findAll().forEach(client->{
                walletRepository.save(Wallet.builder().id(UUID.randomUUID()).solde(8945.00+Math.random()).devise("DH").date(new Date()).client(client).build());
            });
        };
    }
}
