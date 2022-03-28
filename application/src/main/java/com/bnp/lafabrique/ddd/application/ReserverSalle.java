package com.bnp.lafabrique.ddd.application;

import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import com.bnp.lafabrique.ddd.domain.ReservationRepository;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;
import com.bnp.lafabrique.ddd.domain.ReservationService;

/**
 * Application Service de réservation de salle
 */
public class ReserverSalle {

    //domain service
    private ReservationService reservationService;
    //DAO interface
    private ReservationRepository reservationRepository;

    public void reserver(Integer nbPersonne, CreneauHorraireVO creneauHorraire){
        //Appel le Domaine Service de reservation
        reservationService.findSalleReservable(nbPersonne,creneauHorraire)
                .ifPresent(salleReservable-> reservationRepository.saveReservation(new ReservationEntity(salleReservable,creneauHorraire)));

    }
}
