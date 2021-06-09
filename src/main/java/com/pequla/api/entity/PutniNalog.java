package com.pequla.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "putni_nalog")
public class PutniNalog {
    @Id
    @Column(name = "nalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vozilo_id", nullable = false)
    private Vozilo vozilo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "zaposleni_id", nullable = false)
    private Zaposleni zaposleni;

    private int km;

    @Column(name = "datum", insertable = false, updatable = false)
    private Date datum;

    public PutniNalog() {
    }

    public PutniNalog(int id, Vozilo vozilo, Zaposleni zaposleni, int km, Date datum) {
        this.id = id;
        this.vozilo = vozilo;
        this.zaposleni = zaposleni;
        this.km = km;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
