package com.restapp.dao;

import com.restapp.entity.Row;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by tadasyan
 */

@Stateless
public class RowDAO extends AbstractDao<Row>{

    public RowDAO() {
        super(Row.class);
    }

    public List<Object[]> findRowsGroupByString(){
        CriteriaQuery criteriaQuery = getEm().getCriteriaBuilder().createQuery();
        Root<Row> root = criteriaQuery.from(Row.class);
        criteriaQuery.multiselect(root.get("string"), getEm().getCriteriaBuilder().count(root.get("string")))
                .groupBy(root.get("string"));

        return getEm().createQuery(criteriaQuery).getResultList();
    }
}
