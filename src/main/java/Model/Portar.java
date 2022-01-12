package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity
@Table(name = "portar", catalog = "ciclisme")
public class Portar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    @JoinColumn(name = "dorsal")
    private Ciclista ciclista;
    
    @Column
    @JoinColumn(name = "numero")
    private Etapa etapa;
    
    @Column
    @JoinColumn(name = "codi")
    private Mallot mallot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ciclista getElciclista() {
        return ciclista;
    }

    public void setElciclista(Ciclista elciclista) {
        this.ciclista = elciclista;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Mallot getElmallot() {
        return mallot;
    }

    public void setElmallot(Mallot elmallot) {
        this.mallot = elmallot;
    }

    public Portar() {
    }

    public Portar(Ciclista elciclista, Etapa etapa, Mallot elmallot) {
        this.ciclista = elciclista;
        this.etapa = etapa;
        this.mallot = elmallot;
    }

    @Override
    public String toString() {
        return "Portar{" + "elciclista=" + ciclista + ", etapa=" + etapa + ", elmallot=" + mallot + '}';
    }

}
