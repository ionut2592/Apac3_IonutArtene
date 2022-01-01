/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ionut
 */
@Entity
@Table(name = "portar")
public class Portar {

    private Set<Ciclista> ciclista;
    private Set<Etapa> elsetapes;
    private Set<Mallot> mallot;

}
