package ma.project.gestionreservations.soap.endpoints;

import ma.project.gestionreservations.restApi.models.Utilisateur;
import ma.project.gestionreservations.restApi.services.UtilisateurService;
import ma.project.gestionreservations.soap.endpoints.interfaces.UtilisateurSoapService;
import ma.project.gestionreservations.soap.entities.UtilisateurRequest;
import ma.project.gestionreservations.soap.entities.UtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurSoapServiceImpl implements UtilisateurSoapService {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurSoapServiceImpl(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurResponse createUtilisateur(UtilisateurRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur(request.getNomUtilisateur());
        utilisateur.setMotDePasse(request.getMotDePasse());
        utilisateur.setRole(request.getRole());

        Utilisateur savedUtilisateur = utilisateurService.createUtilisateur(utilisateur);

        UtilisateurResponse response = new UtilisateurResponse();
        response.setUtilisateurId(savedUtilisateur.getId());
        response.setNomUtilisateur(savedUtilisateur.getNomUtilisateur());
        response.setRole(String.valueOf(savedUtilisateur.getRole()));
        return response;
    }

    @Override
    public UtilisateurResponse getUtilisateurById(UtilisateurRequest request) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(request.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        UtilisateurResponse response = new UtilisateurResponse();
        response.setUtilisateurId(utilisateur.getId());
        response.setNomUtilisateur(utilisateur.getNomUtilisateur());
        response.setRole(String.valueOf(utilisateur.getRole()));
        return response;
    }

    @Override
    public UtilisateurResponse updateUtilisateur(UtilisateurRequest request) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(request.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        utilisateur.setNomUtilisateur(request.getNomUtilisateur());
        utilisateur.setMotDePasse(request.getMotDePasse());
        utilisateur.setRole(request.getRole());

        Utilisateur updatedUtilisateur = utilisateurService.createUtilisateur(utilisateur);

        UtilisateurResponse response = new UtilisateurResponse();
        response.setUtilisateurId(updatedUtilisateur.getId());
        response.setNomUtilisateur(updatedUtilisateur.getNomUtilisateur());
        response.setRole(String.valueOf(updatedUtilisateur.getRole()));
        return response;
    }

    @Override
    public UtilisateurResponse deleteUtilisateur(UtilisateurRequest request) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(request.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        utilisateurService.deleteUtilisateur(utilisateur.getId());

        UtilisateurResponse response = new UtilisateurResponse();
        response.setUtilisateurId(utilisateur.getId());
        return response;
    }
}
