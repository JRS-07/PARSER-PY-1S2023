/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author jerson
 */

public class SyntaxError extends Exception {
    private int linea;
    private int columna;
    
    public SyntaxError(String message, int linea, int columna) {
        super(message);
         this.linea = linea;
        this.columna = columna;
    }
    
     public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }
}
