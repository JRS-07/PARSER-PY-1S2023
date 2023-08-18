/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jerson
 */
public class Token {

    private String lexema;
    private String descripcion;
    private TipoToken tipo;  //Enumerador que define los diferentes tipos de tokens que el analizador puede reconocer.
    private int linea;
    private int columna;
    private String patron;
    //  private has<String>

    public Token() {
    }

    public Token(TipoToken tipo, String patron, String lexema, int linea, int columna) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
        this.patron = patron;
    }

    // Getters y setters
    public String getLexema() {
        return lexema;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    @Override
    public String toString() {
        return "Token{" + "lexema=" + lexema + ", descripcion=" + descripcion + ", tipo=" + tipo + ", linea=" + linea + ", columna=" + columna + ", patron=" + patron + '}';
    }

}
