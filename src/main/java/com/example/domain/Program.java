package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="program")
public class Program {

    @Id
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="totalcredit")
    private int totalCredit;

    @Column(name="unitlimit")
    private int unitLimit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public int getUnitLimit() {
        return unitLimit;
    }

    public void setUnitLimit(int unitLimit) {
        this.unitLimit = unitLimit;
    }

}
