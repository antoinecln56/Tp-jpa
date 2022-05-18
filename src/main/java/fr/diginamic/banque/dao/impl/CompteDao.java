package fr.diginamic.banque.dao.impl;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.Client;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.Operation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompteDao extends Dao implements Idao<Compte> {

    public CompteDao(FactoryDao fd) {
        super(fd);
    }

    @Override
    public boolean add(Compte e) throws Exception {
        EntityManager em = null;
        try {
            em = fd.getEm();
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            fd.close(em);
        }
    }

    @Override
    public boolean update(Compte e) throws Exception {
        EntityManager em = null;
        try {
            em = fd.getEm();
            em.getTransaction().begin();
            Compte etrans = em.find(Compte.class, e.getId());
            if (etrans != null) {
                etrans.setNumero(e.getNumero());
                etrans.setSolde(e.getSolde());
                em.merge(etrans);
                em.getTransaction().commit();
                return true;
            }
            return false;

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            fd.close(em);
        }
    }

    @Override
    public boolean delete(Compte e) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Compte getOne(Compte e) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Compte> getAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Client> getClients(Compte co) throws Exception {
        TypedQuery<Client> tqb = fd.getEm().createNamedQuery("Compte.getClients", Client.class);
        tqb.setParameter("compte", co);
        return tqb.getResultList();
    }

    public List<Operation> getOperations(Compte co) throws Exception {
        TypedQuery<Operation> tqb = fd.getEm().createNamedQuery("Compte.getOperations", Operation.class);
        tqb.setParameter("id", co.getId());
        return tqb.getResultList();
    }
}
