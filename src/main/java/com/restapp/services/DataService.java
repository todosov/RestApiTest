package com.restapp.services;

import com.restapp.dao.FileDAO;
import com.restapp.dao.RowDAO;
import com.restapp.entity.File;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tadasyan
 */

@Stateless
public class DataService {

    @Inject
    private FileDAO fileDAO;

    @Inject
    private RowDAO rowDAO;

    public List<StringCount> getStringCounts(){
        List<StringCount> result = new LinkedList<>();
        rowDAO.findRowsGroupByString().stream().forEach(objects -> {
            result.add(StringCount.builder().string((String)objects[0]).count((Long)objects[1]).build());
        });
        return result;
    }

    public void addFile(File file){
        fileDAO.edit(file);
    }
}
