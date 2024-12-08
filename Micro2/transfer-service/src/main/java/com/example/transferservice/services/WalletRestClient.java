package com.example.transferservice.services;

import com.example.transferservice.model.Client;
import com.example.transferservice.model.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "WALLET-SERVICE")
public interface WalletRestClient {
    @GetMapping("/client/{id}")
    public Client getclientById(@PathVariable Long id);
    @GetMapping("/wallets")
    public PagedModel<Wallet> getWallets();
    @GetMapping("/clients")
    public PagedModel<Client> getClients();
    @GetMapping("/wallets/client/{id}")
    public Wallet getwalletByClient(@PathVariable Long id);
}
