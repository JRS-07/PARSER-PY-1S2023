/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;


/**
 *
 * @author jerson
 */
public class Archivo {

     private ArrayList<String> listaLineasArchivo = new ArrayList();
    
    public Archivo(File archivo){
        this.listarLineasArchivo(archivo);
    }
    
    public Archivo(){
        
    }

    /**
     * Lista las de un archivo.
     * @param archivo 
     */
    private void listarLineasArchivo(File archivo) {

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
                listaLineasArchivo.add(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
    }

    /**
     * Muestra en JTextArea indicado, las lineas de un archivo.
     * @param taCodigoFuente 
     */
    public void mostrarLineas(JTextArea taCodigoFuente) {
        taCodigoFuente.setText("");
        for (String linea : listaLineasArchivo) {
            taCodigoFuente.append(linea+"\n");
        }
    }
}
