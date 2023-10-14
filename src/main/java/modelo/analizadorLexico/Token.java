/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorLexico;

/**
 *
 * @author jerson
 */
public class Token {

    private String lexema;
   
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
    
       public Token(TipoToken tipo, String lexema, int linea, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

     public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
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

    @Override
    public String toString() {
        return "Token{" + "lexema=" + lexema + ", tipo=" + tipo + ", linea=" + linea + ", columna=" + columna + ", patron=" + patron + '}';
    }

       public String getReport() {
        return String.format("Tipo Token: %s | Patron: %s | Lexema: %s | Linea: %d | Columna: %d ",
                tipo, patron, lexema, linea, columna);
    }

}
