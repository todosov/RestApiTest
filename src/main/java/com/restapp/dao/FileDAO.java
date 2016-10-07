package com.restapp.dao;

import com.restapp.entity.File;

import javax.ejb.Stateless;

/**
 * Created by tadasyan
 */
@Stateless
public class FileDAO extends AbstractDao<File> {

    public FileDAO() {
        super(File.class);
    }
}
