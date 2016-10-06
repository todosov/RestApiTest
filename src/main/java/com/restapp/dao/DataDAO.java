package com.restapp.dao;

import com.restapp.entity.Data;

import javax.ejb.Stateless;

/**
 * Created by tadasyan
 */

@Stateless
public class DataDAO extends AbstractDao<Data> {

    public DataDAO(){
        super(Data.class);
    }
}
