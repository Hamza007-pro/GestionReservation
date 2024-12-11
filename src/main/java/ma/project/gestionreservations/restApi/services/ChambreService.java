package ma.project.gestionreservations.restApi.services;

import ma.project.gestionreservations.restApi.models.Chambre;
import ma.project.gestionreservations.restApi.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {
    private final ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre createChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Optional<Chambre> updateChambre(Long id, Chambre updatedChambre) {
        return chambreRepository.findById(id).map(chambre -> {
            chambre.setType(updatedChambre.getType());
            chambre.setPrix(updatedChambre.getPrix());
            chambre.setDisponible(updatedChambre.isDisponible());
            return chambreRepository.save(chambre);
        });
    }

    public boolean deleteChambre(Long id) {
        if (chambreRepository.existsById(id)) {
            chambreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
