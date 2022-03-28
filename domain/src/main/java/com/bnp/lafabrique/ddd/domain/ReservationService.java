package com.bnp.lafabrique.ddd.domain;

import java.util.Optional;

/**
 * Domain Service de reservation de salle
 */
public class ReservationService {

    //on utilise l'interface du domaine et non l'implementation de infrastructure pour éviter la dependance vers
    // la couche infra car odomaine ne doit pas avoir de dependance vers autres couches. Du coup on fait une inversion de dependance.
    private ReservationRepository reservationDAO;

    private IClientREFIM clientREFIM;

    public Optional<SalleVO> findSalleReservable(Integer nbPersonne, CreneauHorraireVO creneauHorraireVOSouhaite) {
        return clientREFIM.findSallesByCapacite(nbPersonne)
                .filter(salle->reservationPossible(salle,creneauHorraireVOSouhaite))
                .findFirst();//il ne va pas appliqué le filtre à tous les éléments, ils s'arretera au premier trouvé qui match le filtre
    }

    private boolean reservationPossible(SalleVO salle, CreneauHorraireVO creneauHorraireVOSouhaite) {
        return reservationDAO
                .findReservations(salle,creneauHorraireVOSouhaite.getDate())
                .map(ReservationEntity::getCreneauHorraire)
                .noneMatch(creauReserver -> creneauHorraireVOSouhaite.chevauche(creauReserver));
    }

}
