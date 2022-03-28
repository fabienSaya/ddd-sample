package com.bnp.lafabrique.ddd.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CreneauHorraireVOUTest {

    @Test
    public void shouldCreateValidCreneauHorraireVO() {
        LocalDate date = LocalDate.parse("2022-12-12");
        LocalTime hDebut=LocalTime.of(15,30);
        LocalTime hFin=LocalTime.of(17,00);
        CreneauHorraireVO creneauHorraireVO=new CreneauHorraireVO(date,hDebut,hFin);

        Assertions.assertNotNull(creneauHorraireVO);
    }

}