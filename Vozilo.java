/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TRTANJ
 */
@Entity
@Table(name = "vozilo")
public class Vozilo extends Entitet{
    
    
    private String marka;
    private String model;
    private Integer godiste;
    private Integer kilometraza;
    private BigDecimal cijena;
    private Boolean uvoz;
    
    @ManyToOne
    private Kupac kupac;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGodiste() {
        return godiste;
    }

    public void setGodiste(Integer godiste) {
        this.godiste = godiste;
    }

    public Integer getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(Integer kilometraza) {
        this.kilometraza = kilometraza;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Boolean getUvoz() {
        return uvoz;
    }

    public void setUvoz(Boolean uvoz) {
        this.uvoz = uvoz;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

   
}
