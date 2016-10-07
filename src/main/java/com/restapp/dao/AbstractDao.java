package com.restapp.dao;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tadasyan
 */

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AbstractDao<T extends Serializable> implements Serializable {

    private final Class<T> clazz;

    @Inject
    private EntityManager em;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T find(Object id) {
        return em.find(clazz, id);
    }

    public void remove(T entity) {
        em.remove(em.merge(entity));
        em.flush();
    }

    public T edit(T entity) {
        T t = em.merge(entity);
        em.flush();
        return t;
    }

    public void persist(final T entity) {
        em.persist(entity);
    }

    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(clazz);
        criteriaQuery.select(criteriaQuery.from(clazz));
        return em.createQuery(criteriaQuery).getResultList();
    }

    public EntityManager getEm(){
        return em;
    }

}
