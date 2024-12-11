package ma.project.gestionreservations.soap.endpoints.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ma.project.gestionreservations.soap.entities.ChambreResponse;
import ma.project.gestionreservations.soap.entities.ChambreRequest;

@WebService
public interface ChambreSoapService {

    @WebMethod
    ChambreResponse createChambre(ChambreRequest request);

    @WebMethod
    ChambreResponse getChambreById(ChambreRequest request);

    @WebMethod
    ChambreResponse updateChambre(ChambreRequest request);

    @WebMethod
    ChambreResponse deleteChambre(ChambreRequest request);
}
