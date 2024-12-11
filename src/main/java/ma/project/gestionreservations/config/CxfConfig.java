package ma.project.gestionreservations.config;

import ma.project.gestionreservations.soap.endpoints.ChambreSoapServiceImpl;
import ma.project.gestionreservations.soap.endpoints.ReservationSoapServiceImpl;
import ma.project.gestionreservations.soap.endpoints.ClientSoapServiceImpl;
import ma.project.gestionreservations.soap.endpoints.UtilisateurSoapServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final ChambreSoapServiceImpl chambreSoapService;
    private final ReservationSoapServiceImpl reservationSoapService;
    private final ClientSoapServiceImpl clientSoapService;
    private final UtilisateurSoapServiceImpl utilisateurSoapService;

    // Constructor injection for all services
    public CxfConfig(Bus bus, ChambreSoapServiceImpl chambreSoapService, ReservationSoapServiceImpl reservationSoapService,
                     ClientSoapServiceImpl clientSoapService, UtilisateurSoapServiceImpl utilisateurSoapService) {
        this.bus = bus;
        this.chambreSoapService = chambreSoapService;
        this.reservationSoapService = reservationSoapService;
        this.clientSoapService = clientSoapService;
        this.utilisateurSoapService = utilisateurSoapService;
    }

    // Expose Chambre SOAP endpoint
    @Bean
    public EndpointImpl chambreEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, chambreSoapService);
        endpoint.publish("/chambre");
        return endpoint;
    }

    // Expose Reservation SOAP endpoint
    @Bean
    public EndpointImpl reservationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoapService);
        endpoint.publish("/reservation");
        return endpoint;
    }

    // Expose Client SOAP endpoint
    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientSoapService);
        endpoint.publish("/client");
        return endpoint;
    }

    // Expose Utilisateur SOAP endpoint
    @Bean
    public EndpointImpl utilisateurEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, utilisateurSoapService);
        endpoint.publish("/utilisateur");
        return endpoint;
    }
}
