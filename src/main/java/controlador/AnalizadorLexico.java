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
public class AnalizadorLexico {

    private List<Token> tokens;
    private List<Token> errores;
    private DiccionarioToken diccionario;
    private String codigo;
    private int indice;
    private int lineaActual;
    private int columnaActual;

    public AnalizadorLexico(String codigo) {
        this.tokens = new ArrayList<>();
        this.errores = new ArrayList<>();
        this.diccionario = new DiccionarioToken();
        this.codigo = codigo;
        this.indice = 0;
        this.lineaActual = 1;
        this.columnaActual = 1;

        analizarCodigo();
    }

    public void analizarCodigo() {

        while (!esFinDeArchivo()) {
            // omitirEspacioEnBlanco();
            char caracterActual = obtenerCaracterActual();
            String cadigoRes = codigo.substring(indice);
            String lexema = diccionario.coincidenciasDiccionario(cadigoRes);

            if (esTokenConocido(lexema)) {

                tokens.add(analizarTokenConocido(lexema));
                actualizarPosicion(lexema);

            } else if (Character.isDigit(caracterActual)) {
                Token token = analizarNumero();
                if (token.getTipo() == TipoToken.ERROR) {
                    errores.add(token);
                } else {
                    tokens.add(analizarNumero());
                }

            } else if (caracterActual == '#') {

                avanzarPosicion();
                tokens.add(analizarComentario());

            } else if (caracterActual == '"' || caracterActual == '\'') {

                Token token = analizarCadena();
                if (token.getTipo() == TipoToken.ERROR) {
                    errores.add(token);
                } else {
                    tokens.add(analizarCadena());
                }

            } else if (Character.isLetter(caracterActual) || caracterActual == '_') {
                tokens.add(analizarIdentificador());
            } else {
                avanzarPosicion();
            }
        }

        // return tokens;
    }
//***************************************************************************************

    public Token analizarNumero() {
        StringBuilder lexemaBuilder = new StringBuilder();

        while (!esFinDeArchivo()) {
            char caracterActual = obtenerCaracterActual();

            if (Character.isDigit(caracterActual) || caracterActual == '.') {
                lexemaBuilder.append(caracterActual);
                avanzarPosicion();
            } else {
                break;
            }
        }

        String lexema = lexemaBuilder.toString();
        TipoToken tipoToken = determinarTipoNumero(lexema);

        // validamos si el numero decimal no es completado ej: 4., 5. etc
        if (tipoToken == TipoToken.CONSTANTE_DECIMAL && lexema.contains(".")) {
            // Crear token de tipo error para números mal formados
            return new Token(TipoToken.ERROR, "", lexema, lineaActual, columnaActual);
        }

        return new Token(tipoToken, "", lexema, lineaActual, columnaActual);

    }

    public TipoToken determinarTipoNumero(String lexema) {
        if (lexema.contains(".")) {
            return TipoToken.CONSTANTE_DECIMAL;
        } else {
            return TipoToken.CONSTANTE_ENTERO;
        }
    }
//************************************************************

    public Token analizarTokenConocido(String lexema) {

        TipoToken tipoToken = diccionario.getDiccionario().get(lexema); // Buscar el tipo de token en el diccionario
        return new Token(tipoToken, "", lexema, lineaActual, columnaActual);
    }

    public boolean esTokenConocido(String lexema) {
        return diccionario.getDiccionario().containsKey(lexema);
    }

//************************************************************************************
    public Token analizarIdentificador() {
        StringBuilder lexemaBuilder = new StringBuilder();

        while (!esFinDeArchivo()) {
            char caracterActual = obtenerCaracterActual();

            if (Character.isLetterOrDigit(caracterActual) || caracterActual == '_') {
                lexemaBuilder.append(caracterActual);
                avanzarPosicion();
            } else {
                break;
            }
        }

        String lexema = lexemaBuilder.toString();
        TipoToken tipoToken = esIdentificadorValido(lexema) ? TipoToken.IDENTIFICADOR : TipoToken.ERROR;
        return new Token(tipoToken, "", lexema, lineaActual, columnaActual);

}

    public boolean esIdentificadorValido(String lexema) {
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

    //*******************************************************************************
    public Token analizarComentario() {
        StringBuilder lexemaBuilder = new StringBuilder();

        while (!esFinDeArchivo() && obtenerCaracterActual() != '\n') {
            lexemaBuilder.append(obtenerCaracterActual());
            avanzarPosicion();
        }

        String lexema = lexemaBuilder.toString();
        return new Token(TipoToken.COMENTARIO, "", lexema, lineaActual, columnaActual);
    }
//*******************************************************************************************

    public Token analizarCadena() {
        char delimitador = obtenerCaracterActual();
        StringBuilder lexemaBuilder = new StringBuilder();
        avanzarPosicion(); // Saltar el delimitador inicial

        while (!esFinDeArchivo() && obtenerCaracterActual() != delimitador) {
            lexemaBuilder.append(obtenerCaracterActual());
            avanzarPosicion();
        }

        if (!esFinDeArchivo() && obtenerCaracterActual() == delimitador) {
            avanzarPosicion(); // Saltar el delimitador final
            String lexema = lexemaBuilder.toString();
            return new Token(TipoToken.CADENA, "", lexema, lineaActual, columnaActual);
        } else {
            // Crear token de tipo error con el contenido no cerrado
            String lexema = lexemaBuilder.toString();
            while (!esFinDeArchivo() && obtenerCaracterActual() != '\n') {
                lexema += obtenerCaracterActual();
                avanzarPosicion();
            }
            return new Token(TipoToken.ERROR, "", lexema, lineaActual, columnaActual);
        }
    }
//***************************************************************************************

    public boolean esFinDeCodigo() {      //verifica si hemos alcanzado el final del código.
        return indice >= codigo.length();
    }

    public boolean esEspacio(char caracter) {
        return caracter == ' ' || caracter == '\t';
    }

    public boolean esFinDeArchivo() {
        return indice >= codigo.length();
    }

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

    public char obtenerCaracterActual() {
        if (codigo != null && indice >= 0 && indice < codigo.length()) {
            return codigo.charAt(indice);
        } else {
            // Manejar el caso de índice fuera de los límites o cadena nula/vacía
            throw new IllegalStateException("Índice inválido o cadena nula/vacía.");
        }
    }

    public void avanzarPosicion() {
        char caracterActual = codigo.charAt(indice);
        if (caracterActual == '\n') {
            lineaActual++;
            columnaActual = 1;
        } else {
            columnaActual++;
        }
        indice++;
    }

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

    public List<Token> getTokens() {
        return tokens;
    }

    public List<Token> getErrores() {
        return errores;
    }

}
