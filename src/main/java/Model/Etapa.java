package Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity(name = "etapes")
@Table(name = "etapes", catalog = "ciclisme")
public class Etapa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Long numero;

    @Column(name = "kms")
    private int kms;

    @Column(name = "eixida")
    private String eixida;

    @Column(name = "arribada")
    private String arribada;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dorsal")
    private Ciclista elciclista_ganador;

    public Etapa() {
    }

    public Etapa(int kms, String eixida, String arribada) {
        this.kms = kms;
        this.eixida = eixida;
        this.arribada = arribada;

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

    public Ciclista getElciclista_ganador() {
        return elciclista_ganador;
    }

    public void setElciclista_ganador(Ciclista elciclista_ganador) {
        this.elciclista_ganador = elciclista_ganador;
    }

    @Override
    public String toString() {
        return "Etapa{" + "numero=" + numero + ", kms=" + kms + ", eixida=" + eixida + ", arribada=" + arribada + '}';
    }

}
