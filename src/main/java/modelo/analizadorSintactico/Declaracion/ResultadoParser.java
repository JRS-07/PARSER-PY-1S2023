/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.Declaracion;

import modelo.analizadorSintactico.Declaracion.EstadoEnum.Estado;

/**
 *
 * @author jerson
 */
public class ResultadoParser {
     private Estado estado;
    private String tipo;
    private int linea;
    private int columna;
    private String bloque;

    public ResultadoParser(){
    
    }
    public ResultadoParser(Estado estado, String detalle, String bloque, int linea, int columna) {
        this.estado = estado;
        this.tipo = detalle;
        this.bloque = bloque;
        this.linea = linea;
        this.columna = columna;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }   

    public String getBloque() {
        return bloque;
    }
    
}
