package ma.project.gestionreservations.graphQl.controllers;

import ma.project.gestionreservations.restApi.models.Role;
import ma.project.gestionreservations.restApi.models.Utilisateur;
import ma.project.gestionreservations.restApi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @QueryMapping
    public List<Utilisateur> allUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @QueryMapping
    public Utilisateur utilisateurById(@Argument Long id) {
        return utilisateurService.getUtilisateurById(id).orElse(null);
    }

    @MutationMapping
    public Utilisateur saveUtilisateur(
            @Argument String nomUtilisateur,
            @Argument String motDePasse,
            @Argument String role
    ) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur(nomUtilisateur);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setRole(Role.valueOf(role));
        return utilisateurService.createUtilisateur(utilisateur);
    }

    @MutationMapping
    public Optional<Utilisateur> updateUtilisateur(
            @Argument Long id,
            @Argument String nomUtilisateur,
            @Argument String motDePasse,
            @Argument String role
    ) {
        Utilisateur existingUtilisateur = utilisateurService.getUtilisateurById(id).orElse(null);
        if (existingUtilisateur != null) {
            existingUtilisateur.setNomUtilisateur(nomUtilisateur);
            existingUtilisateur.setMotDePasse(motDePasse);
            existingUtilisateur.setRole(Role.valueOf(role));
            return utilisateurService.updateUtilisateur(id,existingUtilisateur);
        }
        return null;
    }

    @MutationMapping
    public String deleteUtilisateurById(@Argument Long id) {
        utilisateurService.deleteUtilisateur(id);
        return "Utilisateur deleted successfully";
    }
}
