package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Menu {

    private Integer id;
    private String name;
    private List<Item> items;

    public Menu() { }

    public Menu(int id, String name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }


    @JsonProperty
    public List<Item> getItems() {
        return this.items;
    }

    @JsonProperty
    public Integer getId() {

        return this.id;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    public void setId(final int id) {
        this.id = id;
    }




}
