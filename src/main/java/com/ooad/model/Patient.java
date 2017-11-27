package com.ooad.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="USER")
@DiscriminatorValue("Patient")
public class Patient extends User {
    @Column(name = "STATUS", nullable = true)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return "Patient";
    }
}


