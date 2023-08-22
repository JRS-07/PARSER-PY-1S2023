/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Vista.VentanaPrincipal1;

import controlador.AnalizadorLexico;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Token;

/**
 *
 * @author jerson
 */
public class test {

    public static void main(String[] args) throws IOException {

        try {
            String codigo = "/home/jerson/Documentos/ejemplo archivo de entrada.txt";

            StringBuilder contenido = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(codigo));
            int caracterActual;
            while ((caracterActual = reader.read()) != -1) {
                contenido.append((char) caracterActual);

            }
            reader.close();

            String code = contenido.toString();
            System.out.println(contenido);
            AnalizadorLexico analizador = new AnalizadorLexico(code);

            List<Token> tokens = analizador.getTokens();

            for (Token token : tokens) {
                System.out.println(token.getReport());
            }
            System.out.println("");
            System.out.println("***************************************");
            System.out.println("");

            List<Token> errores = analizador.getErrores();

            for (Token error : errores) {
                System.out.println(error.getReport());
            }
    //****************************************************************************************        
            VentanaPrincipal1 ventana = new VentanaPrincipal1();
        ventana.setVisible(true);
        String codigoFuente = "/home/jerson/Documentos/ejemplo archivo de entrada.txt";
        analizador.analizarCodigo();
        } catch (FileNotFoundException ex) {

        }

    }
}
