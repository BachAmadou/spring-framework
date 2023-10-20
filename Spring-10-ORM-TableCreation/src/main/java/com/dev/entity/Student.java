package com.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id // we use @Id to make the id the 'primary key'
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
}
