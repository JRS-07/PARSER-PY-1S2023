/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.DeclaracionDeVariable;

import java.util.List;

/**
 *
 * @author jerson
 */
public class DeclaracionVariableArreglo extends Declaracion{
     private List<Object> elementos;

    public DeclaracionVariableArreglo( String tipo, String nombreVariable,  List<Object> elementos) {
        super(nombreVariable, tipo);
        this.elementos = elementos;
    }

    public List<Object> getElementos() {
        return elementos;
    }

    public void setElementos(List<Object> elementos) {
        this.elementos = elementos;
    }
}
