package com.restapp.dao;

import com.restapp.entity.File;
import com.restapp.entity.Row;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
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
        Root<File> root = criteriaQuery.from(File.class);
        EntityType<File> File_ = root.getModel();
        Join<File, ?> join = root.join(File_.getList("rows"));
        criteriaQuery.multiselect(join.get("content"), getEm().getCriteriaBuilder().count(root.get("id")))
                .groupBy(join.get("content"));

        return getEm().createQuery(criteriaQuery).getResultList();
    }
}
