package fr.diginamic.banque.entites;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte {

    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {

    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }
}
