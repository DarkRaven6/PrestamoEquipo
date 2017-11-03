/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemas;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.*;

/**
 *
 * @author herned1
 */
public class MostrarRegistros extends javax.swing.JFrame {

    public static DefaultTableModel modeloTabla;

    public MostrarRegistros() {
        modeloTabla = new DefaultTableModel(null, getColumnas());

        initComponents();
        Conexion.conexion();
        Conexion.setFilas(modeloTabla);
        this.setTitle("Tabla de prestamos");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500, 400);
    }

    private String[] getColumnas() {

        String columna[] = new String[]{"Nombre", "Material", "Fecha"};
        return columna;

    }

//    private void insertarFinal(int fila) {
//
//        //int ultimo = tableDatos.getRowCount()-1;
//        Connection c = Conexion.con;
//        java.util.Date fecha = new java.util.Date();
//        DateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
//
//        String convert = formatoFechaHora.format(fecha);
//        //String sql = "insert into reportefinal values ('" + obtenerContenido(ultimo, 0) + "','" + obtenerContenido(ultimo, 1) + "','" + obtenerContenido(ultimo, 2) + "','" + convert + "')";
//        String sql = "insert into reportefinal values ('";
//        try {
//            PreparedStatement us = c.prepareStatement(sql);
//            us.executeUpdate();
//        } catch (Exception e) {
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableDatos.setModel(modeloTabla);
        tableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDatosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDatosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDatos);

        jButton2.setText("Ir a inicio");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        Principal p = new Principal();
        p.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void tableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDatosMouseClicked

        modeloTabla = (DefaultTableModel) tableDatos.getModel();
        Connection c = Conexion.con;
        java.util.Date fecha = new java.util.Date();
        DateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
        String convert = formatoFechaHora.format(fecha);
        String sql = "insert into reportefinal values ('" + tableDatos.getValueAt(tableDatos.getSelectedRow(), 0)
                + "','" + tableDatos.getValueAt(tableDatos.getSelectedRow(), 1)
                + "','" + tableDatos.getValueAt(tableDatos.getSelectedRow(), 2)
                + "','" + convert + "')";
        try {
            PreparedStatement us = c.prepareStatement(sql);
            us.executeUpdate();
        } catch (Exception e) {
        }
        modeloTabla.removeRow(tableDatos.getSelectedRow());
        
//        String sqldelete = "delete from reporteprestamo where fecha = '" + tableDatos.getValueAt(tableDatos.getSelectedRow(), 2)+"'";
//        try {
//            PreparedStatement us = c.prepareStatement(sqldelete);
//            us.executeUpdate();
//        } catch (Exception e) {
//        }


    }//GEN-LAST:event_tableDatosMouseClicked

    private void tableDatosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDatosMouseReleased
        
        Connection co = Conexion.con;
                String sqldelete = "delete from reporteprestamo where fecha = '" + tableDatos.getValueAt(tableDatos.getSelectedRow(), 2)+"'";
        try {
            PreparedStatement us = co.prepareStatement(sqldelete);
            us.executeUpdate();
        } catch (Exception e) {
        }
        
        System.out.println(tableDatos.getValueAt(tableDatos.getSelectedRow(), 2));


    }//GEN-LAST:event_tableDatosMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDatos;
    // End of variables declaration//GEN-END:variables

//    private String obtenerContenido(int fila, int columna) {
//
//        Object palabraOB = tableDatos.getValueAt(fila, columna);
//        String palabra = "";
//        if (palabra != null) {
//            palabra = palabraOB.toString();
//        }
//        return palabra;
//
//    }

}
