/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.Declaracion;

import java.util.Map;

/**
 *
 * @author jerson
 */
public class Diccionario  extends Expresion{
     private Map<String, Expresion> paresClaveValor;

    public Diccionario(Map<String, Expresion> paresClaveValor) {
        this.paresClaveValor = paresClaveValor;
    }

    public Map<String, Expresion> getParesClaveValor() {
        return paresClaveValor;
    }
}
