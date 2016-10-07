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
@Builder
@Entity
@Table(name = "row")
public class Row implements Serializable{

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private byte[] id;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToMany(mappedBy = "rows", cascade = CascadeType.ALL)
    private List<File> files;
}
