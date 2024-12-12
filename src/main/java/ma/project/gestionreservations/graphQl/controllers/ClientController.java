package ma.project.gestionreservations.graphQl.controllers;

import ma.project.gestionreservations.restApi.models.Client;
import ma.project.gestionreservations.restApi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @QueryMapping
    public List<Client> allClients() {
        return clientService.getAllClients();
    }

    @QueryMapping
    public Client clientById(@Argument Long id) {
        return clientService.getClientById(id).orElse(null);
    }

    @MutationMapping
    public Client createClient(
            @Argument String nom,
            @Argument String prenom,
            @Argument String email,
            @Argument String telephone
    ) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        client.setTelephone(telephone);
        return clientService.createClient(client);
    }

    @MutationMapping
    public Optional<Client> updateClient(
            @Argument Long id,
            @Argument String nom,
            @Argument String prenom,
            @Argument String email,
            @Argument String telephone
    ) {
        Client existingClient = clientService.getClientById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setNom(nom);
            existingClient.setPrenom(prenom);
            existingClient.setEmail(email);
            existingClient.setTelephone(telephone);
            return clientService.updateClient(id,existingClient);
        }

        return null;
    }


    @MutationMapping
    public Boolean deleteClient(@Argument Long id) {
        clientService.deleteClient(id);
        return true;
    }
}
