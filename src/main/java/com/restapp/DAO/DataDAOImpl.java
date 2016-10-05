package com.restapp.DAO;

import com.restapp.model.Data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by tadasyan.
 */
@Stateless
public class DataDAOImpl implements DataDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveData(Data data) {
        entityManager.persist(entityManager);
    }

    @Override
    public List<Data> getData() {
        return entityManager.createNamedQuery("findAll", Data.class).getResultList();
    }
}
