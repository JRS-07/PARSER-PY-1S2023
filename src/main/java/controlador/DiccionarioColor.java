/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import modelo.TipoToken;

/**
 *
 * @author jerson
 */
public class DiccionarioColor {

    private Map<TipoToken, Color> diccionario;

    public DiccionarioColor() {
        diccionario = new HashMap<>();
        diccionario.put(TipoToken.IDENTIFICADOR, Color.BLUE);
        diccionario.put(TipoToken.ARITMETICO, Color.CYAN);
        diccionario.put(TipoToken.COMPARACION, Color.CYAN);
        diccionario.put(TipoToken.LOGICO, Color.CYAN);
        diccionario.put(TipoToken.ASIGANCION, Color.CYAN);
        diccionario.put(TipoToken.PALABRA_RESERVADA, Color.magenta);
        diccionario.put(TipoToken.ENTERO, Color.RED);
        diccionario.put(TipoToken.DECIMAL, Color.RED);
        diccionario.put(TipoToken.BOOLEAN, Color.RED);
        diccionario.put(TipoToken.CADENA, Color.RED);
        diccionario.put(TipoToken.COMENTARIO, Color.GRAY);
        diccionario.put(TipoToken.DELIMITADORES, Color.GREEN);
    

    

    }

    public Color getColorForToken(TipoToken tipoToken) {
        return diccionario.getOrDefault(tipoToken, Color.BLACK);
    }
}
