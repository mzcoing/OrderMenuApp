package models;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Item {

    private String person;
    private String name;
    private double quantity;
    private double price;

    public Item(){}

     public Item(String name, double price) {

        this.person = "";
        this.quantity = 0;
        this.name = name;
        this.price = price;
      }

    public Item(String person, String name, double quantity, double price) {

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
    public String getName(){
        return this.name;
    }

    @JsonProperty
    public double getQuantity(){
        return this.quantity;
    }

    @JsonProperty
    public double getPrice(){
        return this.price;
    }

}
