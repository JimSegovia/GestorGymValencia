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
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class RenovarUsuariosMenu extends javax.swing.JPanel {

    private final JDialog dialog; 
    private ListaClientes listaClientes;
    private boolean usuarioRenovado = false;

    public boolean seRenovoUsuario() {
        return usuarioRenovado;
}

    public RenovarUsuariosMenu(JDialog dialog) {

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
        escribirDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarClientePorDNI();
            }
        });
    
    Renovar.addActionListener(e -> renovarCliente());
 
    }
    
    private void buscarClientePorDNI() {
        String dni = escribirDNI.getText().trim();
        if (dni.length() == 8 && dni.matches("\\d+")) {
            Cliente cliente = listaClientes.buscarPorDNI(dni);

            if (cliente != null) {
                NombreYApellido.setText(cliente.getNombres() + " " + cliente.getApellidos());
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));
                FinUltimaMembersía.setText(sdf.format(cliente.getFinMembresia()));

                Date fechaActual = new Date();
                if (cliente.getFinMembresia().after(fechaActual)) {
                    EstadoMembersía.setText("Activo");
                    EstadoMembersía.setForeground(new Color(0, 128, 0));
                    Renovar.setEnabled(false);
                    jDateChooser1.setEnabled(false);
                    TipoDeMembersia.setEnabled(false);
                } else {
                    EstadoMembersía.setText("Inactivo");
                    EstadoMembersía.setForeground(Color.RED);
                    Renovar.setEnabled(true);
                    jDateChooser1.setEnabled(true);
                    TipoDeMembersia.setEnabled(true);
                }
            } else {
                NombreYApellido.setText("----");
                FinUltimaMembersía.setText("----");
                EstadoMembersía.setText("----");
                Renovar.setEnabled(false); 
                JOptionPane.showMessageDialog(this, "Cliente no encontrado. Verifique el DNI.", "Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
            }
        }
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
    
   private void renovarCliente() {
    String dni = escribirDNI.getText();
    if (!dni.matches("\\d{8}")) { 
        JOptionPane.showMessageDialog(this, "El DNI debe contener exactamente 8 números.", "DNI Inválido", JOptionPane.ERROR_MESSAGE);
        escribirDNI.setText("");
        return;
    }
    Date inicioMembresia = jDateChooser1.getDate();
    String tipoMembresia = (String) TipoDeMembersia.getSelectedItem();

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));
    Date finMembresia = null;
    try {
        finMembresia = sdf.parse(FechaFinal.getText());
    } catch (ParseException ex) {
        System.out.println("Error al parsear la fecha de fin: " + ex.getMessage());
    }

    boolean actualizado = listaClientes.actualizarCliente(dni, inicioMembresia, finMembresia, tipoMembresia);
    
    if (actualizado) {
        dialog.dispose();
        imprimirListaClientes();
        usuarioRenovado = true;
        JOptionPane.showMessageDialog(this, "La membresía se renovó correctamente", "Se Renovó correctamente", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Cliente no encontrado. No se pudo renovar la membresía.", "Error", JOptionPane.ERROR_MESSAGE);
    } 
}

    private void imprimirListaClientes() {
        System.out.println("Lista de Clientes:");
        listaClientes.imprimirClientes(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FechaFinal3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        escribirDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Renovar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        TipoDeMembersia = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        FechaFinal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NombreYApellido = new javax.swing.JLabel();
        EstadoMembersía = new javax.swing.JLabel();
        FinUltimaMembersía = new javax.swing.JLabel();

        FechaFinal3.setText("----");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarios.setText("Renovar Miembro");

        escribirDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirDNIActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombres y Apellidos:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Inicio de membersía");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipo de membersía");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Fin de membersía");

        Renovar.setText("Renovar");
        Renovar.setFocusPainted(false);

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Fin de membersía:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Estado de membersía:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Datos de nueva membersía:");

        NombreYApellido.setText("----");

        EstadoMembersía.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EstadoMembersía.setText("----");

        FinUltimaMembersía.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FinUltimaMembersía.setText("----");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(lblUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Renovar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(TipoDeMembersia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EstadoMembersía, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(201, 201, 201)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FinUltimaMembersía, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(NombreYApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(escribirDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 24, Short.MAX_VALUE))))
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
                    .addComponent(NombreYApellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinUltimaMembersía)
                    .addComponent(EstadoMembersía, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TipoDeMembersia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(FechaFinal)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Renovar)
                    .addComponent(cancelar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void escribirDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escribirDNIActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
    if (dialog != null) { 
        dialog.dispose();
    }
    }//GEN-LAST:event_cancelarActionPerformed

    private void TipoDeMembersiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoDeMembersiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDeMembersiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel EstadoMembersía;
    public javax.swing.JLabel FechaFinal;
    public javax.swing.JLabel FechaFinal3;
    public javax.swing.JLabel FinUltimaMembersía;
    public javax.swing.JLabel NombreYApellido;
    public javax.swing.JButton Renovar;
    public javax.swing.JComboBox<String> TipoDeMembersia;
    public javax.swing.JButton cancelar;
    public javax.swing.JTextField escribirDNI;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
