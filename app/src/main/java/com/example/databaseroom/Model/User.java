package com.example.databaseroom.Model;

import androidx.annotation.NonNull;

public class User {
    private long id;
    private String name;
    private int year;

    public User(long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.year;
    }
}
