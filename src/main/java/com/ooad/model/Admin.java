package com.ooad.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "USER")
@DiscriminatorValue("Admin")
public class Admin extends User {
    public String getType() {
        return "Admin";
    }
}


