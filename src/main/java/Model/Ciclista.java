package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity
@Table(name = "ciclistes", catalog = "ciclisme")
public class Ciclista {

    @Id
    @Column(name = "dorsal")
    private Long dorsal;

    @Column(name = "nom")
    private String nom;

    @Column(name = "edat")
    private int edat;

    @OneToMany(mappedBy = "elciclista", cascade = CascadeType.ALL)
    @ElementCollection(targetClass=Etapa.class)
    private Set<Etapa> ganador;

    public Ciclista() {
    }

    public Ciclista(Long dorsal, String nom, int edat) {
        this.dorsal = dorsal;
        this.nom = nom;
        this.edat = edat;
        // this.ganador = new HashSet<>();
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

//    public Set<Etapa> getGanador() {
//        return ganador;
//    }
//
//    public void addGanador(Etapa ganada) {
//        this.ganador.add(ganada);
//    }
    @Override
    public String toString() {
        return "Ciclista{" + "dorsal=" + dorsal + ", nom=" + nom + ", edat=" + edat + '}';
    }

}
