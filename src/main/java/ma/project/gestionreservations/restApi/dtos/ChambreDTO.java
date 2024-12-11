package ma.project.gestionreservations.restApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChambreDTO {
    private Long id;
    private String type;
    private BigDecimal prix;
    private boolean disponible;
}