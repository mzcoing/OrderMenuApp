package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.ThreadLocalRandom;

public class Order {

    private Integer id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);

    public Order() { }

    @JsonProperty
    public Integer getId() {
        return this.id;
    }

}
