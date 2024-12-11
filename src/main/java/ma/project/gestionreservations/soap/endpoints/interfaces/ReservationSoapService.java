package ma.project.gestionreservations.soap.endpoints.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import ma.project.gestionreservations.soap.entities.ReservationRequest;
import ma.project.gestionreservations.soap.entities.ReservationResponse;

@WebService
public interface ReservationSoapService {

    @WebMethod
    ReservationResponse createReservation(ReservationRequest request);

    @WebMethod
    ReservationResponse getReservationById(ReservationRequest request);

    @WebMethod
    ReservationResponse updateReservation(ReservationRequest request);

    @WebMethod
    ReservationResponse deleteReservation(ReservationRequest request);
}
