package com.bnp.lafabrique.ddd.infrastructure;

import com.bnp.lafabrique.ddd.domain.ClientREFIM;
import com.bnp.lafabrique.ddd.domain.ReservationDomainService;
import com.bnp.lafabrique.ddd.domain.ReservationDomainServiceImpl;
import com.bnp.lafabrique.ddd.domain.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfiguration {
    @Bean
    public ReservationRepository reservationRepository() {
        return new ReservationRepositoryInMemory();
    }

    @Bean
    public ClientREFIM clientREFIM() {
        return new ClientRefimImpl();
    }

    @Bean
    public ReservationDomainService reservationDomainService() {
        return new ReservationDomainServiceImpl(clientREFIM(), reservationRepository());
    }

}
