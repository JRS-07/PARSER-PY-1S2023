/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.HashMap;
import java.util.Map;
import modelo.analizadorLexico.TipoToken;

/**
 *
 * @author jerson
 */
public class DiccionarioToken {

    private Map<String, TipoToken> diccionario;

    public DiccionarioToken() {
        this.diccionario = new HashMap<>();
        inicializarDiccionario();
    }

    public void inicializarDiccionario() {
        //Delimitadores (Otros)
        this.diccionario.put("(", TipoToken.DELIMITADORES);
        this.diccionario.put(")", TipoToken.DELIMITADORES);
        this.diccionario.put("{", TipoToken.DELIMITADORES);
        this.diccionario.put("}", TipoToken.DELIMITADORES);
        this.diccionario.put("[", TipoToken.DELIMITADORES);
        this.diccionario.put("]", TipoToken.DELIMITADORES);
        this.diccionario.put(".", TipoToken.DELIMITADORES);
        this.diccionario.put(";", TipoToken.DELIMITADORES);
        this.diccionario.put(":", TipoToken.DELIMITADORES);
        this.diccionario.put(",", TipoToken.DELIMITADORES);

        //Aritmeticos
        this.diccionario.put("+", TipoToken.ARITMETICO);
        this.diccionario.put("-", TipoToken.ARITMETICO);
        this.diccionario.put("**", TipoToken.ARITMETICO);
        this.diccionario.put("/", TipoToken.ARITMETICO);
        this.diccionario.put("//", TipoToken.ARITMETICO);
        this.diccionario.put("%", TipoToken.ARITMETICO);
        this.diccionario.put("*", TipoToken.ARITMETICO);

        //Comparacion
        this.diccionario.put("==", TipoToken.COMPARACION);
        this.diccionario.put("!=", TipoToken.COMPARACION);
        this.diccionario.put(">", TipoToken.COMPARACION);
        this.diccionario.put("<", TipoToken.COMPARACION);
        this.diccionario.put(">=", TipoToken.COMPARACION);
        this.diccionario.put("<=", TipoToken.COMPARACION);

        //Logicos ***
        this.diccionario.put("and", TipoToken.LOGICO);
        this.diccionario.put("or", TipoToken.LOGICO);
        this.diccionario.put("not", TipoToken.LOGICO);

        //Asignacion
        this.diccionario.put("=", TipoToken.ASIGNACION);
        this.diccionario.put("*=", TipoToken.ASIGNACION);
        this.diccionario.put("-=", TipoToken.ASIGNACION);

        //palabras reservadas ***
        this.diccionario.put("and", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("as ", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("assert", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("break", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("class", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("continue", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("def", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("del ", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("elif", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("else", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("except", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("finally", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("for ", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("from", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("while", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("global", TipoToken.PALABRA_RESERVADA);

        this.diccionario.put("if", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("import", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("in ", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("is ", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("lambda", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("None", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("nonlocal", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("not", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("or", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("pass", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("raise", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("return", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("True", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("try", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("while", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("with", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("yield", TipoToken.PALABRA_RESERVADA);

        //constantes  Booleanas ***
        this.diccionario.put("True", TipoToken.BOOLEAN);
        this.diccionario.put("False", TipoToken.BOOLEAN);

        //Expresiones Regulares
        this.diccionario.put("[d]+", TipoToken.ENTERO);
        this.diccionario.put("[d]+.[d][d]*", TipoToken.DECIMAL);
        this.diccionario.put("#*", TipoToken.COMENTARIO);

        this.diccionario.put("[w_][\\w\\d_]*", TipoToken.IDENTIFICADOR);

        this.diccionario.put("\".*?\"|'.*?'", TipoToken.CADENA);

    }

    public String coincidenciasDiccionario(String codigoRestante) {
        String lexema = "";

        for (Map.Entry<String, TipoToken> entrada : diccionario.entrySet()) {
            String contenidoDiccionario = entrada.getKey();
            if (codigoRestante.startsWith(contenidoDiccionario) && contenidoDiccionario.length() > lexema.length()) {
                lexema = contenidoDiccionario;
            }
        }

        return lexema;
    }

    public Map<String, TipoToken> getDiccionario() {
        return diccionario;
    }

}
