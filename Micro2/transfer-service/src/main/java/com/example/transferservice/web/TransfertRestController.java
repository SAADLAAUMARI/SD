package com.example.transferservice.web;

import com.example.transferservice.repository.TransfertRepository;
import com.example.transferservice.services.WalletRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransfertRestController {

    @Autowired
    private TransfertRepository transfersRepository;

    @Autowired
    private WalletRestClient walletRestClientService;


}
