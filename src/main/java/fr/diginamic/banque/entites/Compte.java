package fr.diginamic.banque.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private double solde;

	@ManyToMany(mappedBy = "comptes")
	private Set<Client> clients = new HashSet<>();

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations = new HashSet<>();


    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<Client> getclient() {
		return clients;
	}

	public void setclient(Set<Client> clients) {
		this.clients = clients;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

}
