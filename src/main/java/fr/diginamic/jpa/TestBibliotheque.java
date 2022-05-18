package fr.diginamic.jpa;

import fr.diginamic.jpa.entities.Client;
import fr.diginamic.jpa.entities.Emprunt;
import fr.diginamic.jpa.entities.Livre;

import javax.persistence.*;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {

        EntityManagerFactory efm =null;
        try {
            efm = Persistence.createEntityManagerFactory("bddBibli");
            EntityManager em = efm.createEntityManager();
            em.getTransaction().begin();

            // Requete pour extraire un emprunt et tous ses livres

            Emprunt emprunt1 = em.find(Emprunt.class, 3);
            System.out.println(emprunt1.getLivres());


            // Requete tous les emprunts d'un client

            Client client1 = em.find(Client.class, 3);
            System.out.println(client1.getEmprunts());

            em.close();
            efm.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
