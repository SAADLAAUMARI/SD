package com.example.walletservice.repositories;

import com.example.walletservice.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Wallet findByClientId(Long clientId);
}
