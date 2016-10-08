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
@Table(name = "row")
public class Row implements Serializable{

    public Row() {
    }

    @Builder
    public Row(byte[] id, String content, List<File> files){
        this.id = id;
        this.content = content;
        this.files = files;
    }

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private byte[] id;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToMany(mappedBy = "rows", cascade = CascadeType.MERGE)
    private List<File> files;
}
