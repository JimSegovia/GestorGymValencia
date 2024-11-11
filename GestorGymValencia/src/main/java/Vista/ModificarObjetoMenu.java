/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
    
import Modelo.ListaObjetos;
import Modelo.Objeto;

import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ModificarObjetoMenu extends javax.swing.JPanel {

    private final JDialog dialog;
    private ListaObjetos listaObjetos;
    private Objeto objetoActual;
    
    private boolean objetoModificado = false;

    public boolean seModificoObjeto() {
        return objetoModificado;
    }

    public ModificarObjetoMenu(JDialog dialog) {
        this.dialog = dialog;
        this.listaObjetos = new ListaObjetos();
        initComponents();
        addListeners();
    }

    private void addListeners() {
        escribirNSerie.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarObjetoPorNSerie();
            }
        });
        Renovar.setText("Modificar");
        Renovar.addActionListener(e -> modificarObjeto());
        EliminarElemento.addActionListener(e -> eliminarObjeto());
        cancelar.addActionListener(e -> {
            if (dialog != null) dialog.dispose();
        });
    }
    
    private void buscarObjetoPorNSerie() {
        String nSerie = escribirNSerie.getText().trim();
        objetoActual = listaObjetos.buscarPorId(nSerie);

        if (objetoActual != null) {
            Nombre.setText(objetoActual.getNombre());
            TipoObjeto.setText(objetoActual.getTipo());
            EstadoObjeto.setText(objetoActual.getEstado());
            EstadoObjeto1.setText(objetoActual.getEstado());

            EstadoDeObjeto.setSelectedItem(objetoActual.getEstado());
        } else {
            Nombre.setText("----");
            TipoObjeto.setText("----");
            EstadoObjeto.setText("----");
            EstadoDeObjeto.setSelectedIndex(0);
            EstadoObjeto1.setText("----");
        }
    }
    
    private void modificarObjeto() {
        if (objetoActual != null) {
            objetoActual.setNombre(Nombre.getText().trim());
            objetoActual.setTipo(TipoObjeto.getText().trim());
            objetoActual.setEstado((String) EstadoDeObjeto.getSelectedItem());

            listaObjetos.guardarObjetosEnArchivo();
            JOptionPane.showMessageDialog(this, "El objeto se ha modificado correctamente.", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se ha encontrado el objeto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        objetoModificado = true;
    }
    
   private void eliminarObjeto() {
        if (objetoActual != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este objeto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listaObjetos.eliminarPorId(objetoActual.getId());
                listaObjetos.guardarObjetosEnArchivo();
                JOptionPane.showMessageDialog(this, "El objeto ha sido eliminado.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha encontrado el objeto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        objetoModificado = true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FechaFinal3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        escribirNSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Renovar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        TipoObjeto = new javax.swing.JLabel();
        EstadoObjeto = new javax.swing.JLabel();
        EliminarElemento = new javax.swing.JButton();
        EstadoObjeto1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EstadoDeObjeto = new javax.swing.JComboBox<>();

        FechaFinal3.setText("----");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("N.Serie");

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarios.setText("Modificar Elemento");

        escribirNSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirNSerieActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        Renovar.setText("Modificar");
        Renovar.setFocusPainted(false);

        cancelar.setBackground(new java.awt.Color(255, 204, 204));
        cancelar.setText("Cancelar");
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Estado:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tipo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Cambios a realizar:");

        Nombre.setText("----");

        TipoObjeto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TipoObjeto.setText("----");

        EstadoObjeto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EstadoObjeto.setText("----");

        EliminarElemento.setBackground(new java.awt.Color(255, 204, 204));
        EliminarElemento.setText("Eliminar Elemento");
        EliminarElemento.setFocusPainted(false);
        EliminarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarElementoActionPerformed(evt);
            }
        });

        EstadoObjeto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EstadoObjeto1.setText("----");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Estado:");

        EstadoDeObjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "En Mantenimiento", "En Desuso" }));
        EstadoDeObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoDeObjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(escribirNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(EliminarElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(EstadoObjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(EstadoDeObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Renovar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(13, 13, 13)
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(EstadoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(76, 76, 76))))))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(escribirNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarElemento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(TipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstadoObjeto))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(EstadoObjeto1)
                        .addComponent(EstadoDeObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Renovar)
                    .addComponent(cancelar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void escribirNSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirNSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escribirNSerieActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
    if (dialog != null) {
        dialog.dispose(); 
    }
    }//GEN-LAST:event_cancelarActionPerformed

    private void EliminarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarElementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarElementoActionPerformed

    private void EstadoDeObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoDeObjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoDeObjetoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton EliminarElemento;
    public javax.swing.JComboBox<String> EstadoDeObjeto;
    public javax.swing.JLabel EstadoObjeto;
    public javax.swing.JLabel EstadoObjeto1;
    public javax.swing.JLabel FechaFinal3;
    public javax.swing.JLabel Nombre;
    public javax.swing.JButton Renovar;
    public javax.swing.JLabel TipoObjeto;
    public javax.swing.JButton cancelar;
    public javax.swing.JTextField escribirNSerie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
