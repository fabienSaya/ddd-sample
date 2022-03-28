package com.bnp.lafabrique.ddd.presentation.reservation;

import com.bnp.lafabrique.ddd.application.ReserverSalleApplicationService;
import com.bnp.lafabrique.ddd.application.ReserverSalleApplicationServiceImpl;
import com.bnp.lafabrique.ddd.domain.CreneauHorraireVO;
import com.bnp.lafabrique.ddd.domain.ReservationEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReservationSalleController {


    @Autowired
    private ReserverSalleApplicationService reserverSalle;

    @ApiOperation(value="Reserver une salle",nickname="reserverSalle",
        notes="Reserver une salle pour une date donnée"
        , tags={"reserver-salle-controller"}    ) //info pour le swagger
    @ApiResponses(value={
            @ApiResponse(code=200,message = "OK")
            , @ApiResponse(code=401,message = "Non authorisé")
            , @ApiResponse(code=410,message = "Client non disponible")
            , @ApiResponse(code=404,message = "Salle déjà réservée dans ce creneau")
    })
    @PostMapping(value = "/reserver-salle", consumes = "application/json")
    public ResponseEntity<ReservationResponseDto> reserverSalle(@ApiParam(value="un ReservationRequestDto") @RequestBody ReservationRequestDto reservationRequestDto){
        //comme on a besoin de plusieurs parametre, on fait un DTO qui contiendra tout

        CreneauHorraireVO creneauHorraireVO= Mapper.mapDTOtoVO(reservationRequestDto);
        Optional<ReservationEntity> reservationEntityOptional= reserverSalle.reserver(reservationRequestDto.getNbPersonne(),creneauHorraireVO);

        if (reservationEntityOptional.isPresent()) {
            ReservationResponseDto dto= Mapper.mapReservationEntityToReservationResponseDTO(reservationEntityOptional.get());
            return new ResponseEntity(dto, HttpStatus.OK);
        } else {
            //erreur 404
            return new ResponseEntity("Pas de salle disponible pour le créneau demandé",HttpStatus.NOT_FOUND);
        }

    }
}
