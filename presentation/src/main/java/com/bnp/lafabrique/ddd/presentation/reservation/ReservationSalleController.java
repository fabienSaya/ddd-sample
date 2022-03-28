package com.bnp.lafabrique.ddd.presentation.reservation;

import com.bnp.lafabrique.ddd.application.ReserverSalle;
import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationSalleController {

    private ReserverSalle reserverSalle;

    @PostMapping(value = "/reserver-salle", consumes = "application/json")
    public void reserverSalle(@RequestBody ReservationRequestDto reservationRequestDto){
        //comme on a besoin de plusieurs parametre, on fait un DTO qui contiendra tout

        CreneauHorraireVO creneauHorraireVO= Mapper.mapDTOtoVO(reservationRequestDto);
        reserverSalle.reserver(reservationRequestDto.getNbPersonne(),creneauHorraireVO);
    }
}
