package com.example.walletservice.services;

import com.example.walletservice.entities.Wallet;
import com.example.walletservice.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet findWalletByClientId(Long clientId) {
        return walletRepository.findByClientId(clientId);
    }
}
