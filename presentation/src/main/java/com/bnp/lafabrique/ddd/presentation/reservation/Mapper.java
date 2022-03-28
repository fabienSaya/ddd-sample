package com.bnp.lafabrique.ddd.presentation.reservation;

import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;

public final class Mapper {

    public static CreneauHorraireVO mapDTOtoVO(ReservationRequestDto dto) {
        return new CreneauHorraireVO(dto.getDate(),dto.gethDebut(),dto.gethFin());
    }
}
