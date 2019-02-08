package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private Integer id;
    private String name;

    public Order() { }

    public Order(Integer id, String name){
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
