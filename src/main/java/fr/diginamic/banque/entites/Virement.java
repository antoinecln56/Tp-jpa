package fr.diginamic.banque.entites;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
@DiscriminatorValue("V")
public class Virement extends Operation {

    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, Double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {

        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {

        this.beneficiaire = beneficiaire;
    }

}
