    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.analizadorLexico.TipoToken;
import modelo.analizadorLexico.Token;

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
                    tokens.add(token);
                }

            } else if (caracterActual == '#') {

            //    avanzarPosicion();
                tokens.add(analizarComentario());

            } else if (caracterActual == '"' || caracterActual == '\'') {

                Token token = analizarCadena();
                if (token.getTipo() == TipoToken.ERROR) {
                    errores.add(token);
                } else {
                    tokens.add(token);
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
        
        String lexema = obtenerNumero();
        TipoToken tipoToken = determinarTipoNumero(lexema);
        String patron = getPatron(tipoToken);
        return new Token(tipoToken, patron, lexema, lineaActual, columnaActual);
    }

  
        public TipoToken determinarTipoNumero(String lexema) {
        if (lexema.contains(".")) {
            if (lexema.indexOf('.') != lexema.lastIndexOf('.')) {
                return TipoToken.ERROR; // Más de un punto decimal, considerado error
            }
            try {
                Double.parseDouble(lexema); // Intenta convertir a número decimal
                return TipoToken.DECIMAL;
            } catch (NumberFormatException e) {
                return TipoToken.ERROR; // No es un número decimal válido
            }
        } else {
            try {
                Integer.parseInt(lexema); // Intenta convertir a número entero
                return TipoToken.ENTERO;
            } catch (NumberFormatException e) {
                return TipoToken.ERROR; // No es un número entero válido
            }
        }
    }
    public String obtenerNumero() {
        StringBuilder lexemaBuilder = new StringBuilder();
        boolean decimalPuntoEncontrado = false;

        while (!esFinDeArchivo()) {
            char caracterActual = codigo.charAt(indice);

            if (Character.isDigit(caracterActual)) {
                lexemaBuilder.append(caracterActual);
                avanzarPosicion();
            } else if (caracterActual == '.' && !decimalPuntoEncontrado) {
                lexemaBuilder.append(caracterActual);
                decimalPuntoEncontrado = true;
                avanzarPosicion();
            } else {
                break;
            }
        }

        String lexema = lexemaBuilder.toString();
        
               // Verificar si es un número decimal incompleto (por ejemplo: 4.)
        if (lexema.endsWith(".")) {
            lexema = "Error : " + lexema;
        }

        return lexema;
    }
//************************************************************

    public Token analizarTokenConocido(String lexema) {

        TipoToken tipoToken = diccionario.getDiccionario().get(lexema); // Buscar el tipo de token en el diccionario
        return new Token(tipoToken, lexema, lexema, lineaActual, columnaActual);
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
        String patron = getPatron(tipoToken);
        return new Token(tipoToken, patron, lexema, lineaActual, columnaActual);

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
        String patron = getPatron(TipoToken.COMENTARIO);
        return new Token(TipoToken.COMENTARIO, "#", lexema, lineaActual, columnaActual);
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
            String patron = getPatron(TipoToken.CADENA);
            return new Token(TipoToken.CADENA,patron , lexema, lineaActual, columnaActual);
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
    
    private String getPatron (TipoToken tipoToken) {

        switch (tipoToken) {
            case ENTERO:
                return "[d]+";
            case DECIMAL:
                return "[d]+.[d][d]";
            case IDENTIFICADOR:
                return "[w_][\\w\\d_]*";
            case COMENTARIO:
                return "#";
            case CADENA:
                return "\".*?\"|'.*?'";

            default:
                return "";
        }
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
