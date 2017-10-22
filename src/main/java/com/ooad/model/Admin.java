package com.ooad.model;

import javax.persistence.*;


@Entity
@Table(name = "USER")
@DiscriminatorValue("Admin")
public class Admin extends User {

    @Column(name = "DESIGNATION", nullable = false)
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}


