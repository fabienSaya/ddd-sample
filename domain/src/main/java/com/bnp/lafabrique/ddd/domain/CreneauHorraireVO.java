package com.bnp.lafabrique.ddd.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class CreneauHorraireVO {
    private final LocalDate date;
    private final LocalTime hDebut;
    private final LocalTime hFin;

    public CreneauHorraireVO(LocalDate date, LocalTime hDebut, LocalTime hFin) {
        //on devrait checher ici la coherence hDebut<hFin

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
}
