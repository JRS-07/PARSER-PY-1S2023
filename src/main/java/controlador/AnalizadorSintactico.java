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
import modelo.analizadorSintactico.Declaracion.Arreglo;
import modelo.analizadorSintactico.Declaracion.Diccionario;
import modelo.analizadorSintactico.Declaracion.EstadoEnum.Estado;
import modelo.analizadorSintactico.Declaracion.Expresion;

import modelo.analizadorSintactico.Declaracion.ResultadoParser;
import modelo.analizadorSintactico.Declaracion.ValorLiteral;
import modelo.analizadorSintactico.Declaracion.Variable;


/**
 *
 * @author jerson
 */
public class AnalizadorSintactico {

    private List<Token> tokens;
    private int indiceActual;
    private Token tokenActual;
    private ArrayList<ResultadoParser> resultados;
    
    public AnalizadorSintactico(List<Token> tokens) {
        this.tokens = tokens;
        this.indiceActual = 0;
        this.tokenActual = getNextToken();//
        this.resultados = new ArrayList<>();
        
    }

    public void encontrarDeclaracion() {
        Token asignacionToken = tokenActual;
        try {
            Variable variable = encontrarVariable();
            System.out.println("Variable"+variable.getIdentificador());
            consume(TipoToken.ASIGNACION);
            System.out.println("Asignacion" +TipoToken.ASIGNACION.toString());
            Expresion expresion = encontrarExpresion();
            System.out.println("Expresion"+expresion.toString());
            resultados.add(new ResultadoParser(Estado.CORRECTO, "Declaración",variable.getIdentificador()+" = "+expresion.toString(), tokenActual.getLinea(), tokenActual.getColumna()));
         
        } catch (SyntaxError e) {
            resultados.add(new ResultadoParser(Estado.INCORRECTO, "Error en declaración: ","---", e.getLinea(), e.getColumna()));
        }
    }

    public Variable encontrarVariable() throws SyntaxError {
        Token token = consume(TipoToken.IDENTIFICADOR);
        return new Variable(token.getLexema());
    }

    public Expresion encontrarExpresion() throws SyntaxError {
        Token token = tokenActual;
        switch (token.getTipo()) {
            case ENTERO:
            case CADENA:
            case BOOLEAN:
                avanzar();
                return new ValorLiteral(token.getLexema());
            case DELIMITADORES: // Utiliza DELIMITADOR para representar corchetes y llaves
                if (token.getLexema().equals("[")) {
                    return encontarArreglo();
                } else if (token.getLexema().equals("{")) {
                    return encontrarDiccionario();
                } else {
                    throw new SyntaxError("Error de sintaxis en línea ", token.getLinea(), token.getColumna());
                }
            default:
                throw new SyntaxError("Error de sintaxis en línea ", token.getLinea(), token.getColumna());
        }
    }

    public Arreglo encontarArreglo() throws SyntaxError {
        consume(TipoToken.DELIMITADORES, "[");
        List<Expresion> elementos = new ArrayList<>();
        while (tokenActual.getTipo() != TipoToken.DELIMITADORES || !tokenActual.getLexema().equals("]")) {
            elementos.add(encontrarExpresion());
            if (tokenActual.getTipo() == TipoToken.DELIMITADORES && tokenActual.getLexema().equals(",")) {
                avanzar();
            } else {
                break;
            }
        }
        consume(TipoToken.DELIMITADORES, "]");
        return new Arreglo(elementos);
    }

    public Diccionario encontrarDiccionario() throws SyntaxError {
        consume(TipoToken.DELIMITADORES, "{");
        Map<String, Expresion> paresClaveValor = new HashMap<>();
        while (tokenActual.getTipo() != TipoToken.DELIMITADORES || !tokenActual.getLexema().equals("}")) {
            String clave = consume(TipoToken.CADENA).getLexema();
            consume(TipoToken.ASIGNACION);
            Expresion valor = encontrarExpresion();
            paresClaveValor.put(clave, valor);
            if (tokenActual.getTipo() == TipoToken.DELIMITADORES && tokenActual.getLexema().equals(",")) {
                avanzar();
            } else {
                break;
            }
        }
        consume(TipoToken.DELIMITADORES, "}");
        return new Diccionario(paresClaveValor);
    }

private Token getNextToken() {
    if (indiceActual < tokens.size()) {
        return tokens.get(indiceActual++);
    } else {
        // Devuelve un token especial para indicar el final de la lista
        return new Token(TipoToken.FIN_DE_LISTA, "", -1, -1);
    }
}

    private void avanzar() {
        tokenActual = getNextToken();
    }

    private Token consume(TipoToken tipo) throws SyntaxError {
        Token token = tokenActual;
        if (token.getTipo() == tipo) {
            avanzar();
        } else {
            throw new SyntaxError("Error de sintaxis en línea ", token.getLinea(), token.getColumna());
        }
        return token;
    }

    private void consume(TipoToken tipo, String lexema) throws SyntaxError {
        Token token = tokenActual;
        if (token.getTipo() == tipo && token.getLexema().equals(lexema)) {
            avanzar();
        } else {
            throw new SyntaxError("Error de sintaxis en línea ", token.getLinea(), token.getColumna());
        }
    }

    public ArrayList<ResultadoParser> getResultados() {
        return resultados;
    }

 
    
}
