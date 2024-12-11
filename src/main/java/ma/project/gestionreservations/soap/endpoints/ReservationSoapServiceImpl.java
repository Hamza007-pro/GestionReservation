package ma.project.gestionreservations.soap.endpoints;

import ma.project.gestionreservations.restApi.models.Reservation;
import ma.project.gestionreservations.restApi.services.ReservationService;
import ma.project.gestionreservations.soap.endpoints.interfaces.ReservationSoapService;
import ma.project.gestionreservations.soap.entities.ReservationRequest;
import ma.project.gestionreservations.soap.entities.ReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationSoapServiceImpl implements ReservationSoapService {

    private final ReservationService reservationService;

    @Autowired
    public ReservationSoapServiceImpl(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public ReservationResponse createReservation(ReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setClient(request.getClient());
        reservation.setChambre(request.getChambre());
        reservation.setDateDebut(request.getDateDebut());
        reservation.setDateFin(request.getDateFin());
        reservation.setPreferences(request.getPreferences());

        Reservation savedReservation = reservationService.createReservation(reservation);

        ReservationResponse response = new ReservationResponse();
        response.setReservationId(savedReservation.getId());
        response.setClient(savedReservation.getClient());
        response.setChambre(savedReservation.getChambre());
        response.setDateDebut(savedReservation.getDateDebut());
        response.setDateFin(savedReservation.getDateFin());
        response.setPreferences(savedReservation.getPreferences());
        return response;
    }

    @Override
    public ReservationResponse getReservationById(ReservationRequest request) {
        Reservation reservation = reservationService.getReservationById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        ReservationResponse response = new ReservationResponse();
        response.setReservationId(reservation.getId());
        response.setClient(reservation.getClient());
        response.setChambre(reservation.getChambre());
        response.setDateDebut(reservation.getDateDebut());
        response.setDateFin(reservation.getDateFin());
        response.setPreferences(reservation.getPreferences());
        return response;
    }

    @Override
    public ReservationResponse updateReservation(ReservationRequest request) {
        Reservation reservation = reservationService.getReservationById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setClient(request.getClient());
        reservation.setChambre(request.getChambre());
        reservation.setDateDebut(request.getDateDebut());
        reservation.setDateFin(request.getDateFin());
        reservation.setPreferences(request.getPreferences());

        Reservation updatedReservation = reservationService.createReservation(reservation);

        ReservationResponse response = new ReservationResponse();
        response.setReservationId(updatedReservation.getId());
        response.setClient(updatedReservation.getClient());
        response.setChambre(updatedReservation.getChambre());
        response.setDateDebut(updatedReservation.getDateDebut());
        response.setDateFin(updatedReservation.getDateFin());
        response.setPreferences(updatedReservation.getPreferences());
        return response;
    }

    @Override
    public ReservationResponse deleteReservation(ReservationRequest request) {
        Reservation reservation = reservationService.getReservationById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservationService.deleteReservation(reservation.getId());

        ReservationResponse response = new ReservationResponse();
        response.setReservationId(reservation.getId());
        return response;
    }
}
