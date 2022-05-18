package fr.diginamic.banque.dao.impl;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entites.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao extends Dao implements Idao<Client> {


    public ClientDao(FactoryDao fd) {
        super(fd);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean add(Client e) throws Exception {
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
    public boolean update(Client e) throws Exception {
        EntityManager em = null;
        try {
            em = fd.getEm();
            em.getTransaction().begin();
            Client etrans = em.find(Client.class, e.getId());
            if (etrans != null) {
                etrans.setAdresse(e.getAdresse());
                etrans.setBanque(e.getBanque());
                etrans.setComptes(e.getComptes());
                etrans.setDateNaissance(e.getDateNaissance());
                etrans.setNom(e.getNom());
                etrans.setPrenom(e.getPrenom());
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
    public boolean delete(Client e) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Client getOne(Client e) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Client> getAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
