/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemas.Nuevacarpeta.Nuevacarpeta;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugog
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    Fifo fifos = new Fifo();
    Proceso procesof,procesor = new Proceso();
    RoundRobin rr = new RoundRobin();
    Estadisticas es=new Estadisticas();

    public Vista() {
        initComponents();
        setTitle("Simulador de procesos -Equipo 6");

        setLocationRelativeTo(null);
        setResizable(true);
        setBackground(Color.yellow);
        setForeground(Color.red);
    }

    public void Ingresar() { //Ingresar proceso a la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTIngreso.getModel();

        Object[] miTabla = new Object[9];
        miTabla[0] = nombre.getText();
        miTabla[1] = tiempoL.getText();
        miTabla[2] = Duracion.getText();

        procesof = new Proceso(nombre.getText(), Integer.parseInt(tiempoL.getText()), Integer.parseInt(Duracion.getText()), 0);
        fifos.agregarProceso(procesof);
        //rr.agregarProceso(proceso);

        modelo.addRow(miTabla);
        jTIngreso.setModel(modelo);
        Duracion.setText(null);
        nombre.setText(null);
        tiempoL.setText(null);
        //jTFCapturaRafaga.grabFocus();
    }
        public void IngresarRR() { //Ingresar proceso a la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTIngreso.getModel();

        Object[] miTabla = new Object[9];
        miTabla[0] = nombre.getText();
        miTabla[1] = tiempoL.getText();
        miTabla[2] = Duracion.getText();

        procesor= new Proceso(nombre.getText(), Integer.parseInt(tiempoL.getText()), Integer.parseInt(Duracion.getText()), 0);
        //fifos.agregarProceso(procesof);
        rr.agregarProceso(procesor);

        modelo.addRow(miTabla);
        jTIngreso.setModel(modelo);
        Duracion.setText(null);
        nombre.setText(null);
        tiempoL.setText(null);
        //jTFCapturaRafaga.grabFocus();
    }

    // ArrayList<int> pr = new ArrayList<int>();
    public void promedioT() {

        promedioT.setValueAt(fifos.getTiempoTotalRet(), 0, 5);
        promedioT.setValueAt(fifos.getTiempoTotalRes(), 0, 6);
        promedioT.setValueAt(fifos.getTiempoTotalDes(), 0, 7);
        promedioT.setValueAt(fifos.getTiempoTotalPena(), 0, 8);
        promedioT.setValueAt(fifos.getTiempoTotalES(), 0, 9);

        promedioT.setValueAt(fifos.getTiempoTotalRet() / fifos.procesos.size(), 1, 5);
        promedioT.setValueAt(fifos.getTiempoTotalRes() / fifos.procesos.size(), 1, 6);
        promedioT.setValueAt(fifos.getTiempoTotalDes() / fifos.procesos.size(), 1, 7);
        promedioT.setValueAt(fifos.getTiempoTotalPena() / fifos.procesos.size(), 1, 8);
        promedioT.setValueAt(fifos.getTiempoTotalES() / fifos.procesos.size(), 1, 9);

    }
       public void promedioTRR() {

        promedioT.setValueAt(rr.getTiempoTotalRet(), 0, 5);
        promedioT.setValueAt(rr.getTiempoTotalRes(), 0, 6);
        promedioT.setValueAt(rr.getTiempoTotalDes(), 0, 7);
        promedioT.setValueAt(rr.getTiempoTotalPena(), 0, 8);
        promedioT.setValueAt(rr.getTiempoTotalES(), 0, 9);

        promedioT.setValueAt(rr.getTiempoTotalRet() / rr.procesos.size(), 1, 5);
        promedioT.setValueAt(rr.getTiempoTotalRes() / rr.procesos.size(), 1, 6);
        promedioT.setValueAt(rr.getTiempoTotalDes() / rr.procesos.size(), 1, 7);
        promedioT.setValueAt(rr.getTiempoTotalPena() / rr.procesos.size(), 1, 8);
        promedioT.setValueAt(rr.getTiempoTotalES() / rr.procesos.size(), 1, 9);

    }
        DefaultTableModel modelof,modelor;

    public void ImprimirProceso() {

modelof = (DefaultTableModel) jTIngreso.getModel();
        Object[] miTabla2 = new Object[10];

        for (int i = 0; i < fifos.procesos.size(); i++) {
            miTabla2[0] = fifos.procesos.get(i).GetNombre();
            miTabla2[1] = fifos.procesos.get(i).GetTiempoLlegada();

            miTabla2[2] = fifos.procesos.get(i).GetTDuracion();

            miTabla2[3] = fifos.procesos.get(i).getTa();
            miTabla2[4] = fifos.procesos.get(i).getTf();
            miTabla2[5] = fifos.procesos.get(i).getTret();
            miTabla2[6] = fifos.procesos.get(i).getT();
            miTabla2[7] = fifos.procesos.get(i).getW();
            miTabla2[8] = fifos.procesos.get(i).getP();
            miTabla2[9] = fifos.procesos.get(i).getTe();
            /* 
  
             */
            modelof.addRow(miTabla2);
        }
        jTIngreso.setModel(modelof);

    }
    public void ImprimirProcesoRR() {

modelor = (DefaultTableModel) jTIngreso.getModel();
        Object[] miTabla2 = new Object[10];

        for (int i = 0; i < rr.procesos.size(); i++) {
            miTabla2[0] = rr.procesos.get(i).GetNombre();
            miTabla2[1] = rr.procesos.get(i).GetTiempoLlegada();

            miTabla2[2] = rr.procesos.get(i).GetTDuracion();

            miTabla2[3] = rr.procesos.get(i).getTa();
            miTabla2[4] = rr.procesos.get(i).getTf();
            miTabla2[5] = rr.procesos.get(i).getTret();
            miTabla2[6] = rr.procesos.get(i).getT();
            miTabla2[7] = rr.procesos.get(i).getW();
            miTabla2[8] = rr.procesos.get(i).getP();
            miTabla2[9] = rr.procesos.get(i).getTe();
            
            modelor.addRow(miTabla2);
        }
        jTIngreso.setModel(modelor);

    }
    public void limpiar() {

        DefaultTableModel dm = (DefaultTableModel) jTIngreso.getModel();
        //promedioT.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        
        for(int i = 1; i<tabla1.getColumnCount(); i++){
            
            for(int j=0; j<tabla1.getRowCount(); j+=2){
                tabla1.setValueAt("", j, i);
                tabla2.setValueAt("", j, i);
                tabla3.setValueAt("", j, i);
            }
            
            
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

        Grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        agregarB = new javax.swing.JButton();
        fifoB = new javax.swing.JRadioButton();
        rrB = new javax.swing.JRadioButton();
        nombre = new javax.swing.JTextField();
        tiempoL = new javax.swing.JTextField();
        Duracion = new javax.swing.JTextField();
        Q = new javax.swing.JTextField();
        iniciarB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTIngreso = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        promedioT = new javax.swing.JTable();
        presentacion = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        fifo1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        rr2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        etiquetafifo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        etiquetarr = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Nombre");

        jLabel2.setText("Tiempo Llegada");

        jLabel3.setText("Duracion Rafaga");

        jLabel4.setText("Quautum");

        agregarB.setText("Agregar");
        agregarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBActionPerformed(evt);
            }
        });

        Grupo.add(fifoB);
        fifoB.setText("FIFO");

        Grupo.add(rrB);
        rrB.setText("RR");

        Q.setOpaque(true);

        iniciarB.setText("Inciar");
        iniciarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBActionPerformed(evt);
            }
        });

        jButton2.setText("Reiniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tiempoL)
                        .addGap(58, 58, 58)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rrB)
                    .addComponent(fifoB))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(agregarB)
                .addGap(120, 120, 120)
                .addComponent(iniciarB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tiempoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarB)
                    .addComponent(iniciarB)
                    .addComponent(jButton2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fifoB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rrB)
                .addGap(50, 50, 50))
        );

        jTIngreso.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tiempo Llegada", "DuracionRafaga", "Tiempo Arranque", "Tiempo Finalizacion", "Tiempo Retorno", "Tiempo Respuesta", "Tasa Desperdicio", "Tasa Penalizacion", "Tiempo Espera"
            }
        ));
        jTIngreso.setShowGrid(true);
        jScrollPane1.setViewportView(jTIngreso);
        if (jTIngreso.getColumnModel().getColumnCount() > 0) {
            jTIngreso.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setForeground(new java.awt.Color(102, 255, 102));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"L", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"U", "0", null, "1", null, "2", null, "3", null, "4", null, "5", null, "6", null, "7", null, "8", null, "9", null, "10", null},
                {"E", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        tabla1.setShowGrid(true);
        jScrollPane4.setViewportView(tabla1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Diagrama");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"L", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"U", "11", null, "12", null, "13", null, "14", null, "15", null, "16", null, "17", null, "18", null, "19", null, "20", null, "21", null},
                {"E", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        tabla2.setShowGrid(true);
        jScrollPane3.setViewportView(tabla2);

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"L", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"U", "22", null, "23", "", "24", null, "25", null, "26", null, "27", null, "28", null, "29", null, "30", "", "31", null, "32", null},
                {"E", "", null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        tabla3.setShowGrid(true);
        jScrollPane5.setViewportView(tabla3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        promedioT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tiempo Total", null, null, null, null, null, null, null, null, null},
                {"Promedio", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane2.setViewportView(promedioT);

        presentacion.setText("Presentacion");
        presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentacionActionPerformed(evt);
            }
        });

        fifo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Tiempo Respuesta Fifo", "Tiempo Espera"
            }
        ));
        jScrollPane6.setViewportView(fifo1);

        rr2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Tiempo de Respuesta de RR", "Tiempo Espera"
            }
        ));
        jScrollPane7.setViewportView(rr2);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("COMPARACION DE ALGORITMOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        etiquetafifo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        etiquetafifo.setText("FIFO");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("VS");

        etiquetarr.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        etiquetarr.setText("Round Robin");

        mensaje.setColumns(20);
        mensaje.setRows(5);
        jScrollPane8.setViewportView(mensaje);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(presentacion)
                                .addGap(115, 424, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetafifo)
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 127, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiquetarr)
                                .addGap(66, 66, 66))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(presentacion)
                        .addGap(9, 9, 9)
                        .addComponent(etiquetafifo)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(etiquetarr)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBActionPerformed
