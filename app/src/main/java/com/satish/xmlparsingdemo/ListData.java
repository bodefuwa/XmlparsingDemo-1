package com.satish.xmlparsingdemo;

/**
 * Created by satish on 30/6/15.
 */
public class ListData {
    String name,description,id,cost;
    public ListData(){}

    public ListData(String description, String name, String id, String cost) {
        this.description = description;
        this.name = name;
        this.id = id;
        this.cost = cost;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
