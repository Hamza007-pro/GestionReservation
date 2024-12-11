package ma.project.gestionreservations.restApi.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long clientId;
    private Long chambreId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Map<String, String> preferences;
}
