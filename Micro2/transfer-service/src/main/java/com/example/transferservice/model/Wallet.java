package com.example.transferservice.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Wallet {
    private UUID id;
    private Double solde;
    private Date date;
    private String devise;
    private Client client;
}
