package ma.project.gestionreservations.soap.endpoints.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ma.project.gestionreservations.soap.entities.ClientRequest;
import ma.project.gestionreservations.soap.entities.ClientResponse;

@WebService
public interface ClientSoapService {

    @WebMethod
    ClientResponse createClient(ClientRequest request);

    @WebMethod
    ClientResponse getClientById(ClientRequest request);

    @WebMethod
    ClientResponse updateClient(ClientRequest request);

    @WebMethod
    ClientResponse deleteClient(ClientRequest request);
}
