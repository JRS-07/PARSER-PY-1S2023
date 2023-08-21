/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.TipoToken;
import modelo.Token;

/**
 *
 * @author jerson
 */
public class Analizador {
   // private List<Token> tokens;
    private String codigo;
    private int indice;
    private int lineaActual;
    private int columnaActual;
    private Map<String, TipoToken> diccionario;

    public Analizador(String codigo) {
        //this.tokens = new ArrayList<>();
        this.codigo = codigo;
        this.indice = 0;
        this.lineaActual = 1;
        this.columnaActual = 1;
       
       
       inicializarDiccionario();
    }

    public void inicializarDiccionario() {
         this.diccionario = new HashMap<>();
        this.diccionario.put("(", TipoToken.DELIMITADORES);
        this.diccionario.put(")", TipoToken.DELIMITADORES);

        //palabras reservadas
        this.diccionario.put("while", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("def", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("for", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("if", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("case", TipoToken.PALABRA_RESERVADA);
        this.diccionario.put("else", TipoToken.PALABRA_RESERVADA);

        //constantes  Booleanas
        this.diccionario.put("True", TipoToken.CONSTANTE_BOOLEANA);
        this.diccionario.put("False", TipoToken.CONSTANTE_BOOLEANA);
        
        

    }

    
 
    
    public List<Token> analizarCodigo() {
      List<Token> tokens = new ArrayList<>();
      
        while (!esFinDeArchivo()) {
            try {
                
                omitirEspacioEnBlanco();
                TipoToken tipoToken = null;
                String lexema = null;

                char caracterActual = this.codigo.charAt(indice);

                //// Obtiene la porción del código fuente que sigue sin analizar a partir de la posición actual
                String codigoFuente = this.codigo.substring(this.indice);
                

                for (Map.Entry<String, TipoToken> entrada : diccionario.entrySet()) { //LEE LAS PALABRAS RESERVADAS QUE ESTAN EN EL DICCIONARIO
                    String palabraReservada = entrada.getKey();

                    if (codigoFuente.startsWith(palabraReservada)) {
                        tipoToken = entrada.getValue();
                        lexema = palabraReservada;
                        break;
                    }
                }

                //Creamos los token que encontro en el codigo.
                if (tipoToken != null && lexema != null) {
                    Token token = new Token(tipoToken, "", lexema, this.lineaActual, this.columnaActual);
                    tokens.add(token);
                    actualizarPosicion(lexema);

                    //creamos el objeto token tipo constante(entero y decimal)
                } else if (Character.isDigit(caracterActual)) { //TOKENS CONSTANTES, NUMEROS 
                    lexema = obtenerNumero();
                    tipoToken = determinarTipoNumero(lexema);
                    Token token = new Token(tipoToken, "", lexema, this.lineaActual, this.columnaActual);
                    tokens.add(token);
                } else if (Character.isLetter(caracterActual) || caracterActual == '_') {
                    lexema = obtenerIdentificador();
                   tipoToken = esIdentificadorValido(lexema) ? TipoToken.IDENTIFICADOR : TipoToken.DESCONOCIDO;
                     // tipoToken = determinarTipoIdentificador(lexema);
                    Token token = new Token(tipoToken, "", lexema, this.lineaActual, this.columnaActual);
                    tokens.add(token);
                }/* else if (this.diccionario.containsKey(String.valueOf(caracterActual))) {
                    TipoToken tiipoToken = diccionario.get(String.valueOf(caracterActual));
                    Token token = new Token(tiipoToken, "", String.valueOf(caracterActual), this.lineaActual, this.columnaActual);
                    tokens.add(token);
                    avanzarPosicion();

                } */else {

                    // Si no se encuentra un tipo de token válido, se podría avanzar un carácter en la posición actual.
                    actualizarPosicion(String.valueOf(caracterActual));
                    
                    //actualizarPosicion(String.valueOf(this.code.charAt(this.posicionActual)));
                }

            } catch (Exception e) {

                //e.printStackTrace();
            }
        }

        return tokens;

    }
    
  /*  //Obtener caracter Actual
    public char obtenerCaracterActual(){
        return codigo.charAt(indice);
    }
*/
    
    //verifica el final del archivo
    private boolean esFinDeArchivo() {
        return indice >= codigo.length();
    }

    //No toma en cuenta los espacios en blanco o saltos de linea
    public void omitirEspacioEnBlanco() {
        while (!esFinDeArchivo()) {
            char caracterActual = codigo.charAt(indice);
            if (Character.isWhitespace(caracterActual) || !Character.isLetterOrDigit(caracterActual) && caracterActual != '_') {
                if (caracterActual == '\n') {
                    lineaActual++;
                    columnaActual = 1;
                } else {
                    columnaActual++;
                }
                indice++;

            } else {
                break;
            }
        }
    }

    //Actualiza la posocion en el codigo despues de haber reconocido un token
    private void actualizarPosicion(String lexema) {
        for (char c : lexema.toCharArray()) {
            if (c == '\n') {
                lineaActual++;
                columnaActual = 1;
            } else {
                columnaActual++;
            }
        }
        indice += lexema.length();
    }

    //Reconoce el lexema para identificadores
    private String obtenerLexema() {
        StringBuilder lexemaBuilder = new StringBuilder();

        while (!esFinDeArchivo() && Character.isLetter(codigo.charAt(indice))) {
            lexemaBuilder.append(codigo.charAt(indice));
            avanzarPosicion();
        }

        return lexemaBuilder.toString();
    }

   
    //Metodo para obtener numero del codigo fuente
    private String obtenerNumero() {
        StringBuilder lexemaBuilder = new StringBuilder();
        while (!esFinDeArchivo()) {
            char caracterActual = codigo.charAt(indice);

            if (Character.isDigit(caracterActual) || caracterActual == '.') {
                lexemaBuilder.append(caracterActual);
                avanzarPosicion();
            } else {
                break;
            }
        }

        return lexemaBuilder.toString();
    }

    //Verifica si es entero o decimal, y se le asigna el tipo de constate numerica
    private TipoToken determinarTipoNumero(String lexema) {
        if (lexema.contains(".")) {
            return TipoToken.CONSTANTE_DECIMAL;
        } else {
            return TipoToken.CONSTANTE_ENTERO;
        }
    }

    //Esta en proceso
    private String obtenerIdentificador() {
        StringBuilder lexemaBuilder = new StringBuilder();
        while (!esFinDeArchivo()&& (Character.isLetterOrDigit(codigo.charAt(indice)) || codigo.charAt(indice) == '_')) {
            lexemaBuilder.append(codigo.charAt(indice));
            avanzarPosicion();
        }
        return lexemaBuilder.toString();
    }

    private TipoToken determinarTipoIdentificador(String lexema) {
        // Puedes implementar lógica para verificar si es una palabra clave
        // y devolver TipoToken.PALABRA_CLAVE si aplica.
        // De lo contrario, puede ser un identificador.
        // Aquí, simplemente devuelvo TipoToken.IDENTIFICADOR.
        return TipoToken.IDENTIFICADOR;
    }

    private boolean esIdentificadorValido(String lexema) {
        if (lexema.isEmpty() || Character.isDigit(lexema.charAt(0))) {
            return false; // No puede comenzar con un número
        }

        for (char c : lexema.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false; // Solo se permiten letras, números y guiones bajos
            }
        }

        return true;
    }

    private void avanzarPosicion() {
        char caracterActual = codigo.charAt(indice);
        if (caracterActual == '\n') {
            lineaActual++;
            columnaActual = 1;
        } else {
            columnaActual++;
        }
        indice++;
    }

}
