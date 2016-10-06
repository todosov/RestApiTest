package com.restapp.services;

import com.restapp.dao.DataDAO;
import com.restapp.entity.Data;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by tadasyan
 */

@Stateless
public class DataService {

    @Inject
    private DataDAO dataDAO;

    public List<Data> getAllData(){
        return dataDAO.findAll();
    }
}
