package com.restapp.DAO;

import com.restapp.model.Data;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by tadasyan.
 */
public interface DataDAO {

    void saveData(Data data);

    List<Data> getData();
}
