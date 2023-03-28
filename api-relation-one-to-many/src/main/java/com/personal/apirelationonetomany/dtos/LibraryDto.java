package com.personal.apirelationonetomany.dtos;

public class LibraryDto {
    private String name;

    public LibraryDto() {
    }

    public LibraryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
