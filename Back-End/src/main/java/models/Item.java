package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private String person;
    private Integer quantity;
    private Integer price;
    private String name;

    //  public Item() { }

    public Item(String person, String name, int quantity, int price) {

        this.name = name;
        this.person = person;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonProperty
    public String getPerson() {
        return this.person;
    }

    @JsonProperty
    public Integer getQuantity(){
        return this.quantity;
    }

    @JsonProperty
    public Integer getPrice(){
        return this.price;
    }

    @JsonProperty
    public String getName(){
        return this.name;
    }
}
