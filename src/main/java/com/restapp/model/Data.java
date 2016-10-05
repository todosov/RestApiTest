package com.restapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by tadasyan.
 */

@Entity
@NamedQuery(
        name = "findAll",
        query = "select d from Data d"
)
public class Data {

    @Id
    private String lineText;

    @Column
    private int count;
}
