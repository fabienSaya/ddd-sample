package com.bnp.lafabrique.ddd.domain;

public class ReservationEntity {

    private final SalleVO salle;
    private final CreneauHorraireVO creneauHorraire;

    public ReservationEntity(SalleVO salle, CreneauHorraireVO creneauHorraire) {
        this.salle = salle;
        this.creneauHorraire = creneauHorraire;
    }

    public SalleVO getSalle() {
        return salle;
    }

    public CreneauHorraireVO getCreneauHorraire() {
        return creneauHorraire;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "salle=" + salle +
                ", creneauHorraire=" + creneauHorraire +
                '}';
    }
}
