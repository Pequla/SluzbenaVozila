package com.pequla.api.entity;

import javax.persistence.*;

@Entity(name = "radionica")
public class Radionica {

    @Id
    @Column(name = "radionica_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;
    private int pib;
    private String adresa;
    private String mail;
    private String telefon;

    public Radionica() {
    }

    public Radionica(int id, String naziv, int pib, String adresa, String mail, String telefon) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
        this.mail = mail;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
