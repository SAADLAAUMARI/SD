package com.example.walletservice.web;

import com.example.walletservice.entities.Wallet;
import com.example.walletservice.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Dans le contrôleur WalletController du microservice wallet-service
@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService; // Assurez-vous d'avoir un service pour gérer la logique métier

    @GetMapping("/client/{id}")
    public ResponseEntity<Wallet> getWalletByClientId(@PathVariable("id") Long clientId) {
        Wallet wallet = walletService.findWalletByClientId(clientId);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // autres endpoints
}
