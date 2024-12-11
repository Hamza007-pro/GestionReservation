package ma.project.gestionreservations.restApi.services;

import ma.project.gestionreservations.restApi.models.Reservation;
import ma.project.gestionreservations.restApi.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setClient(updatedReservation.getClient());
            reservation.setChambre(updatedReservation.getChambre());
            reservation.setDateDebut(updatedReservation.getDateDebut());
            reservation.setDateFin(updatedReservation.getDateFin());
            reservation.setPreferences(updatedReservation.getPreferences());
            return reservationRepository.save(reservation);
        });
    }

    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
