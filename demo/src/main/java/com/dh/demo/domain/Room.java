package com.dh.demo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by DELL on 10/06/2017.
 */
@Document
public class Room {
    private String id;
    private int capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
