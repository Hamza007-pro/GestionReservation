package ma.project.gestionreservations.soap.entities;

import jakarta.validation.constraints.NotNull;
import ma.project.gestionreservations.restApi.models.Role;  // Assuming Role is an enum

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UtilisateurRequest {

    private Long utilisateurId;
    private String nomUtilisateur;
    private String motDePasse;
    private Role role;

    @XmlElement
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    @XmlElement
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    @XmlElement
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @XmlElement
    @NotNull(message = "Le rôle est obligatoire")  // Apply validation on the Role field
    public Role getRole() {
        return role;
    }

    // Set the role from the Role enum
    public void setRole(Role role) {
        this.role = role;
    }
}
