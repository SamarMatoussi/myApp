package com.kpi.bank.services;

import com.kpi.bank.entites.Client;
import com.kpi.bank.form.ClientFrom;
import com.kpi.bank.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client addClient(ClientFrom form) {
        Client client = new Client();
        client.setNom(form.getLastname());
        client.setPrenom(form.getFirstname());
        client.setEmail(form.getEmail());
        client.setPhone(form.getPhone());
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, ClientFrom form) {
        Client client = getClient(id);
        client.setNom(form.getLastname());
        client.setPrenom(form.getFirstname());
        client.setEmail(form.getEmail());
        client.setPhone(form.getPhone());
        return clientRepository.save(client);    }

    @Override
    public Client getClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
        }

    /*@Override
    public Map<String, Boolean> deleteClient(Long id) {
        Client client = getClient(id);
        clientRepository.delete(client);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;    }*/

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
    @Override
    public Map<String, Boolean> disableClient(Long id) {
        Client client = getClient(id);

        if (client != null) {
            client.setDisabled(true);
            clientRepository.save(client);

            Map<String, Boolean> map = new HashMap<>();
            map.put("disabled", Boolean.TRUE);
            return map;
        } else {
            throw new EntityNotFoundException("Client not found with id: " + id);
        }
    }
    @Override
    public Map<String, Boolean> enableClient(Long id) {
        Client client = getClient(id);

        if (client != null) {
            client.setDisabled(false); // Réactiver le client
            clientRepository.save(client);

            Map<String, Boolean> map = new HashMap<>();
            map.put("enabled", Boolean.TRUE);
            return map;
        } else {
            throw new EntityNotFoundException("Client not found with id: " + id);
        }
    }

}
