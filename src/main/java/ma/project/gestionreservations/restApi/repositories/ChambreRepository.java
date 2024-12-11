package ma.project.gestionreservations.restApi.repositories;

import ma.project.gestionreservations.restApi.models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByDisponible(boolean disponible);
}