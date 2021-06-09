package com.pequla.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "vrsta")
public class Vrsta implements Serializable {

    @Id
    @Column(name = "vrsta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String opis;

    public Vrsta() {
    }

    public Vrsta(int id, String opis) {
        this.id = id;
        this.opis = opis;
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
