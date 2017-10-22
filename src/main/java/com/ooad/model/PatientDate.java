package com.ooad.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PatientDate implements Serializable {

    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "DATE", nullable = false)
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
