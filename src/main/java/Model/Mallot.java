/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity
@Table(name = "mallots")
public class Mallot {

    @Id
    @Column(name = "codi")
    private Long codi;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "color")
    private String color;

    @Column(name = "premi")
    private int premi;

    public Mallot() {
    }

    public Mallot(Long codi, String tipus, String color, int premi) {
        this.codi = codi;
        this.tipus = tipus;
        this.color = color;
        this.premi = premi;
    }

    public Long getCodi() {
        return codi;
    }

    public void setCodi(Long codi) {
        this.codi = codi;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPremi() {
        return premi;
    }

    public void setPremi(int premi) {
        this.premi = premi;
    }

    @Override
    public String toString() {
        return "Mallot{" + "codi=" + codi + ", tipus=" + tipus + ", color=" + color + ", premi=" + premi + '}';
    }

}
