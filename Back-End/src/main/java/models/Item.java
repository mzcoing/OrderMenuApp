package models;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Item {

    private String person;
    private String name;
    private Integer quantity;
    private Integer price;
    
    public Item(){}

     public Item(String name, int price) {

        this.person = "";
        this.quantity = 0;
        this.name = name;
        this.price = price;
      }

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
    public String getName(){
        return this.name;
    }

    @JsonProperty
    public Integer getQuantity(){
        return this.quantity;
    }

    @JsonProperty
    public Integer getPrice(){
        return this.price;
    }

}
