package com.pequla.api.entity;

import javax.persistence.*;

@Entity(name = "model")
public class Model {

    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marka;
    private String tip;
    private int zapremina;
    private int snaga;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vrsta_id", nullable = false)
    private Vrsta vrsta;

    public Model() {

    }

    public Model(int id, String marka, String tip, int zapremina, int snaga, Vrsta vrsta) {
        this.id = id;
        this.marka = marka;
        this.tip = tip;
        this.zapremina = zapremina;
        this.snaga = snaga;
        this.vrsta = vrsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getZapremina() {
        return zapremina;
    }

    public void setZapremina(int zapremina) {
        this.zapremina = zapremina;
    }

    public int getSnaga() {
        return snaga;
    }

    public void setSnaga(int snaga) {
        this.snaga = snaga;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }
}
