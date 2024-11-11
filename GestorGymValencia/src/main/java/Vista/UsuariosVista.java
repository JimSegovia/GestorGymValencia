/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UsuariosVista extends javax.swing.JPanel {
    private List<Object[]> todosClientes = new ArrayList<>();
    
    public UsuariosVista() {
        initComponents();
        cargarClientesDesdeArchivo();

        BotonAñadirUsuarios.setContentAreaFilled(false);
        BotonRenovarUsuarios.setContentAreaFilled(false);
        
        Buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarClientes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarClientes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarClientes();
            }
        });
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonAsistencia = new javax.swing.JButton();
        BotonUsuarios = new javax.swing.JButton();
        BotonTrabajadores = new javax.swing.JButton();
        BotonInicio = new javax.swing.JButton();
        BotonInventario = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        BotonAñadirUsuarios = new javax.swing.JButton();
        Buscador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        BotonRenovarUsuarios = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1140, 640));

        jPanel1.setBackground(new java.awt.Color(49, 64, 81));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoNombre.png"))); // NOI18N

        BotonAsistencia.setBackground(new java.awt.Color(49, 64, 81));
        BotonAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        BotonAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Asistance.png"))); // NOI18N
        BotonAsistencia.setText("Asistencia");
        BotonAsistencia.setFocusPainted(false);
        BotonAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAsistenciaActionPerformed(evt);
            }
        });

        BotonUsuarios.setBackground(new java.awt.Color(41, 56, 70));
        BotonUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        BotonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Users.png"))); // NOI18N
        BotonUsuarios.setText("Usuarios");
        BotonUsuarios.setFocusPainted(false);
        BotonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuariosActionPerformed(evt);
            }
        });

        BotonTrabajadores.setBackground(new java.awt.Color(49, 64, 81));
        BotonTrabajadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonTrabajadores.setForeground(new java.awt.Color(255, 255, 255));
        BotonTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Workers.png"))); // NOI18N
        BotonTrabajadores.setText("Trabajadores");
        BotonTrabajadores.setFocusPainted(false);
        BotonTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTrabajadoresActionPerformed(evt);
            }
        });

        BotonInicio.setBackground(new java.awt.Color(49, 64, 81));
        BotonInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonInicio.setForeground(new java.awt.Color(255, 255, 255));
        BotonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home.png"))); // NOI18N
        BotonInicio.setText("Inicio");
        BotonInicio.setFocusPainted(false);

        BotonInventario.setBackground(new java.awt.Color(49, 64, 81));
        BotonInventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonInventario.setForeground(new java.awt.Color(255, 255, 255));
        BotonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Workers.png"))); // NOI18N
        BotonInventario.setText("Inventario");
        BotonInventario.setFocusPainted(false);
        BotonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(BotonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BotonAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(BotonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(BotonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(247, 247, 247)
                    .addComponent(BotonAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(333, Short.MAX_VALUE)))
        );

        lblUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblUsuarios.setText("Usuarios del Gimnasio");

        BotonAñadirUsuarios.setText("AÑADIR USUARIOS");
        BotonAñadirUsuarios.setFocusPainted(false);
        BotonAñadirUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAñadirUsuariosActionPerformed(evt);
            }
        });

        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });

        jLabel2.setText("BUSCAR USUARIO POR DNI");

        TablaClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Inicio", "Fin", "Tipo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.setShowVerticalLines(true);
        TablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaClientes);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
            TablaClientes.getColumnModel().getColumn(4).setResizable(false);
            TablaClientes.getColumnModel().getColumn(5).setResizable(false);
            TablaClientes.getColumnModel().getColumn(6).setResizable(false);
        }

        BotonRenovarUsuarios.setText("RENOVAR USUARIOS");
        BotonRenovarUsuarios.setFocusPainted(false);
        BotonRenovarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRenovarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuarios)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonAñadirUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonRenovarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscador))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUsuarios)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAñadirUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BotonRenovarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void cargarClientesDesdeArchivo() {
        String archivoClientes = "src/main/resources/Files/Clientes.txt";
        DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("es-ES"));
        Date fechaActual = new Date();
        todosClientes.clear(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 6) continue;

                String dni = datos[0].trim();
                String nombres = datos[1].trim();
                String apellidos = datos[2].trim();
                Date inicioMembresia = sdf.parse(datos[3].trim());
                Date finMembresia = sdf.parse(datos[4].trim());
                String tipoMembresia = datos[5].trim();
                String estado = finMembresia.after(fechaActual) ? "Activo" : "Inactivo";

                Object[] fila = new Object[]{dni, nombres, apellidos, 
                                             sdf.format(inicioMembresia), 
                                             sdf.format(finMembresia), 
                                             tipoMembresia, estado};

                todosClientes.add(fila); 
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        filtrarClientes();

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

    for (int i = 0; i < TablaClientes.getColumnCount(); i++) {
        TablaClientes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    
    TablaClientes.setRowHeight(25);
    TablaClientes.getColumnModel().getColumn(6).setCellRenderer(new EstadoCellRenderer());
}

    private void filtrarClientes() {
        String textoBusqueda = Buscador.getText().trim().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
        model.setRowCount(0); 
        
        List<Object[]> filasActivas = new ArrayList<>();
        List<Object[]> filasInactivas = new ArrayList<>();

        for (Object[] fila : todosClientes) {
            String dni = ((String) fila[0]).toLowerCase();
            if (dni.startsWith(textoBusqueda)) {
                if ("Activo".equals(fila[6])) {
                    filasActivas.add(fila);
                } else {
                    filasInactivas.add(fila);
                }
            }
        }
        
        for (Object[] fila : filasActivas) {
            model.addRow(fila);
        }
        for (Object[] fila : filasInactivas) {
            model.addRow(fila);
        }
    }
    
        private class EstadoCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if ("Activo".equals(value)) {
                c.setBackground(new Color(189, 231, 189));
                c.setForeground(Color.BLACK);
            } else if ("Inactivo".equals(value)) {
                c.setBackground(new Color(255, 182, 179));
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            }

            return c;
        }
    }
    
    private void BotonAñadirUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAñadirUsuariosActionPerformed
    JDialog dialog = new JDialog();
    dialog.setTitle("Añadir Usuario");
    dialog.setModal(true);
    dialog.setSize(500, 400);
    dialog.setResizable(false);
    dialog.setLocationRelativeTo(this);
    
    AñadirUsuariosMenu añadirUsuariosMenu = new AñadirUsuariosMenu(dialog);
    dialog.setContentPane(añadirUsuariosMenu);
    
    dialog.setVisible(true);
    
    if (añadirUsuariosMenu.seAgregoNuevoUsuario()) {
        cargarClientesDesdeArchivo();
    }
    }//GEN-LAST:event_BotonAñadirUsuariosActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed

    }//GEN-LAST:event_BuscadorActionPerformed

    private void BotonRenovarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRenovarUsuariosActionPerformed
    JDialog dialog = new JDialog();
    dialog.setTitle("Renovar Usuario");
    dialog.setModal(true);
    dialog.setSize(500, 400);
    dialog.setResizable(false);
    dialog.setLocationRelativeTo(this);

    RenovarUsuariosMenu renovarUsuariosMenu = new RenovarUsuariosMenu(dialog);
    dialog.setContentPane(renovarUsuariosMenu);
    
    dialog.setVisible(true);
    
    if (renovarUsuariosMenu.seRenovoUsuario()) {
        cargarClientesDesdeArchivo();
    }
    }//GEN-LAST:event_BotonRenovarUsuariosActionPerformed

    private void BotonAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAsistenciaActionPerformed

    private void BotonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonUsuariosActionPerformed

    private void BotonTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTrabajadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonTrabajadoresActionPerformed

    private void BotonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAsistencia;
    public javax.swing.JButton BotonAñadirUsuarios;
    public javax.swing.JButton BotonInicio;
    public javax.swing.JButton BotonInventario;
    public javax.swing.JButton BotonRenovarUsuarios;
    public javax.swing.JButton BotonTrabajadores;
    public javax.swing.JButton BotonUsuarios;
    protected javax.swing.JTextField Buscador;
    public javax.swing.JTable TablaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
