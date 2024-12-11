package ma.project.gestionreservations.soap.entities;

import jakarta.validation.constraints.NotNull;
import ma.project.gestionreservations.restApi.models.Chambre;
import ma.project.gestionreservations.restApi.models.Client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Map;

@XmlRootElement
public class ReservationRequest {

    private Long reservationId;
    private Client client;
    private Chambre chambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Map<String, String> preferences;

    @XmlElement
    @NotNull(message = "Le client est obligatoire")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlElement
    @NotNull(message = "La chambre est obligatoire")
    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @XmlElement
    @NotNull(message = "La date de début est obligatoire")
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    @XmlElement
    @NotNull(message = "La date de fin est obligatoire")
    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @XmlElement
    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }

    // Getter and Setter for reservationId
    @XmlElement
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
