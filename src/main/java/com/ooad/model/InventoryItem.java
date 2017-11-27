package com.ooad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class InventoryItem {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "TYPE", nullable = true)
    private String type;

    @Column(name = "AVAILABLE", nullable = false)
    private int available;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
