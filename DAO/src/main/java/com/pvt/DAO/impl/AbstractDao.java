package com.pvt.DAO.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao {

    private static EntityManager curentEm = null;
    private static EntityManagerFactory emFactory = null;

    /*методы для вызова и закрытия emFactry*/
    public static EntityManager getEntityManager(String unit) {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory(unit);
        }
        return emFactory.createEntityManager();
    }

    public static void closeEMFactory() {
        emFactory.close();
    }


    /*методы для вызова и закрытия EM*/
    public EntityManager openEm() {
        curentEm = getEntityManager("lib-validate");
        return curentEm;
    }

    public void closeEm() {
        getEm().close();
    }

    public EntityManager openEmTransact() {
        curentEm = getEntityManager("lib-update");
        curentEm.getTransaction().begin();
        return curentEm;
    }

    public void closeEmTransact() {
        getEm().getTransaction().commit();
        getEm().close();
    }

    public EntityManager getEm() {
        return curentEm;
    }

}
