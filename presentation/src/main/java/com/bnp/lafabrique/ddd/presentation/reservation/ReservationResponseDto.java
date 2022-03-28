package com.bnp.lafabrique.ddd.presentation.reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationResponseDto {

    private final String nomDeSalle;
    private final LocalDate date;
    private final LocalTime hDebut;
    private final LocalTime hFin;

    public ReservationResponseDto(String nomDeSalle, LocalDate date, LocalTime hDebut, LocalTime hFin) {
        this.nomDeSalle = nomDeSalle;
        this.date = date;
        this.hDebut = hDebut;
        this.hFin = hFin;
    }

    public String getNomDeSalle() {
        return nomDeSalle;
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
