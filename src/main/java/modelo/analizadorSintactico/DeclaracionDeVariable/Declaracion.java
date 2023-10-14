/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorSintactico.DeclaracionDeVariable;

/**
 *
 * @author jerson
 */
public class Declaracion {
    private String tipo;
    private String nombreVariable;
    

    public Declaracion( String tipo, String nombreVariable) {
        this.nombreVariable = nombreVariable;
        this.tipo = tipo;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
