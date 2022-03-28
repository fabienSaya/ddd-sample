package com.bnp.lafabrique.ddd.infrastructure;

import com.bnp.lafabrique.ddd.domain.ReservationRepository;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;
import com.bnp.lafabrique.ddd.domain.SalleVO;

import java.time.LocalDate;
import java.util.stream.Stream;

public class ReservationRepositoryInMemory implements ReservationRepository {
    @Override
    public Stream<ReservationEntity> findReservations(SalleVO salle, LocalDate date) {
        return null;
    }

    @Override
    public void saveReservation(ReservationEntity reservationEntity) {

    }
}
