package fr.diginamic.banque.dao.impl;

public abstract class Dao {

    protected final FactoryDao fd;

    public Dao(FactoryDao fd) {
        this.fd = fd;
    }
}
