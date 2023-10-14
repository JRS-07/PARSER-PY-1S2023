/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.analizadorLexico;

/**
 *
 * @author jerson
 */
public enum TipoToken {
    IDENTIFICADOR,
    ARITMETICO,
    COMPARACION,
    LOGICO,
    ASIGNACION,
    PALABRA_RESERVADA,
    ENTERO,
    DECIMAL,
    CADENA,
    BOOLEAN,
    COMENTARIO,
    DESCONOCIDO,
    DELIMITADORES,
    ERROR,
    FIN_DE_LISTA
}
