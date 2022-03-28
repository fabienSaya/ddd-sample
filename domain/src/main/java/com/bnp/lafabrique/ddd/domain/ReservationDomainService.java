package com.bnp.lafabrique.ddd.domain;

import java.util.Optional;

public interface ReservationDomainService {
    Optional<SalleVO> findSalleReservable(Integer nbPersonne, CreneauHorraireVO creneauHorraireVOSouhaite);

}
