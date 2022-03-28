package com.bnp.lafabrique.ddd.application;

import com.bnp.lafabrique.ddd.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Application Service de réservation de salle
 */
@Service
@Transactional
public class ReserverSalleApplicationServiceImpl implements ReserverSalleApplicationService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

   //domain service
    private ReservationDomainService reservationService;
    //DAO interface
    private ReservationRepository reservationRepository;

    public ReserverSalleApplicationServiceImpl(ReservationDomainService reservationService, ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<ReservationEntity> reserver(Integer nbPersonne, CreneauHorraireVO creneauHorraire){
        //Appel le Domaine Service de reservation
        Optional<SalleVO> salleReservable= reservationService.findSalleReservable(nbPersonne,creneauHorraire);
        if (salleReservable.isPresent())
            return Optional.ofNullable(reservationRepository.saveReservation(new ReservationEntity(salleReservable.get(), creneauHorraire)));
        else
            return Optional.empty();
    }
}
