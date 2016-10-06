package com.restapp.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by tadasyan.
 */

@Getter
@Setter
@Entity
@Table(name = "data")
public class Data implements Serializable {

    @Id
    private String lineText;

    private int count;

    public Data(){

    }
}
