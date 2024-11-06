/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.ListaClientes;
import Modelo.Cliente;    

import javax.swing.JDialog;
import java.util.Locale;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class AñadirUsuariosMenu extends javax.swing.JPanel {

    private final JDialog dialog; 
    private ListaClientes listaClientes;
    private boolean usuarioAgregado = false;

    public boolean seAgregoNuevoUsuario() {
        return usuarioAgregado;
}

    public AñadirUsuariosMenu(JDialog dialog) {

        this.dialog = dialog;
        this.listaClientes = new ListaClientes();
        initComponents(); 
        jDateChooser1.setLocale(Locale.of("es", "ES"));
        addListeners();

        jDateChooser1 = new JDateChooser();

        add(jDateChooser1);
        }

    private void addListeners() {
    TipoDeMembersia.addActionListener(e -> updateEndDate());
        
    jDateChooser1.addPropertyChangeListener("date", evt -> {
            Date selectedDate = (Date) evt.getNewValue();
            if (selectedDate != null) {
                jDateChooser1.setDate(selectedDate); 
                updateEndDate();
            }
        }); 
    
    Añadir.addActionListener(e -> registrarCliente());
 
    }
    private void updateEndDate() {
        Date startDate = jDateChooser1.getDate();
        if (startDate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            String membershipType = (String) TipoDeMembersia.getSelectedItem();
            switch (membershipType) {
                case "Mensual":
                    calendar.add(Calendar.MONTH, 1); 
                    break;
                case "Trimestral":
                    calendar.add(Calendar.MONTH, 3); 
                    break;
                case "Semestral":
                    calendar.add(Calendar.MONTH, 6); 
                    break;
                case "Anual":
                    calendar.add(Calendar.YEAR, 1); 
                    break;
            }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));
        FechaFinal.setText(sdf.format(calendar.getTime()));
        }
    }
    
    private void registrarCliente() {
        String dni = escribirDNI.getText();
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe contener exactamente 8 números.", "DNI Inválido", JOptionPane.ERROR_MESSAGE);
            escribirDNI.setText("");
            return;
        }
        String nombres = escribirNombre.getText();
        String apellidos = escribirApellido.getText();
        Date inicioMembresia = jDateChooser1.getDate();
        String tipoMembresia = (String) TipoDeMembersia.getSelectedItem();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));
        Date finMembresia = null;
        try {
            finMembresia = sdf.parse(FechaFinal.getText());
        } catch (ParseException ex) {
            System.out.println("Error al parsear la fecha de fin: " + ex.getMessage());
        }

        Cliente nuevoCliente = new Cliente(dni, nombres, apellidos, inicioMembresia, finMembresia, tipoMembresia);
        listaClientes.agregarCliente(nuevoCliente);
        
        usuarioAgregado = true;
        dialog.dispose();
        imprimirListaClientes();
        JOptionPane.showMessageDialog(this, "El cliente se añadió correctamente.", "Se agregó correctamente", JOptionPane.INFORMATION_MESSAGE );
    }

    private void imprimirListaClientes() {
        System.out.println("Lista de Clientes:");
        listaClientes.imprimirClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        escribirDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        escribirNombre = new javax.swing.JTextField();
        escribirApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Añadir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        TipoDeMembersia = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        FechaFinal = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarios.setText("Agregar Miembro");

        escribirDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirDNIActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Inicio de membersía");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo de membersía");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Fin de membersía");

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

        TipoDeMembersia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensual", "Trimestral", "Semestral", "Anual" }));
        TipoDeMembersia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoDeMembersiaActionPerformed(evt);
            }
        });

        FechaFinal.setText("----");

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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TipoDeMembersia, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(185, 185, 185))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(escribirApellido))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(escribirDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                            .addComponent(escribirNombre))))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(escribirDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(escribirNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(escribirApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TipoDeMembersia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(FechaFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Añadir)
                    .addComponent(cancelar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void escribirDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escribirDNIActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
    if (dialog != null) { // Verifica que el diálogo no sea nulo
        dialog.dispose(); // Cierra el diálogo
    }
    }//GEN-LAST:event_cancelarActionPerformed

    private void TipoDeMembersiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoDeMembersiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDeMembersiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Añadir;
    public javax.swing.JLabel FechaFinal;
    public javax.swing.JComboBox<String> TipoDeMembersia;
    public javax.swing.JButton cancelar;
    public javax.swing.JTextField escribirApellido;
    public javax.swing.JTextField escribirDNI;
    public javax.swing.JTextField escribirNombre;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
