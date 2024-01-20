package com.example.client.controllers;

import com.example.client.dto.PasswordUpdateRequest;
import com.example.client.entities.Client;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public Client save(@RequestBody Client client) {
        return service.addClient(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) throws Exception {
        return service.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.deleteClient(id);
    }


    @PostMapping("/login")
    public Client login(@RequestBody Client loginRequest) throws Exception {
        Client authenticatedClient = service.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (authenticatedClient != null) {
            return authenticatedClient;
        } else {
            throw new Exception("Login failed. Invalid email or password.");
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
        try {
            // Add log to see the incoming request
            System.out.println("Received password update request: " + request.getEmail());

            // Log the current password to check its value
            System.out.println("Current password received: " + request.getCurrentPassword());

            service.updatePassword(request.getEmail(), request.getCurrentPassword(), request.getNewPassword());

            // Log a success message
            System.out.println("Password updated successfully");

            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            // Log the exception message
            System.err.println("Password update failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
