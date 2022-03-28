package com.bnp.lafabrique.ddd.infrastructure;

import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import com.bnp.lafabrique.ddd.domain.ReservationRepository;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;
import com.bnp.lafabrique.ddd.domain.SalleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReservationRepositoryInMemory implements ReservationRepository {

    private Logger log=LoggerFactory.getLogger(this.getClass());

    private static List<ReservationEntity>  reservationEntityList=  new ArrayList<>();

    static {
        reservationEntityList.add(new ReservationEntity(new SalleVO("Salle1"),
                new CreneauHorraireVO(LocalDate.now(),LocalTime.of(12,30),LocalTime.of(13,30))));
    }

    @Override
    public Stream<ReservationEntity> findReservations(SalleVO salle, LocalDate date) {
       log.info("findReservations - {} avec la date {} ",salle,date);

       return reservationEntityList.stream().filter(
               reservation -> reservation.getSalle().getName().equalsIgnoreCase(salle.getName())
            && reservation.getCreneauHorraire().getDate().isEqual(date)
        );
    }

    @Override
    public ReservationEntity saveReservation(ReservationEntity reservationEntity) {
        log.info("saveReservation - creneau horaire sauvé = {} ",reservationEntity);
        reservationEntityList.add(reservationEntity);
        return reservationEntity;
    }
}
