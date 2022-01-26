package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity(name = "ciclistes")
@Table(name = "ciclistes", catalog = "ciclisme")
public class Ciclista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dorsal")
    private Long dorsal;

    @Column(name = "nom")
    private String nom;

    @Column(name = "edat")
    private int edat;

    @OneToMany(mappedBy = "elciclista_ganador", cascade = CascadeType.ALL)
    private Set<Etapa> ganador;

    @OneToMany(mappedBy = "ciclista", cascade = CascadeType.ALL)
    private Set<Portar> elsmallots;

    public Ciclista() {
    }

    public Ciclista(String nom, int edat) {

        this.nom = nom;
        this.edat = edat;
        this.ganador = new HashSet<>();
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

    public Set<Etapa> getGanador() {
        return ganador;
    }

    public void setGanador(Set<Etapa> ganador) {
        this.ganador = ganador;
    }

    public void addEtapaGanada(Etapa e) {

        this.ganador.add(e);

    }

    public Set<Portar> getElsmallots() {
        return elsmallots;
    }

    public void setElsmallots(Set<Portar> elsmallots) {
        this.elsmallots = elsmallots;
    }

    @Override
    public String toString() {
        return "Ciclista{" + "dorsal=" + dorsal + ", nom=" + nom + ", edat=" + edat + '}';
    }

}
