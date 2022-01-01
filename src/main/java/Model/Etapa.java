/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity
@Table(name = "etapes")
public class Etapa {

    @Id
    @Column(name = "numero")
    private Long numero;

    @Column(name = "kms")
    private int kms;

    @Column(name = "eixida")
    private String eixida;

    @Column(name = "arribada")
    private String arribada;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dorsal")
    private Set<Ciclista> elsciclistes;

    public Etapa() {
    }

    public Etapa(Long numero, int kms, String eixida, String arribada, Set<Ciclista> elsciclistes) {
        this.numero = numero;
        this.kms = kms;
        this.eixida = eixida;
        this.arribada = arribada;
        this.elsciclistes = elsciclistes;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public String getEixida() {
        return eixida;
    }

    public void setEixida(String eixida) {
        this.eixida = eixida;
    }

    public String getArribada() {
        return arribada;
    }

    public void setArribada(String arribada) {
        this.arribada = arribada;
    }

    public Set<Ciclista> getElsciclistes() {
        return elsciclistes;
    }

    public void setElsciclistes(Set<Ciclista> elsciclistes) {
        this.elsciclistes = elsciclistes;
    }

    @Override
    public String toString() {
        return "Etapa{" + "numero=" + numero + ", kms=" + kms + ", eixida=" + eixida + ", arribada=" + arribada + '}';
    }

    public void addCiclicsta(Ciclista c) {
        this.elsciclistes.add(c);
    }
}
