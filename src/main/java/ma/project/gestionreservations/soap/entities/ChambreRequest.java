package ma.project.gestionreservations.soap.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
public class ChambreRequest {
    private Long chambreId;
    private String type;
    private BigDecimal prix;
    private boolean disponible;


    @XmlElement
    public Long getChambreId() {
        return chambreId;
    }

    public void setChambreId(Long chambreId) {
        this.chambreId = chambreId;
    }
    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public @NotNull(message = "Le prix est obligatoire") @Positive(message = "Le prix doit être positif") BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @XmlElement
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
