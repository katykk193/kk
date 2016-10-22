package com.example.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="stuunit")
public class StuUnit implements Serializable {

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Student student;

    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(name="assignment")
    private String assignment;

    @Column(name="grade")
    private Double grade;

    public StuUnit(){

    }

    public StuUnit(Student student, Unit unit){
        this.student = student;
        this.unit = unit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
