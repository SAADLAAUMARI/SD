package com.example.walletservice.repositories;

import com.example.walletservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
}
