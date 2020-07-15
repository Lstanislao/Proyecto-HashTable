/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import HashTable.Archivo;
import HashTable.Central;
import HashTable.HashTableResumen;
import Listas.Lista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    String nombreDelArchivoTxtSeleccionado = "";

    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        boolean iniciado = Central.isIniciado();
        if (!iniciado) {
            Central.CargarResumenes();
            Central.setIniciado(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        jButton1.setText("AGREGAR ARCHIVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 240, 40));

        jButton2.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        jButton2.setText("ANALIZAR ARCHIVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 240, 40));

        jButton3.setFont(new java.awt.Font("AppleGothic", 0, 16)); // NOI18N
        jButton3.setText("BUSCAR INVESTIGACIONES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 240, 40));

        jButtonGuardar.setFont(new java.awt.Font("AppleGothic", 0, 13)); // NOI18N
        jButtonGuardar.setText("GUARDAR Y SALIR");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 160, 30));

        jLabel2.setFont(new java.awt.Font("AppleGothic", 1, 20)); // NOI18N
        jLabel2.setText("ANALIZADOR DE RESUMENES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_mas.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 70, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_lupa.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_docum.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jButton4.setFont(new java.awt.Font("AppleGothic", 0, 13)); // NOI18N
        jButton4.setText("INSTRUCCIONES");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 160, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verde.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AnalizarArchivo a = new AnalizarArchivo(Central.getTitulosResumenes());
        a.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*  
        Boton Agregar Archivo de Datos: Permite seleccionar un archivo ".txt" del
        ordenador para su utilizacion en el sistema. Este archivo de datos es 
        leido por el sistema para asegurarse que cumpla con el formato adecuado.
        De lo contrario aparecerá un mensaje indicando cual debe ser el formato.
         */

        JOptionPane.showMessageDialog(null, "Es importante que el archivo seleccionado "
                + "se encuentre en la carpeta del proyecto.");

        // Se verifica que el archivo sea un archivo de texto
        if (seleccionado.showDialog(this, "CARGAR ARCHIVO") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    nombreDelArchivoTxtSeleccionado = archivo.getName();

                } else {
                    JOptionPane.showMessageDialog(null, "Error. Por favor seleccione un archivo de texto (.txt)");
                }
            }

        }

        /*Se intenta agregar el nuevo resumen, si ya se encontraba en guardado, 
        se muestra un mensaje de aviso*/
        if (!nombreDelArchivoTxtSeleccionado.equals("")) {
            Lista aux = Central.getNombresResumenes();

            if (Archivo.VerificarFormatoArchivo(archivo)) {
                boolean seAgrego = Archivo.LeerArchivo(archivo);
                if (seAgrego) {
                    aux.InsertarFinal(nombreDelArchivoTxtSeleccionado);
                    Central.setNombresResumenes(aux);
                    JOptionPane.showMessageDialog(null, "La investigación ha sido agregada correctamente.");

                }

            } else {
                String mensaje = "El formato del archivo seleccionado no es válido.\n"
                        + "El formato del archivo debe ser:\n\n"
                        + "Titulo\n\nAutores\nAutor1\n...[mas autores]...\nAutorN\n"
                        + "\nResumen\n...[cuerpo del resumen]...\n\nPalabras claves:"
                        + "palabra1, palabra2, ...[más palabras]..., palabraN.";
                JOptionPane.showMessageDialog(null, mensaje);
            }

        }
        ;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BuscarInvestigacion a = new BuscarInvestigacion();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        /* 
        Boton de Guardar y salir: Se guardan todos los txt cargados en el 
        repositorio en el archivo por defecto y finaliza la ejecucion del programa.
         */

        System.out.println(Central.getNombresResumenes().ListaResumenes());
        Central.GuardarResumenesCargados();

        System.exit(0);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Muestra las instrucciones sobre el uso del programa
        Instrucciones a = new Instrucciones();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
