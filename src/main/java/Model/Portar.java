package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity(name = "portar")
@Table(name = "portar", catalog = "ciclisme")
public class Portar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorsal")
    private Ciclista ciclista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codi")
    private Mallot mallot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;

    }

    public Mallot getMallot() {
        return mallot;
    }

    public void setMallot(Mallot mallot) {
        this.mallot = mallot;
    }

    public Ciclista getCiclista() {
        return ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
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
