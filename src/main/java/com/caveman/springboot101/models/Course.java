package com.caveman.springboot101.models;

/**
 * Created by petro on 7/19/17.
 */
public class Course {

    private int Id;

    private String name;

    private String description;


    public Course() {
    }

    public Course(int id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
