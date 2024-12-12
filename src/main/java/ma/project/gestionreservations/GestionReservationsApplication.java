package ma.project.gestionreservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "ma.project.gestionreservations",
		excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "ma.project.gestionreservations.graphQl.controllers.*"))
public class GestionReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReservationsApplication.class, args);
	}

}
