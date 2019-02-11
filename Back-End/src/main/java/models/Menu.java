package models;

// import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
// import repository.MenuRepository;
// import com.google.common.base.MoreObjects;
import java.util.List;

public class Menu {

    private Integer id;
    private String name;
    private List<Item> items;

    public List<Item> items2 = new ArrayList<>();
    

    public Menu() { }

    public Menu(int id, String name, List<Item> items2) {
        this.id = id;
        this.name = name;
        this.items = items2;
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
