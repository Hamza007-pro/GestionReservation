package ma.project.gestionreservations.restApi.services;

import ma.project.gestionreservations.restApi.models.Utilisateur;
import ma.project.gestionreservations.restApi.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> updateUtilisateur(Long id, Utilisateur updatedUtilisateur) {
        return utilisateurRepository.findById(id).map(utilisateur -> {
            utilisateur.setNomUtilisateur(updatedUtilisateur.getNomUtilisateur());
            utilisateur.setMotDePasse(updatedUtilisateur.getMotDePasse());
            utilisateur.setRole(updatedUtilisateur.getRole());
            return utilisateurRepository.save(utilisateur);
        });
    }

    public boolean deleteUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
