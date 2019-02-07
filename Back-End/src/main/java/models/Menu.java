package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu {

    private Integer id;
    private String name;

    public Menu() { }

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public Integer getId() {
        return this.id;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }
}
