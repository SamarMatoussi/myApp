package com.kpi.bank.controller;


import com.kpi.bank.dto.ClientDto;
import com.kpi.bank.entites.Client;
import com.kpi.bank.form.ClientFrom;
import com.kpi.bank.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/client")
@PreAuthorize("hasRole('ADMIN')")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClientController {
    @Autowired
    ClientService clientService;
    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/client")
    public ClientDto addClient(@Valid @RequestBody ClientFrom form){
        Client client = clientService.addClient(form);
        return ClientDto.of(client);
    }

    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/clients")
    public List<ClientDto> getAll(){
        List<Client> clients = clientService.getClients();
        return ClientDto.of(clients);
    }


    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping("/client/{id}")
    public ClientDto getClient(@PathVariable("id") long clientId){
        Client client = clientService.getClient(clientId);
        return ClientDto.of(client);
    }

    /*@PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/client/{id}")
    public Map<String,Boolean> deleteClient(@PathVariable("id") long clientId){
        return clientService.deleteClient(clientId);

    }*/
    @PreAuthorize("hasAuthority('admin:disable')")
    @PutMapping("/client/disable/{id}")
    public Map<String, Boolean> disableClient(@PathVariable("id") long clientId) {
        return clientService.disableClient(clientId);
    }


    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/client/{id}")
    public ClientDto updateClient(@PathVariable("id") long clientId,@Valid @RequestBody ClientFrom form){
        Client client = clientService.updateClient(clientId,form);
        return ClientDto.of(client);

    }
    @PreAuthorize("hasAuthority('admin:enable')")
    @PutMapping("/client/enable/{id}")
    public Map<String, Boolean> enableClient(@PathVariable("id") long clientId) {
        return clientService.enableClient(clientId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
