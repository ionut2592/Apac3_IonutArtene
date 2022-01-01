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
@Table(name = "ciclistes")
public class Ciclista {

    @Id
    @Column(name = "dorsal")
    private Long dorsal;

    @Column(name = "nom")
    private String nom;

    @Column(name = "edat")
    private int edat;

    public Ciclista() {
    }

    public Ciclista(Long dorsal, String nom, int edat) {
        this.dorsal = dorsal;
        this.nom = nom;
        this.edat = edat;
    }

    public Long getDorsal() {
        return dorsal;
    }

    public void setDorsal(Long dorsal) {
        this.dorsal = dorsal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Ciclista{" + "dorsal=" + dorsal + ", nom=" + nom + ", edat=" + edat + '}';
    }

}
