package com.bnp.lafabrique.ddd.presentation.reservation;

import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;

public final class Mapper {

    public static CreneauHorraireVO mapDTOtoVO(ReservationRequestDto dto) {
        return new CreneauHorraireVO(dto.getDate(),dto.gethDebut(),dto.gethFin());
    }

    public static ReservationResponseDto mapReservationEntityToReservationResponseDTO(ReservationEntity reservationEntity) {
        return new ReservationResponseDto(
                reservationEntity.getSalle().getName()
                , reservationEntity.getCreneauHorraire().getDate()
                , reservationEntity.getCreneauHorraire().gethDebut()
                , reservationEntity.getCreneauHorraire().gethFin());
    }
}
