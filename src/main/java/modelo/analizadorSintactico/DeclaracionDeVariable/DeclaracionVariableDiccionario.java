/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.DeclaracionDeVariable;

import java.util.Map;

/**
 *
 * @author jerson
 */
public class DeclaracionVariableDiccionario extends Declaracion{
     private Map<String, Object> entradas;

    public DeclaracionVariableDiccionario(String tipo, String nombreVariable, Map<String, Object> entradas) {
        super(nombreVariable, tipo);
        this.entradas = entradas;
    }

    public Map<String, Object> getEntradas() {
        return entradas;
    }

    public void setEntradas(Map<String, Object> entradas) {
        this.entradas = entradas;
    }
}
