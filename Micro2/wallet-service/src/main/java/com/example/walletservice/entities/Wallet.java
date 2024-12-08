package com.example.walletservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    public Double solde;
    private Date date;
    private String devise;
    @ManyToOne
    private Client client;
}
