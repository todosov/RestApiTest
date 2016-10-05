package com.restapp.service;

import com.restapp.DAO.DataDAO;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by tadasyan.
 */

@Stateless
public class DataService {

    @Inject
    private DataDAO dataDAO;

    public void handleFile(InputPart inputPart) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        inputPart.getBody(InputStream.class, null)
                )
        );
    }


    private void saveData(Map<String, Integer> rows){

    }
}
