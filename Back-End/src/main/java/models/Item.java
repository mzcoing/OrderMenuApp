package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private Integer id;
    private String person;
    private String menuitem;
    private Integer quantity;
    private Integer price;

    public Item() { }

    public Item(Integer id, String person, String menuitem, int quantity, int price) {
        this.id = id;
        this.person = person;
        this.menuitem = menuitem;
        this.quantity = quantity;
        this.price = price;
    }

    @JsonProperty
    public Integer getId(){
        return this.id;
    }
    @JsonProperty
    public String getPerson() {
        return this.person;
    }

    @JsonProperty
    public String getMenuitem() {
        return this.menuitem;
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
