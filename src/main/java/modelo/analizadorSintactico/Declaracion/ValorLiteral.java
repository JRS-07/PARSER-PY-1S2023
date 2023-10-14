/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.Declaracion;

/**
 *
 * @author jerson
 */
public class ValorLiteral extends Expresion{
     private Object valor;

    public ValorLiteral(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }
}
