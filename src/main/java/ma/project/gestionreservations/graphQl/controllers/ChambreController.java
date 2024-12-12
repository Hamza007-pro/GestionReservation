package ma.project.gestionreservations.graphQl.controllers;

import ma.project.gestionreservations.restApi.models.Chambre;
import ma.project.gestionreservations.restApi.services.ChambreService;
import ma.project.gestionreservations.soap.entities.ChambreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @QueryMapping
    public List<Chambre> allChambres() {
        return chambreService.getAllChambres();
    }

    @QueryMapping
    public Chambre chambreById(@Argument Long id) {
        return chambreService.getChambreById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + id));
    }

    @MutationMapping
    public Chambre saveChambre(
            @Argument String type,
            @Argument Double prix,
            @Argument Boolean disponible
    ) {
        Chambre chambre = new Chambre();
        chambre.setType(type);
        chambre.setPrix(BigDecimal.valueOf(prix));
        chambre.setDisponible(disponible);
        return chambreService.createChambre(chambre);
    }

    @MutationMapping
    public String deleteChambreById(@Argument Long id) {
        chambreService.deleteChambre(id);
        return "Chambre with ID " + id + " was successfully deleted.";
    }

    @MutationMapping
    public Chambre updateChambre(
            @Argument Long id,
            @Argument String type,
            @Argument Double prix,
            @Argument Boolean disponible
    ) {
        Chambre existingChambre = chambreService.getChambreById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + id));
        existingChambre.setType(type);
        existingChambre.setPrix(BigDecimal.valueOf(prix));
        existingChambre.setDisponible(disponible);
        return chambreService.updateChambre(id, existingChambre)
                .orElseThrow(() -> new RuntimeException("Failed to update chambre with ID: " + id));
    }
}
