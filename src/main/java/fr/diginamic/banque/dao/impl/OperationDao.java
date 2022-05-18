package fr.diginamic.banque.dao.impl;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entites.Operation;

import javax.persistence.EntityManager;
import java.util.List;

public class OperationDao extends Dao implements Idao<Operation> {

    public OperationDao(FactoryDao fd) {
        super(fd);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean add(Operation e) throws Exception {
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
    public boolean update(Operation e) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Operation e) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Operation getOne(Operation e) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Operation> getAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
