package com.family.tree.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Livestock")
public class Livestock {

    @Id
    private String id;

    private int cow;
    private int goat;
    private int sheep;
    private int hen;
    private int buffalo;

    public Livestock() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCow() {
        return cow;
    }

    public void setCow(int cow) {
        this.cow = cow;
    }

    public int getGoat() {
        return goat;
    }

    public void setGoat(int goat) {
        this.goat = goat;
    }

    public int getSheep() {
        return sheep;
    }

    public void setSheep(int sheep) {
        this.sheep = sheep;
    }

    public int getHen() {
        return hen;
    }

    public void setHen(int hen) {
        this.hen = hen;
    }

    public int getBuffalo() {
        return buffalo;
    }

    public void setBuffalo(int buffalo) {
        this.buffalo = buffalo;
    }
}
