/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import modelo.analizadorLexico.Token;

/**
 *
 * @author jerson
 */
public class Archivo {

  //  private ArrayList<String> listaLineasArchivo = new ArrayList();
private String contenidoArchivo;

    public Archivo(File archivo) {
        this.listarLineasArchivo(archivo);
    }

    public Archivo() {

    }

    /**
     * Lista las de un archivo.
     *
     * @param archivo
     */
    private void listarLineasArchivo(File archivo) {
        StringBuilder contenido = new StringBuilder();
        try {
            
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
               contenido.append(linea).append("\n");
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
        contenidoArchivo = contenido.toString();
    }

  
    
  public void mostrarContenidoColoreado(JTextPane taCodigoFuente, DiccionarioColor diccionarioColor) {
        taCodigoFuente.setText("");
        StyledDocument doc = taCodigoFuente.getStyledDocument();

        AnalizadorLexico analizador = new AnalizadorLexico(contenidoArchivo);
        List<Token> listaTokens = analizador.getTokens();
        insertarTextoColoreado(doc, contenidoArchivo, listaTokens, diccionarioColor);
    }

    private void insertarTextoColoreado(StyledDocument doc, String texto, List<Token> listaTokens, DiccionarioColor diccionarioColor) {
        int posicion = 0;

        for (Token token : listaTokens) {
            int inicioToken = contenidoArchivo.indexOf(token.getLexema(), posicion);
            int finToken = inicioToken + token.getLexema().length();
            AttributeSet attrs = obtenerAtributosToken(token, diccionarioColor);

            if (inicioToken >= 0) {
                insertarTextoColoreado(doc, texto.substring(posicion, inicioToken), null);
                insertarTextoColoreado(doc, token.getLexema(), attrs);
                posicion = finToken;
            }
        }

        if (posicion < texto.length()) {
            insertarTextoColoreado(doc, texto.substring(posicion), null);
        }
    }

      private AttributeSet obtenerAtributosToken(Token token, DiccionarioColor diccionarioColor) {
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        Color color = diccionarioColor.getColorForToken(token.getTipo());
        StyleConstants.setForeground(attrs, color);
        return attrs;
    }

    private void insertarTextoColoreado(StyledDocument doc, String texto, AttributeSet attrs) {
        try {
            doc.insertString(doc.getLength(), texto, attrs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
