package com.example.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@DiscriminatorValue("S")
public class Student extends User{

    @Column(name="program")
    private String program;

    @OneToMany(mappedBy = "student", cascade=CascadeType.ALL)
    private Set<StuUnit> stuunits;

    public Student(){

    }

    public Student(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
        this.setType("ROLE_STUDENT");
        this.setEnabled(1);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Set<StuUnit> getStuunits() {
        return stuunits;
    }

    public void setStuunits(Set<StuUnit> stuunits) {
        this.stuunits = stuunits;
    }

}
