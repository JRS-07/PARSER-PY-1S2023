/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.DeclaracionDeVariable;

/**
 *
 * @author jerson
 */
public class DeclaracionVariableSimple extends Declaracion{
    private Object valor;

    public DeclaracionVariableSimple( String tipo, String nombreVariable,  Object valor) {
        super(nombreVariable, tipo);
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
