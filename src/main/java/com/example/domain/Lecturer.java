package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
@DiscriminatorValue("L")
public class Lecturer extends User {

    public Lecturer(){

    }

    public Lecturer(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setType("ROLE_LECTURER");
        this.setEnabled(1);
    }
}
