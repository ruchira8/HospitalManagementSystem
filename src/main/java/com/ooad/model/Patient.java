package com.ooad.model;

import javax.persistence.*;


@Entity
@Table(name="USER")
@DiscriminatorValue("Patient")
public class Patient extends User {

}


