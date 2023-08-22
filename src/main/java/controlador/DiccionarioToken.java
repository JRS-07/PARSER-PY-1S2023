/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.util.HashMap;
import java.util.Map;
import modelo.TipoToken;

/**
 *
 * @author jerson
 */
public class DiccionarioToken {
    
    private Map<String, TipoToken> diccionario;
    
    public DiccionarioToken(){
        this.diccionario = new HashMap<>();
        inicializarDiccionario();
    }
    
    public void inicializarDiccionario(){
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
        this.diccionario.put("=", TipoToken.ASIGANCION);
        this.diccionario.put("*=", TipoToken.ASIGANCION);
        this.diccionario.put("-=", TipoToken.ASIGANCION);

        //palabras reservadas ***
        this.diccionario.put("while", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("def", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("for", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("if", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("case", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("else", TipoToken.PALABRA_RESERVADA);

        //constantes  Booleanas ***
        this.diccionario.put("True", TipoToken.BOOLEAN);
        this.diccionario.put("False", TipoToken.BOOLEAN);
      
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
