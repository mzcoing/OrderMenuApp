package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Order {

    private Integer id;
    private String name;
    private Integer menuid;
    private List<Item> items;

    public Order() { }

    public Order(Integer id, String name, Integer menuid, List<Item> items){
        this.id = id;
        this.name = name;
        this.menuid = menuid;
        this.items = items;
    }

    @JsonProperty
    public Integer getId() {
        return this.id;
    }

    @JsonProperty
    public String getName() {
        return this.name;
    }

    @JsonProperty
    public Integer getMenuId() {
        return this.menuid;
    }

    @JsonProperty
    public List<Item> getItems() {
        return this.items;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name){
        this.name = name;
    }

    @JsonProperty
    public void setItems(List<Item> items){
        this.items = items;
    }

}
