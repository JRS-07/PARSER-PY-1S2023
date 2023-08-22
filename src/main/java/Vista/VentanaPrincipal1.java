/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import controlador.AnalizadorLexico;
import controlador.Archivo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;
import javax.swing.text.StyleContext;
import modelo.TipoToken;
import modelo.Token;
import javax.swing.text.DefaultStyledDocument;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
/**
 *
 * @author jerson
 */
public class VentanaPrincipal1 extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPricnipal
     */
    private StyledDocument styledDocument;
    
    public VentanaPrincipal1() {
        initComponents();
        
              
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        btnCargarArchivo = new javax.swing.JButton();
        btnGenerarGrafica = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCodigoFuente = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taErrores = new javax.swing.JTextArea();
        lbErrores = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableReportes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));

        lbTitulo.setFont(new java.awt.Font("Inconsolata Semi Condensed ExtraBold", 0, 36)); // NOI18N
        lbTitulo.setText("ANALIZADOR LEXICO");

        btnCargarArchivo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCargarArchivo.setText("Cargar Archivo");
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });

        btnGenerarGrafica.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnGenerarGrafica.setText("Generar Graficos");
        btnGenerarGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarGraficaActionPerformed(evt);
            }
        });

        btnAyuda.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnAcercaDe.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnAcercaDe.setText("Acerca de");
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });

        taCodigoFuente.setColumns(20);
        taCodigoFuente.setRows(5);
        jScrollPane1.setViewportView(taCodigoFuente);

        taErrores.setColumns(20);
        taErrores.setRows(5);
        jScrollPane3.setViewportView(taErrores);

        lbErrores.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        lbErrores.setText("Errores....");

        btnAnalizar.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jTableReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Patron", "Lexema", "Linea", "Columna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableReportes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                            .addComponent(lbErrores))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnCargarArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerarGrafica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        btnAyuda.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String ayudaMensaje = "Esta es una aplicación para analizar código fuente utilizando un analizador léxico.\n"
                            + "1. Carga un archivo de código fuente usando el botón 'Cargar Archivo'.\n"
                            + "2. Presiona 'Analizar' para obtener una tabla de tokens y visualizar errores.\n"
                            + "3. Puedes guardar los resultados y el código fuente con el botón 'Guardar'.";
        JOptionPane.showMessageDialog(null, ayudaMensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
});


    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            Archivo cargarArchivo = new Archivo(archivo);
            cargarArchivo.mostrarLineas(taCodigoFuente);
        }
    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    private void btnGenerarGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarGraficaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarGraficaActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
      
        // Limpia la tabla antes de mostrar nuevos resultados
        DefaultTableModel model = (DefaultTableModel) jTableReportes.getModel();
        model.setRowCount(0);  // Elimina todas las filas

        // Obtiene el código fuente de la caja de texto
        String codigoFuente = taCodigoFuente.getText();

        // instanciamos la clase analizadorLexico
        AnalizadorLexico analizador = new AnalizadorLexico(codigoFuente);
        List<Token> listaTokens = analizador.getTokens();   //obteniendo la lista de tokens
        List<Token> listaErrores = analizador.getErrores();  //obtener la lista de errores

        // Llena la tabla con los tokens analizados
        for (Token token : listaTokens) {
            model.addRow(new Object[]{
                token.getTipo(),
                token.getPatron(),
                token.getLexema(),
                token.getLinea(),
                token.getColumna()
            });
        }

        // Imprime los errores en el TextArea de errores
        for (Token error : listaErrores) {
            taErrores.append("Tipo Token: " + error.getTipo() + " | Patron: " + error.getPatron() + " | Lexema: " + error.getLexema() + " | Linea: " + error.getLinea() + " | Columna: " + error.getColumna() + "\n");

        }
        //*************************************************************************************
        
      
    }//GEN-LAST:event_btnAnalizarActionPerformed

    

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int selection = fileChooser.showSaveDialog(this);

        if (selection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                // Guardar el código fuente
                writer.write("Código fuente:\n");
                writer.write(taCodigoFuente.getText());
                writer.newLine();

                // Guardar la tabla de tokens
                DefaultTableModel model = (DefaultTableModel) jTableReportes.getModel();
                writer.write("Tokens:\n");
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        writer.write(model.getValueAt(row, col) + " | ");
                    }
                    writer.newLine();
                }
                writer.newLine();

                // Guardar los errores
                writer.write("Errores:\n");
                writer.write(taErrores.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // Limpia la tabla
        DefaultTableModel model = (DefaultTableModel) jTableReportes.getModel();
        model.setRowCount(0);  // Elimina todas las filas

        // Limpia el área de errores
        taErrores.setText("");

        // Limpia el área de código fuente
        taCodigoFuente.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        // TODO add your handling code here:
        btnAcercaDe.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String acercaDeMensaje = "Analizador Léxico v1.0\n"
                              + "Desarrollado por [Jerson Estrada]\n"
                              + "Este programa realiza el análisis léxico de código fuente y muestra resultados en una tabla.";
        JOptionPane.showMessageDialog(null, acercaDeMensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }
});

    }//GEN-LAST:event_btnAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JButton btnGenerarGrafica;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableReportes;
    private javax.swing.JLabel lbErrores;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextArea taCodigoFuente;
    private javax.swing.JTextArea taErrores;
    // End of variables declaration//GEN-END:variables

    public JTextArea getTaCodigoFuente() {
        return taCodigoFuente;
        
        
        
    }

    public StyledDocument getStyledDocument() {
        return styledDocument;
    }



}
