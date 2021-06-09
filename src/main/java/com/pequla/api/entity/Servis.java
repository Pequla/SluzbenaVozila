package com.pequla.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "servis")
public class Servis {

    @Id
    @Column(name = "servis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vozilo_id", nullable = false)
    private Vozilo vozilo;

    private int km;

    // Automacki generisano iz mysql-a
    @Column(name = "datum", insertable = false, updatable = false)
    private Date datum;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usluga_id", nullable = false)
    private Usluga usluga;

    @ManyToOne(optional = false)
    @JoinColumn(name = "radionica_id", nullable = false)
    private Radionica radionica;

    private int iznos;


    public Servis() {
    }

    public Servis(int id, Vozilo vozilo, int km, Date datum, Usluga usluga, Radionica radionica, int iznos) {
        this.id = id;
        this.vozilo = vozilo;
        this.km = km;
        this.datum = datum;
        this.usluga = usluga;
        this.radionica = radionica;
        this.iznos = iznos;
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

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Radionica getRadionica() {
        return radionica;
    }

    public void setRadionica(Radionica radionica) {
        this.radionica = radionica;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }
}
