package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Menu {

    private double id;
    private String name;
    private List<Item> items;

    public Menu() { }

    public Menu(double id, String name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }


    @JsonProperty
    public List<Item> getItems() {
        return this.items;
    }

    @JsonProperty
    public void setItems(List<Item> items){
        this.items = items;
    }

    @JsonProperty
    public double getId() {

        return this.id;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    @JsonProperty
    public void setId(final double id) {
        this.id = id;
    }

    @JsonProperty
    public void setName(final String name) {
        this.name = name;
    }



}
