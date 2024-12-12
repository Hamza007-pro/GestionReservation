package ma.project.gestionreservations.graphQl.controllers;

import ma.project.gestionreservations.restApi.models.Chambre;
import ma.project.gestionreservations.restApi.models.Client;
import ma.project.gestionreservations.restApi.models.Reservation;
import ma.project.gestionreservations.restApi.services.ChambreService;
import ma.project.gestionreservations.restApi.services.ClientService;
import ma.project.gestionreservations.restApi.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientService clientService;
    @Autowired
    private ChambreService chambreService;

    @QueryMapping
    public List<Reservation> allReservations() {
        return reservationService.getAllReservations();
    }

    @QueryMapping
    public Reservation reservationById(@Argument Long id) {
        return reservationService.getReservationById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
    }

    @MutationMapping
    public Reservation saveReservation(
            @Argument Long clientId,
            @Argument Long chambreId,
            @Argument String dateDebut,
            @Argument String dateFin,
            @Argument Map<String, String> preferences
    ) {
        Client client = clientService.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        Chambre chambre = chambreService.getChambreById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + chambreId));
        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(LocalDate.parse(dateDebut));
        reservation.setDateFin(LocalDate.parse(dateFin));
        reservation.setPreferences(preferences);
        return reservationService.createReservation(reservation);
    }

    @MutationMapping
    public String deleteReservationById(@Argument Long id) {
        reservationService.deleteReservation(id);
        return "Reservation with ID " + id + " was successfully deleted.";
    }

    @MutationMapping
    public Reservation updateReservation(
            @Argument Long id,
            @Argument Long clientId,
            @Argument Long chambreId,
            @Argument String dateDebut,
            @Argument String dateFin,
            @Argument String preferences // Update if needed
    ) {
        Client client = clientService.getClientById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        Chambre chambre = chambreService.getChambreById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + chambreId));
        Reservation existingReservation = reservationService.getReservationById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));
        existingReservation.setClient(client);
        existingReservation.setChambre(chambre);
        existingReservation.setDateDebut(LocalDate.parse(dateDebut));
        existingReservation.setDateFin(LocalDate.parse(dateFin));
        existingReservation.setPreferences(existingReservation.getPreferences());
        return reservationService.updateReservation(id, existingReservation)
                .orElseThrow(() -> new RuntimeException("Failed to update reservation with ID: " + id));
    }
}
