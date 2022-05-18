package fr.diginamic.jpa.entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt {

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="DATE_DEBUT")
    private LocalTime dateDebut;

    @Column(name="DATE_FIN")
    private LocalTime dateFin;

    @Column(name="DELAI")
    private Integer delai;


    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalTime dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Set<Livre> getLivres() {
        return livres;
    }
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
