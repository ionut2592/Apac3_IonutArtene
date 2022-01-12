package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
@Table(name = "etapes",catalog = "ciclisme")
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero")
    private Long numero;

    @Column(name = "kms")
    private int kms;

    @Column(name = "eixida")
    private String eixida;

    @Column(name = "arribada")
    private String arribada;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dorsal")
    private Ciclista elciclista;

    public Etapa() {
    }

    public Etapa(Long numero, int kms, String eixida, String arribada, Ciclista elciclista) {
        this.numero = numero;
        this.kms = kms;
        this.eixida = eixida;
        this.arribada = arribada;
        this.elciclista = elciclista;
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

    public Ciclista getElciclista() {
        return elciclista;
    }

    public void setElciclista(Ciclista elciclista) {
        this.elciclista = elciclista;
    }

    @Override
    public String toString() {
        return "Etapa{" + "numero=" + numero + ", kms=" + kms + ", eixida=" + eixida + ", arribada=" + arribada + '}';
    }

}
