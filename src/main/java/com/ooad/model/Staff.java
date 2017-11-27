package com.ooad.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@DiscriminatorValue("Staff")
public class Staff extends User {

    @Column(name = "DESIGNATION", nullable = false)
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getType() {
        return "Staff";
    }
}