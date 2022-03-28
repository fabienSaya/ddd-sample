package com.bnp.lafabrique.ddd.presentation.reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDto {

    private final Integer nbPersonne;
    private final LocalDate date;
    private final LocalTime hDebut;
    private final LocalTime hFin;


    public ReservationRequestDto(Integer nbPersonnes, LocalDate date, LocalTime hDebut, LocalTime hFin) {
        this.nbPersonne = nbPersonnes;
        this.date = date;
        this.hDebut = hDebut;
        this.hFin = hFin;
    }

    public Integer getNbPersonne() {
        return nbPersonne;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime gethDebut() {
        return hDebut;
    }

    public LocalTime gethFin() {
        return hFin;
    }
}
