package com.example.client.repositories;

import com.example.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmailAndPassword(String email, String password);
    Optional<Client> findByEmail(String email);}