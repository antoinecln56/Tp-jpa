package fr.diginamic.jpa;


import fr.diginamic.jpa.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestJpa {

    public static void main(String[] args) {

        EntityManagerFactory efm =null;
        try {
            efm = Persistence.createEntityManagerFactory("bddBibli");

            /** Je passe par efm pour obtenir mes EM (EntityManager) */
            EntityManager em = efm.createEntityManager();
            em.getTransaction().begin();


            Livre li = em.find(Livre.class, 2);
            System.out.println("Titre : " + li.getTitre() + " Auteur : " + li.getAuteur());

            /**
             * Insert
             */
            Livre newLivre = new Livre();
            newLivre.setId(6);
            newLivre.setTitre("One Piece");
            newLivre.setAuteur("Eiichiro Oda");
            em.persist(newLivre);
            em.getTransaction().commit();
            System.out.println("ID AUTOINCR : " + newLivre.getId());

            /**
             * Update
             */
            em.getTransaction().begin();
            Livre updateBook = em.find(Livre.class, 5) ;
            if(updateBook != null) {
                updateBook.setTitre("Du plaisir dans la cuisine");
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }

            /**
             * Request JPQL title
             */

            TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Guerre et paix' ", Livre.class);
            List<Livre> bookResult = query.getResultList();
            for (Livre book : bookResult) {
                System.out.println(book.getAuteur());
                System.out.println(book.getTitre());
            }

            /**
             * Request JPQL autor
             */
            TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='Eiichiro Oda' ", Livre.class);
            List<Livre> bookResult1 = query2.getResultList();
            for (Livre book1 : bookResult1) {
                System.out.println(book1.getAuteur());
                System.out.println(book1.getTitre());
            }

            /**
             * Delete book
             */

            em.getTransaction().begin();
            Livre bookDelete= em.find(Livre.class, 4);
            em.remove(bookDelete);
            em.getTransaction().commit();

            /**
             * Request JPQL all book
             */

            TypedQuery<Livre> query3 = em.createQuery("select l from Livre l", Livre.class);
            List<Livre> allBook = query3.getResultList();
            for (Livre book2 : allBook) {
                System.out.println("Titre : " + book2.getTitre() + " ---- " + "Auteur : " + book2.getAuteur());
            }

            em.close();
            efm.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
