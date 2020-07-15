/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import HashTable.Central;
import HashTable.HashTableResumen;
import HashTable.Resumen;
import Listas.Lista;
import Listas.Nodo;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author sosag
 */
public class AnalizarArchivo extends javax.swing.JFrame {

    DefaultListModel lista = new DefaultListModel();

    public AnalizarArchivo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public AnalizarArchivo(Lista nombres) {
        initComponents();
        this.setLocationRelativeTo(null);
        String string = ListaAString(nombres);
        agregarResumen(string);
    }

    private String ListaAString(Lista lista) {
        Nodo aux = lista.getpFirst();
        String cadena = "";
        while (aux != null) {
            cadena += aux.getDato() + ",";
            aux = aux.getPnext();
        }
        return cadena;
    }

    /*
    Funcion para ordenar los titulos de las investigaciones del repositorio
    por orden alfabetico y mostrarselos al usuario para que pueda seleccionar uno.
     */
    private void agregarResumen(String resumenes) {

        listaResumen.setModel(lista);
        String[] resumen = resumenes.split(",");
        for (int i = 0; i < resumen.length; i++) {
            for (int j = 0; j < resumen.length && i != j; j++) {
                if (resumen[i].compareToIgnoreCase(resumen[j]) < 0) {
                    String aux = resumen[i];
                    resumen[i] = resumen[j];
                    resumen[j] = aux;
                }
            }
        }

        for (int i = 0; i < resumen.length; i++) {
            lista.addElement(resumen[i]);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        listaResumen = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaResumen.setFont(new java.awt.Font("AppleGothic", 1, 13)); // NOI18N
        jScrollPane2.setViewportView(listaResumen);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 540, 80));

        pantalla.setEditable(false);
        pantalla.setColumns(20);
        pantalla.setFont(new java.awt.Font("AppleGothic", 0, 14)); // NOI18N
        pantalla.setRows(5);
        pantalla.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane1.setViewportView(pantalla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 620, 260));

        jButton3.setFont(new java.awt.Font("AppleGothic", 0, 13)); // NOI18N
        jButton3.setText("ANALIZAR ARCHIVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 40));

        jLabel2.setText("Seleccione un archivo para analizar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jButtonMenu.setFont(new java.awt.Font("AppleGothic", 0, 13)); // NOI18N
        jButtonMenu.setText("MENU PRINCIPAL");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 220, 40));

        jButtonGuardar.setFont(new java.awt.Font("AppleGothic", 0, 13)); // NOI18N
        jButtonGuardar.setText("GUARDAR Y SALIR");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 220, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/_lupa.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel3.setFont(new java.awt.Font("AppleGothic", 1, 18)); // NOI18N
        jLabel3.setText("ANALIZAR ARCHIVO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 230, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verde.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("El resumen es: " + listaResumen.getSelectedValue());

        HashTableResumen resumenes = Central.getResumenes();
        String titulo = listaResumen.getSelectedValue();
        if (titulo != null) {
            Resumen resumenActual = resumenes.BuscarResumen(titulo);
            pantalla.setText(resumenActual.Estadisticas());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una investigación.");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        Interfaz a = new Interfaz();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // GUARDAR

        System.exit(0);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AnalizarArchivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalizarArchivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalizarArchivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalizarArchivo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalizarArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaResumen;
    private javax.swing.JTextArea pantalla;
    // End of variables declaration//GEN-END:variables

}
