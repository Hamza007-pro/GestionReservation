package ma.project.gestionreservations.soap.endpoints.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ma.project.gestionreservations.soap.entities.UtilisateurRequest;
import ma.project.gestionreservations.soap.entities.UtilisateurResponse;

@WebService
public interface UtilisateurSoapService {

    @WebMethod
    UtilisateurResponse createUtilisateur(UtilisateurRequest request);

    @WebMethod
    UtilisateurResponse getUtilisateurById(UtilisateurRequest request);

    @WebMethod
    UtilisateurResponse updateUtilisateur(UtilisateurRequest request);

    @WebMethod
    UtilisateurResponse deleteUtilisateur(UtilisateurRequest request);
}
