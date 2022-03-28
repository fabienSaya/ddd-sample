package com.bnp.lafabrique.ddd.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class CreneauHorraireVO {
    private final LocalDate date;
    private final LocalTime hDebut;
    private final LocalTime hFin;

    public CreneauHorraireVO(LocalDate date, LocalTime hDebut, LocalTime hFin) {
        //on pourrait mettre ces controles dans une methode à part
        Objects.requireNonNull(date,"date must not be null");
        Objects.requireNonNull(hDebut,"hDebut must not be null");
        Objects.requireNonNull(hFin,"hFin must not be null");
        if (date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Object Creation Error: Date must be in future ");
        if (hDebut.isAfter(hFin)) throw new IllegalArgumentException("Object Creation Error: hDebut must be before hFin");

        this.date = date;
        this.hDebut = hDebut;
        this.hFin = hFin;
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


    public boolean chevauche(CreneauHorraireVO creneauHorraireVO) {
        return
                hFin.isAfter(creneauHorraireVO.gethDebut())
        && hDebut.isBefore(creneauHorraireVO.gethFin());
    }

    @Override
    public String toString() {
        return "CreneauHorraireVO{" +
                "date=" + date +
                ", hDebut=" + hDebut +
                ", hFin=" + hFin +
                '}';
    }
}
