package com.pequla.api.entity;

import javax.persistence.*;

@Entity(name = "usluga")
public class Usluga {

    @Id
    @Column(name = "usluga_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String opis;

    public Usluga() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
