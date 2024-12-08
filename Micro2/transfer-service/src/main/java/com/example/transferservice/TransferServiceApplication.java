package com.example.transferservice;

import com.example.transferservice.entities.Transfert;
import com.example.transferservice.enums.Etat;
import com.example.transferservice.model.Client;
import com.example.transferservice.model.Wallet;
import com.example.transferservice.repository.TransfertRepository;
import com.example.transferservice.services.WalletRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class TransferServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start( WalletRestClient walletRestClient, TransfertRepository transfertRepository){
        return args -> {
            Wallet wallet=walletRestClient.getwalletByClient(1L);
            Wallet wd=walletRestClient.getwalletByClient(2L);
          transfertRepository.save(new Transfert(null,new Date(),wallet.getId(),wd.getId(),null,null,254.00, Etat.PENDIND));
        };
}
}
