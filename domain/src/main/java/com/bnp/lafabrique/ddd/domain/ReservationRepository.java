package com.bnp.lafabrique.ddd.domain;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 *  on n'a pas le droit de faire une dependance de domaine vers infrastructure donc on crée juste une interface
 *
 */
public interface ReservationRepository {

    Stream<ReservationEntity> findReservations(SalleVO salle, LocalDate date);

    ReservationEntity saveReservation(ReservationEntity reservationEntity);

}