if(fifoB.isSelected()==true){Ingresar();}else{IngresarRR();}
        
// TODO add your handling code here:
    }//GEN-LAST:event_agregarBActionPerformed
    ArrayList<String> auxf,auxr = new ArrayList<String>();
    double valor1,valor2,valorER,valorEF;
    private void iniciarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBActionPerformed

        // TablaTiempos t = new TablaTiempos();
        if (fifoB.isSelected() == true) {
            int i;
            int j, u, v, x;

            
            fifos.AsignacionProceos();
            fifos.EvaluacionFifo();
           fifos.ImprimirProceso();

            fifos.ImprimirTabla();
            limpiar();
            ImprimirProceso();
            promedioT();
           //es.fifoE.setModel(modelof);
valor1=fifos.getTiempoTotalRes()/fifos.procesos.size();
valorEF=fifos.getTiempoTotalES()/fifos.procesos.size();
        es.fifoE.setModel(modelof);

            for (j = 1, i = 0; i < fifos.tablas.size() && j < tabla1.getColumnCount(); j = j + 2, i++) {

                auxf = fifos.tablas.get(i).getListosArray();
                for (int k = 0; k < auxf.size(); k++) {
                    tabla1.setValueAt(auxf.get(k), 0, j);
                }
            }

            for (j = 1, x = i; x < fifos.tablas.size() && j < tabla2.getColumnCount(); j = j + 2, x++) {

                auxf = fifos.tablas.get(x).getListosArray();
                for (int k = 0; k < auxf.size(); k++) {
                    tabla2.setValueAt(auxf.get(k), 0, j);
                }
            }
            for (j = 1, v = x; v < fifos.tablas.size() && j < tabla3.getColumnCount(); j = j + 2, v++) {

                auxf = fifos.tablas.get(v).getListosArray();
                for (int k = 0; k < auxf.size(); k++) {
                    tabla3.setValueAt(auxf.get(k), 0, j);
                }
            }

            for (j = 2, i = 0; i < fifos.tablas.size() && j < tabla1.getColumnCount(); j = j + 2, i++) {

                tabla1.setValueAt(fifos.tablas.get(i).getEjecucion(), 2, j);
            }

            for (j = 2, x = i; x < fifos.tablas.size() && j < tabla2.getColumnCount(); j = j + 2, x++) {

                tabla2.setValueAt(fifos.tablas.get(x).getEjecucion(), 2, j);
            }
            for (j = 2, v = x; v < fifos.tablas.size() && j < tabla3.getColumnCount(); j = j + 2, v++) {

                tabla3.setValueAt(fifos.tablas.get(v).getEjecucion(), 2, j);
            }

        } ////condiciones de rr-----------------------------------------------------------------------
        else if (rrB.isSelected() == true) {

            if (Q.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Debes INGRESAR un quautum");
            } else {
                rr.setQuantum(Integer.parseInt(Q.getText()));

                int i,w;
                int j, u, x,v;
                rr.AsignacionProceos();
                rr.EvaluacionRR();   
                rr.ImprimirProceso();      
                rr.ImprimirTabla();

                     

                limpiar();
                ImprimirProcesoRR();
                promedioTRR();
                valor2=rr.getTiempoTotalRes()/rr.procesos.size();
valorER=rr.getTiempoTotalES()/rr.procesos.size();

                for (j = 1, i = 0; i < rr.tablas.size() && j < tabla1.getColumnCount(); j = j + 2, i++) {

                    auxr = rr.tablas.get(i).getListosArray();
                    for (int k = 0; k < auxr.size(); k++) {
                        tabla1.setValueAt(auxr.get(k), 0, j);
                    }
                }
                
                 for (j = 1, x = i; x < rr.tablas.size() && j < tabla2.getColumnCount(); j = j + 2, x++) {

                auxr = rr.tablas.get(x).getListosArray();
                for (int k = 0; k < auxr.size(); k++) {
                    tabla2.setValueAt(auxr.get(k), 0, j);
                }
            }
            for (j = 1, v = x; v < rr.tablas.size() && j < tabla3.getColumnCount(); j = j + 2, v++) {

                auxr = rr.tablas.get(v).getListosArray();
                for (int k = 0; k < auxr.size(); k++) {
                    tabla3.setValueAt(auxr.get(k), 0, j);
                }
            }
                
                
                
              
                
                
                for (j = 2, i = 0; i < rr.tablas.size() && j < tabla1.getColumnCount(); j = j + 2, i++) {

                    tabla1.setValueAt(rr.tablas.get(i).getEjecucion(), 2, j);
                }

                for (u = 2, x = i; x < rr.tablas.size() && u < tabla2.getColumnCount(); u = u + 2, x++) {

                    tabla2.setValueAt(rr.tablas.get(x).getEjecucion(), 2, u);
                }
                for ( w = 2, v = x; v < rr.tablas.size() && w < tabla3.getColumnCount(); w = w + 2, v++) {

                    tabla3.setValueAt(rr.tablas.get(v).getEjecucion(), 2, w);
                }
            }

        } else {

            JOptionPane.showMessageDialog(null, "Deebe seleccionar alguna planificacion");
        }       // TODO add your handling code here:
    }//GEN-LAST:event_iniciarBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
        auxr.clear();
        auxf.clear();
        Q.setText("");

        if (fifoB.isSelected() == true) {
            fifos.limpiar();
           fifos=new Fifo();
           rr.limpiar();
        } else {
            
           fifos.limpiar();
           fifos.limpiar();
          rr= new RoundRobin();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
Presentacion p=new Presentacion();
    private void presentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentacionActionPerformed




p.setVisible(true);
p.setLocationRelativeTo(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_presentacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
fifo1.setValueAt(valor1, 0, 0);
fifo1.setValueAt(valorEF, 0, 1);
rr2.setValueAt(valor2, 0, 0);    
rr2.setValueAt(valorER, 0, 1); 
if(valor1<valor2){

etiquetafifo.setForeground(Color.GREEN);
etiquetarr.setForeground(Color.RED);

mensaje.setText("El algorimto Fifo es mas eficiente  \npor que su tiempo de respuesta es menor\n que el algoritmo ROund Robin");

}else if(valor1>valor2){
etiquetafifo.setForeground(Color.RED);

etiquetarr.setForeground(Color.GREEN);
mensaje.setText("El algorimto Round Robin es mas eficiente  \npor que su tiempo de respuesta es menor\n que el algoritmo Fifo");

}else{

etiquetafifo.setForeground(Color.BLUE);

etiquetarr.setForeground(Color.BLUE);
mensaje.setText("Ambos algoritmos son eficientes");

}


// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Duracion;
    private javax.swing.ButtonGroup Grupo;
    private javax.swing.JTextField Q;
    private javax.swing.JButton agregarB;
    private javax.swing.JLabel etiquetafifo;
    private javax.swing.JLabel etiquetarr;
    private javax.swing.JTable fifo1;
    private javax.swing.JRadioButton fifoB;
    private javax.swing.JButton iniciarB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTable jTIngreso;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton presentacion;
    private javax.swing.JTable promedioT;
    private javax.swing.JTable rr2;
    private javax.swing.JRadioButton rrB;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tabla3;
    private javax.swing.JTextField tiempoL;
    // End of variables declaration//GEN-END:variables
}
