package ma.project.gestionreservations.soap.endpoints;

import ma.project.gestionreservations.restApi.models.Client;
import ma.project.gestionreservations.restApi.services.ClientService;
import ma.project.gestionreservations.soap.endpoints.interfaces.ClientSoapService;
import ma.project.gestionreservations.soap.entities.ClientRequest;
import ma.project.gestionreservations.soap.entities.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientSoapServiceImpl implements ClientSoapService {

    private final ClientService clientService;

    @Autowired
    public ClientSoapServiceImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientResponse createClient(ClientRequest request) {
        Client client = new Client();
        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setEmail(request.getEmail());
        client.setTelephone(request.getTelephone());

        Client savedClient = clientService.createClient(client);

        ClientResponse response = new ClientResponse();
        response.setClientId(savedClient.getId());
        return response;
    }

    @Override
    public ClientResponse getClientById(ClientRequest request) {
        Client client = clientService.getClientById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ClientResponse response = new ClientResponse();
        response.setClientId(client.getId());
        response.setNom(client.getNom());
        response.setPrenom(client.getPrenom());
        response.setEmail(client.getEmail());
        response.setTelephone(client.getTelephone());
        return response;
    }

    @Override
    public ClientResponse updateClient(ClientRequest request) {
        Client client = clientService.getClientById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setEmail(request.getEmail());
        client.setTelephone(request.getTelephone());

        Client updatedClient = clientService.createClient(client);

        ClientResponse response = new ClientResponse();
        response.setClientId(updatedClient.getId());
        return response;
    }

    @Override
    public ClientResponse deleteClient(ClientRequest request) {
        Client client = clientService.getClientById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        clientService.deleteClient(client.getId());

        ClientResponse response = new ClientResponse();
        response.setClientId(client.getId());
        return response;
    }
}
