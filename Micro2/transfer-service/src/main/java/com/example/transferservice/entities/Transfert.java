package com.example.transferservice.entities;

import com.example.transferservice.enums.Etat;
import com.example.transferservice.model.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Transfert {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private UUID walletSourceId;
    private UUID walletDestinationId;
    @Transient
    private Wallet walletSource;
    @Transient
    private Wallet walletDestination;
    private Double montant;
    @Enumerated(EnumType.STRING)
    private Etat etat;
}
