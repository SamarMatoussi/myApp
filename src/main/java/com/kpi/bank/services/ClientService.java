package com.kpi.bank.services;


import com.kpi.bank.entites.Client;
import com.kpi.bank.form.ClientFrom;

import java.util.List;
import java.util.Map;

public interface ClientService {
    public Client addClient(ClientFrom form);
    public Client updateClient(Long id, ClientFrom form);
    public Client getClient(Long id);
  //  public Map<String,Boolean> deleteClient(Long id);
  public Map<String, Boolean> disableClient(Long id);
    public Map<String, Boolean> enableClient(Long id);

    public List<Client> getClients();
}
