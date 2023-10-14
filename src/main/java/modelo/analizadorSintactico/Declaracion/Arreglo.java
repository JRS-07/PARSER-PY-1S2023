/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.Declaracion;

import java.util.List;

/**
 *
 * @author jerson
 */
public class Arreglo  extends Expresion {
      private List<Expresion> elementos;

    public Arreglo(List<Expresion> elementos) {
        this.elementos = elementos;
    }

    public List<Expresion> getElementos() {
        return elementos;
    }
}
