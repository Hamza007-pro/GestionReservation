package ma.project.gestionreservations.restApi.repositories;

import ma.project.gestionreservations.restApi.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClientId(Long clientId);
    List<Reservation> findByChambreIdAndDateDebutBetween(Long chambreId, LocalDate debut, LocalDate fin);
}