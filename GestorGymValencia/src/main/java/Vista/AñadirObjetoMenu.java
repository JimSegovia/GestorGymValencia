/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
  
import Modelo.ListaObjetos;
import Modelo.Objeto;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AñadirObjetoMenu extends javax.swing.JPanel {

    private final JDialog dialog;
    private ListaObjetos listaObjetos;
    private boolean objetoAgregado = false;

    public boolean seAgregoNuevoObjeto() {
        return objetoAgregado;
    }
    public AñadirObjetoMenu(JDialog dialog) {
        this.dialog = dialog;
        this.listaObjetos = new ListaObjetos();
        initComponents();
        addListeners();
    }
    private void addListeners() {
        Añadir.addActionListener(e -> registrarObjeto());
        cancelar.addActionListener(e -> {
            if (dialog != null) dialog.dispose();
        });
    }
    
    private void registrarObjeto() {
        
        String id = escribirNSerie.getText().trim();
        String nombre = escribirNombre.getText().trim();
        String tipo = (String) TipoDeMaquina.getSelectedItem();
        String estado = (String) TipoDeEstado.getSelectedItem();

        if (id.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Objeto nuevoObjeto = new Objeto(id, nombre, tipo, estado);
        listaObjetos.agregarObjeto(nuevoObjeto);

        objetoAgregado = true;
        dialog.dispose();

        JOptionPane.showMessageDialog(this, "El objeto se añadió correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        escribirNSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        escribirNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Añadir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        TipoDeMaquina = new javax.swing.JComboBox<>();
        TipoDeEstado = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("N.Serie");

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarios.setText("Agregar a Inventario");

        escribirNSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirNSerieActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tipo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Estado");

        Añadir.setText("Añadir");
        Añadir.setFocusPainted(false);

        cancelar.setBackground(new java.awt.Color(255, 204, 204));
        cancelar.setText("Cancelar");
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        TipoDeMaquina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Máquina", "Disco", "Mancuerna" }));
        TipoDeMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoDeMaquinaActionPerformed(evt);
            }
        });

        TipoDeEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "En Mantenimiento", "En Desuso" }));
        TipoDeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoDeEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoDeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoDeMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(escribirNSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                .addComponent(escribirNombre)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(lblUsuarios)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(escribirNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(escribirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TipoDeMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TipoDeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Añadir)
                    .addComponent(cancelar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void escribirNSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirNSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escribirNSerieActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
    if (dialog != null) { // Verifica que el diálogo no sea nulo
        dialog.dispose(); // Cierra el diálogo
    }
    }//GEN-LAST:event_cancelarActionPerformed

    private void TipoDeMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoDeMaquinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDeMaquinaActionPerformed

    private void TipoDeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoDeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDeEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Añadir;
    public javax.swing.JComboBox<String> TipoDeEstado;
    public javax.swing.JComboBox<String> TipoDeMaquina;
    public javax.swing.JButton cancelar;
    public javax.swing.JTextField escribirNSerie;
    public javax.swing.JTextField escribirNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
