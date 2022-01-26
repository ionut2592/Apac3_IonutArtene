package Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity(name = "mallots")
@Table(name = "mallots", catalog = "ciclisme")
public class Mallot implements Serializable {

    @Id
    @Column(name = "codi")
    private String codi;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "color")
    private String color;

    @Column(name = "premi")
    private int premi;


    public Mallot() {
    }

    public Mallot(String codi, String tipus, String color, int premi) {
        this.codi = codi;
        this.tipus = tipus;
        this.color = color;
        this.premi = premi;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
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

//    public Set<Ciclista> getCiclista() {
//        return ciclista;
//    }
//
//    public void setCiclista(Set<Ciclista> ciclista) {
//        this.ciclista = ciclista;
//    }
//
//    public Set<Etapa> getEtapas() {
//        return etapas;
//    }
//
//    public void setEtapas(Set<Etapa> etapas) {
//        this.etapas = etapas;
//    }
//    

    @Override
    public String toString() {
        return "Mallot{" + "codi=" + codi + ", tipus=" + tipus + ", color=" + color + ", premi=" + premi + '}';
    }

}
