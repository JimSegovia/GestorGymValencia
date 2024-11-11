/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InventarioVista extends javax.swing.JPanel {
    private List<Object[]> todosObjetos = new ArrayList<>();

    public InventarioVista() {
        initComponents();
        cargarObjetosDesdeArchivo();
        BotonAñadirObjeto.setContentAreaFilled(false);
        BotonModificarObjeto.setContentAreaFilled(false);

        Buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarObjetos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarObjetos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarObjetos();
            }
        });
        
        ComboboxTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarObjetos();
            }
        });
    }

    private void cargarObjetosDesdeArchivo() {
        String archivoObjetos = "src/main/resources/Files/Objetos.txt";
        DefaultTableModel model = (DefaultTableModel) TablaObjetos.getModel();
        model.setRowCount(0);
        
        todosObjetos.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoObjetos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 4) continue;

                String id = datos[0].trim();
                String nombre = datos[1].trim();
                String tipo = datos[2].trim();
                String estado = datos[3].trim();

                Object[] fila = new Object[]{id, nombre, tipo, estado};
                todosObjetos.add(fila);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        filtrarObjetos();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < TablaObjetos.getColumnCount(); i++) {
            TablaObjetos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        TablaObjetos.setRowHeight(25);
        TablaObjetos.getColumnModel().getColumn(3).setCellRenderer(new EstadoCellRenderer());
    }
    
    private void filtrarObjetos() {
    String textoBusqueda = Buscador.getText().trim().toLowerCase();
    String tipoSeleccionado = (String) ComboboxTipo.getSelectedItem();
    DefaultTableModel model = (DefaultTableModel) TablaObjetos.getModel();
    model.setRowCount(0); 
    
    List<Object[]> filasActivas = new ArrayList<>();
    List<Object[]> filasMantenimiento = new ArrayList<>();
    List<Object[]> filasDesuso = new ArrayList<>();

    for (Object[] fila : todosObjetos) {
        String id = ((String) fila[0]).toLowerCase();
        String tipo = (String) fila[2];

        boolean coincideTexto = id.startsWith(textoBusqueda);
        boolean coincideTipo = tipoSeleccionado.equals("Todos") || tipo.equals(tipoSeleccionado);

        if (coincideTexto && coincideTipo) {
            String estado = (String) fila[3];
            if ("Activo".equals(estado)) {
                filasActivas.add(fila);
            } else if ("En Mantenimiento".equals(estado)) {
                filasMantenimiento.add(fila);
            } else if ("En Desuso".equals(estado)) {
                filasDesuso.add(fila);
            }
        }
    }

    for (Object[] fila : filasActivas) {
        model.addRow(fila);
    }
    for (Object[] fila : filasMantenimiento) {
        model.addRow(fila);
    }
    for (Object[] fila : filasDesuso) {
        model.addRow(fila);}
    }

     private class EstadoCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if ("Activo".equals(value)) {
                c.setBackground(new Color(189, 231, 189));
                c.setForeground(Color.BLACK);
            } else if ("En Mantenimiento".equals(value)) {
                c.setBackground(new Color(255, 255, 204));
                c.setForeground(Color.BLACK);
            } else if ("En Desuso".equals(value)) {
                c.setBackground(new Color(255, 182, 179));
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            }

            return c;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonAsistencia = new javax.swing.JButton();
        BotonUsuarios = new javax.swing.JButton();
        BotonTrabajadores = new javax.swing.JButton();
        BotonInicio = new javax.swing.JButton();
        BotonInventario = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaObjetos = new javax.swing.JTable();
        BotonModificarObjeto = new javax.swing.JButton();
        BotonAñadirObjeto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Buscador = new javax.swing.JTextField();
        ComboboxTipo = new javax.swing.JComboBox<>();

        jButton2.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(1140, 640));

        jPanel1.setBackground(new java.awt.Color(49, 64, 81));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoNombre.png"))); // NOI18N

        BotonAsistencia.setBackground(new java.awt.Color(49, 64, 81));
        BotonAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        BotonAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Asistance.png"))); // NOI18N
        BotonAsistencia.setText("Asistencia");
        BotonAsistencia.setFocusPainted(false);

        BotonUsuarios.setBackground(new java.awt.Color(49, 64, 81));
        BotonUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        BotonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Users.png"))); // NOI18N
        BotonUsuarios.setText("Usuarios");
        BotonUsuarios.setFocusPainted(false);

        BotonTrabajadores.setBackground(new java.awt.Color(49, 64, 81));
        BotonTrabajadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonTrabajadores.setForeground(new java.awt.Color(255, 255, 255));
        BotonTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Workers.png"))); // NOI18N
        BotonTrabajadores.setText("Trabajadores");
        BotonTrabajadores.setFocusPainted(false);

        BotonInicio.setBackground(new java.awt.Color(49, 64, 81));
        BotonInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotonInicio.setForeground(new java.awt.Color(255, 255, 255));
        BotonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home.png"))); // NOI18N
        BotonInicio.setText("Inicio");
        BotonInicio.setFocusPainted(false);

        BotonInventario.setBackground(new java.awt.Color(41, 56, 70));
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
        lblUsuarios.setText("Inventario del Gimnasio");

        TablaObjetos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TablaObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N. Serie", "Nombre", "Tipo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaObjetos.setShowVerticalLines(true);
        TablaObjetos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaObjetos);

        BotonModificarObjeto.setText("MODIFICAR");
        BotonModificarObjeto.setFocusPainted(false);
        BotonModificarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarObjetoActionPerformed(evt);
            }
        });

        BotonAñadirObjeto.setText("AÑADIR OBJETO");
        BotonAñadirObjeto.setFocusPainted(false);
        BotonAñadirObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAñadirObjetoActionPerformed(evt);
            }
        });

        jLabel2.setText("BUSCAR POR N.SERIE");

        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });

        ComboboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Máquina", "Disco", "Mancuerna" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonAñadirObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonModificarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(ComboboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblUsuarios))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboboxTipo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonAñadirObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(BotonModificarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonInventarioActionPerformed

    private void BotonModificarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarObjetoActionPerformed
        JDialog dialog = new JDialog();
        dialog.setTitle("Modificar Objeto");
        dialog.setModal(true);
        dialog.setSize(500, 400);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);

        ModificarObjetoMenu modificarObjetoMenu = new ModificarObjetoMenu(dialog);
        dialog.setContentPane(modificarObjetoMenu);

        dialog.setVisible(true);

        if (modificarObjetoMenu.seModificoObjeto()) {
            cargarObjetosDesdeArchivo();
        }
    }//GEN-LAST:event_BotonModificarObjetoActionPerformed

    private void BotonAñadirObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAñadirObjetoActionPerformed
        JDialog dialog = new JDialog();
        dialog.setTitle("Añadir Objeto");
        dialog.setModal(true);
        dialog.setSize(500, 400);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);

        AñadirObjetoMenu añadirObjetoMenu = new AñadirObjetoMenu(dialog);
        dialog.setContentPane(añadirObjetoMenu);

        dialog.setVisible(true);

        if (añadirObjetoMenu.seAgregoNuevoObjeto()) {
            cargarObjetosDesdeArchivo();
        }
    }//GEN-LAST:event_BotonAñadirObjetoActionPerformed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAsistencia;
    public javax.swing.JButton BotonAñadirObjeto;
    public javax.swing.JButton BotonInicio;
    public javax.swing.JButton BotonInventario;
    public javax.swing.JButton BotonModificarObjeto;
    public javax.swing.JButton BotonTrabajadores;
    public javax.swing.JButton BotonUsuarios;
    protected javax.swing.JTextField Buscador;
    public javax.swing.JComboBox<String> ComboboxTipo;
    public javax.swing.JTable TablaObjetos;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
