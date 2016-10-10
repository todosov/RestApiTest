package com.restapp.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tadasyan
 */

@Getter
@Setter
@Entity
@Table(name = "file")
public class File implements Serializable {

    @Builder
    public File(int id, String name, List<Row> rows) {
        this.id = id;
        this.name =name;
        this.rows = rows;
    }

    public File(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "file_row",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "row_id"))
    private List<Row> rows;
}
