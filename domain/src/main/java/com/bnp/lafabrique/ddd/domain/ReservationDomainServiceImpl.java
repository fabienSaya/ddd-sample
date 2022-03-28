package com.bnp.lafabrique.ddd.domain;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Domain Service de reservation de salle
 */

public class ReservationDomainServiceImpl implements ReservationDomainService {

    //on utilise l'interface du domaine et non l'implementation de infrastructure pour éviter la dependance vers
    // la couche infra car odomaine ne doit pas avoir de dependance vers autres couches. Du coup on fait une inversion de dependance.

    private ClientREFIM clientREFIM;
    private ReservationRepository reservationRepository;

    public ReservationDomainServiceImpl(ClientREFIM clientREFIM, ReservationRepository reservationRepository) {
        this.clientREFIM = clientREFIM;
        this.reservationRepository = reservationRepository;
    }

    public ReservationDomainServiceImpl(ReservationRepository reservationRepository, ClientREFIM clientREFIM) {
        this.clientREFIM = clientREFIM;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<SalleVO> findSalleReservable(Integer nbPersonne, CreneauHorraireVO creneauHorraireVOSouhaite) {
        return clientREFIM.findSallesByCapacite(nbPersonne)
                .filter(salle->reservationPossible(salle,creneauHorraireVOSouhaite))
                .findFirst();//il ne va pas appliqué le filtre à tous les éléments, ils s'arretera au premier trouvé qui match le filtre
    }

    private boolean reservationPossible(SalleVO salle, CreneauHorraireVO creneauHorraireVOSouhaite) {
        return reservationRepository
                .findReservations(salle,creneauHorraireVOSouhaite.getDate())
                .map(ReservationEntity::getCreneauHorraire)
                .noneMatch(creneauDisponible -> creneauHorraireVOSouhaite.chevauche(creneauDisponible));
    }

}
