package com.pequla.api.entity;

import javax.persistence.*;

@Entity(name = "zaposleni")
public class Zaposleni {
    @Id
    @Column(name = "zaposleni_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ime;
    private String prezime;
    private int ovlascenje;
    private String mobilni;
    private String email;
    private String jmbg;

    public Zaposleni() {
    }

    public Zaposleni(int id, String ime, String prezime, int ovlascenje, String mobilni, String email, String jmbg) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.ovlascenje = ovlascenje;
        this.mobilni = mobilni;
        this.email = email;
        this.jmbg = jmbg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getOvlascenje() {
        return ovlascenje;
    }

    public void setOvlascenje(int ovlascenje) {
        this.ovlascenje = ovlascenje;
    }

    public String getMobilni() {
        return mobilni;
    }

    public void setMobilni(String mobilni) {
        this.mobilni = mobilni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
