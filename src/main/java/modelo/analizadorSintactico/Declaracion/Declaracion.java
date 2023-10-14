/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.Declaracion;

/**
 *
 * @author jerson
 */
public class Declaracion {
     private Variable variable;
    private Expresion expresion;

    public Declaracion(Variable variable, Expresion expresion) {
        this.variable = variable;
        this.expresion = expresion;
    }

    public Variable getVariable() {
        return variable;
    }

    public Expresion getExpresion() {
        return expresion;
    }
}
