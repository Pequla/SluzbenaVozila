package com.pequla.api.entity;

import javax.persistence.*;

@Entity(name = "vozilo")
public class Vozilo {
    @Id
    @Column(name = "vozilo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "registarska_oznaka")
    private String registarskaOznaka;

    @Column(name = "broj_sasije")
    private String brojSasije;

    private String vlasnik;

    @Column(name = "godina_proizvodnje")
    private int godiste;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    public Vozilo() {
    }

    public Vozilo(int id, String registarskaOznaka, String brojSasije, String vlasnik, int godiste, Model model) {
        this.id = id;
        this.registarskaOznaka = registarskaOznaka;
        this.brojSasije = brojSasije;
        this.vlasnik = vlasnik;
        this.godiste = godiste;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistarskaOznaka() {
        return registarskaOznaka;
    }

    public void setRegistarskaOznaka(String registarskaOznaka) {
        this.registarskaOznaka = registarskaOznaka;
    }

    public String getBrojSasije() {
        return brojSasije;
    }

    public void setBrojSasije(String brojSasije) {
        this.brojSasije = brojSasije;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
