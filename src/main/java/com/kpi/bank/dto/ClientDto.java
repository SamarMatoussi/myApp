package com.kpi.bank.dto;

import com.kpi.bank.entites.Client;
import com.kpi.bank.form.ClientFrom;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClientDto extends ClientFrom {
    private Long id;


    public ClientDto(Client client) {
        super(client);
        this.id = client.getId();
    }
    public static ClientDto of(Client client)
    {
        return new ClientDto(client);
    }

    public static List<ClientDto> of(List<Client> clients){
        return clients.stream().map(ClientDto::of).collect(Collectors.toList());
    }
}
