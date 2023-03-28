package com.personal.apirelationonetomany.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libro", uniqueConstraints = { @UniqueConstraint(columnNames = {"nombre"}) })
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "biblioteca_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // avoid mistake by LAZY, ignore return library
    private LibraryModel library;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LibraryModel getLibrary() {
        return library;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }
}
