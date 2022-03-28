package com.bnp.lafabrique.ddd.application;

import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;
import java.util.Optional;

public interface ReserverSalleApplicationService {
    Optional<ReservationEntity> reserver(Integer nbPersonne, CreneauHorraireVO creneauHorraire);
}
