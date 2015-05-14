/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import Listas.ListaPalmares;
import Listas.ListaJugadores;
import Listas.ListaEquipos;
import TableModel.PalmaresTableModel;
import TableModel.JugadoresTableModel;
import TableModel.EquiposTableModel;
import Renderers.NombreEquipoRenderer;
import Renderers.ColorRenderer;
import Renderers.AlinearRenderer;
import Database.Equipos;
import Database.Jugadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


/**
 *
 * @author Borja Andrades
 */
public class Main extends javax.swing.JFrame {
    private final EntityManager  entityManager = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
    //Modelo de tabla para rellenar la tabla//
    private EquiposTableModel equipostablemodel;
    private PalmaresTableModel palmarestablemodel;
    private JugadoresTableModel jugadorestablemodel;
    //query//
    Query query;
    Query querypalmares;
    Query queryjugadores;
    //Arraylists//
    ListaEquipos listaequipos = new ListaEquipos();
    ListaPalmares listapalmares = new ListaPalmares();
    ListaJugadores listajugadores = new ListaJugadores();
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        jButtonActualizar.setEnabled(false);
        
        // Permitir seleccionar solo una fila
        jTableEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTablePalmares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Añadir un detector de cambio de selección en la tabla
        jTableJugadores.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    mostrarDetalleRegistroSeleccionado();
                }
            }
        );
        
        //Rellenar las tablas al iniciar la aplicacion//
        rellenarTablas();
        //Database//
        connectionDatabaseE();

           //Rellenar comboBox
        jComboBoxEquipo.setModel(new DefaultComboBoxModel(listaequipos.getListaequipos().toArray()));
        jComboBoxEquipo.setRenderer(new NombreEquipoRenderer());
  
        
    }
        
        
        //Connection Database// 
        public void connectionDatabaseE(){
         query = entityManager.createNamedQuery("Equipos.findAll");
         listaequipos.setListaequipos(query.getResultList()); 
         /////
         querypalmares = entityManager.createNamedQuery("Palmares.findAll");
         listapalmares.setListapalmares(querypalmares.getResultList());
         /////
         queryjugadores = entityManager.createNamedQuery("Jugadores.findAll");
         listajugadores.setListajugadores(queryjugadores.getResultList());
         entityManager.close();
        }
      
       
       public void mostrarDetalleRegistroSeleccionado() {
       int indexSelectedRow = jTableJugadores.getSelectedRow();
       if(indexSelectedRow < 0){
           jTextFieldNombre.setText("No Row");
       } else {
           Object Nombre = jTableJugadores.getValueAt(indexSelectedRow,0);
           Object Apellidos = jTableJugadores.getValueAt(indexSelectedRow,1);
           Object Apodo = jTableJugadores.getValueAt(indexSelectedRow,2);
           Object Goles = jTableJugadores.getValueAt(indexSelectedRow,4);
           Object Sancion = jTableJugadores.getValueAt(indexSelectedRow,6);
           jTextFieldNombre.setText(String.valueOf(Nombre));
           jTextFieldApellidos.setText(String.valueOf(Apellidos));
           jTextFieldApodo.setText(String.valueOf(Apodo));
           jTextFieldGoles.setText(String.valueOf(Goles));
           jCheckBoxSancion.setSelected((boolean)Sancion);
           //TERMINAR COMBOBOX
       }

    }
       
           
    public void rellenarTablas(){
        ///POSIBLEMENTE BORRAR LO COMENTADO///
        //EQUIPOS
//        Equipos equipo1 = new Equipos("Athletic Club","Ernesto Valverde","Josu Urrutia","Bilbao",1901,"Nuevo San Mamés",83,0);
//        Equipos equipo2 = new Equipos("Real Madrid","Carlos Ancelotti","Florentino Perez","Madrid",1902,"Santiago Bernabeu",83,0);
//        Equipos equipo3 = new Equipos("Racing de Santander","Pedro Munitis","Tuto Sañudo","Santander",1913,"El Sardinero",44,33);
//        listaequipos.getListaequipos().add(equipo1);
//        listaequipos.getListaequipos().add(equipo2);
//        listaequipos.getListaequipos().add(equipo3);
//        //PALMARES
//        Palmares palmares1 = new Palmares(equipo1,8,23,0,1,0,0);
//        Palmares palmares2 = new Palmares(equipo2,32,19,10,9,2,2);
//        Palmares palmares3 = new Palmares(equipo3,0,0,0,0,0,0);
//        listapalmares.getListapalmares().add(palmares1);
//        listapalmares.getListapalmares().add(palmares2);
//        listapalmares.getListapalmares().add(palmares3);
//        //JUGADORES
//        Jugadores jugador1 = new Jugadores("Xabier","Etxeita","",27,2,equipo1,true);
//        Jugadores jugador2 = new Jugadores("Aritz","Aduriz","",34,12,equipo1,false);
//        Jugadores jugador3 = new Jugadores("Francisco","Alarcón","Isco",23,3,equipo2,false);
//        Jugadores jugador4 = new Jugadores("Javier","Hernández","Chicharito",27,3,equipo2,false);
//        Jugadores jugador5 = new Jugadores("Mamadou","Koné","",24,7,equipo3,false);
//        Jugadores jugador6 = new Jugadores("Samuel","Fernandez","",25,0,equipo3,true);
//        listajugadores.getListajugadores().add(jugador1);
//        listajugadores.getListajugadores().add(jugador2);
//        listajugadores.getListajugadores().add(jugador3);
//        listajugadores.getListajugadores().add(jugador4);
//        listajugadores.getListajugadores().add(jugador5);
//        listajugadores.getListajugadores().add(jugador6);
//         //Rellenar la tabla//
        equipostablemodel = new EquiposTableModel(listaequipos);
        jTableEquipos.setModel(equipostablemodel);
        palmarestablemodel = new PalmaresTableModel(listapalmares);
        jTablePalmares.setModel(palmarestablemodel);
        jugadorestablemodel = new JugadoresTableModel(listajugadores);
        jTableJugadores.setModel(jugadorestablemodel);
        //Renderer tablas para alinearlas
        jTableEquipos.getColumnModel().getColumn(0).setCellRenderer(new AlinearRenderer());
        jTableEquipos.getColumnModel().getColumn(3).setCellRenderer(new AlinearRenderer());
        jTableEquipos.getColumnModel().getColumn(5).setCellRenderer(new AlinearRenderer());
        jTablePalmares.getColumnModel().getColumn(0).setCellRenderer(new AlinearRenderer());
        jTableJugadores.getColumnModel().getColumn(5).setCellRenderer(new AlinearRenderer());
        jTableJugadores.getColumnModel().getColumn(2).setCellRenderer(new AlinearRenderer());
        //Color Equipos
        jTableEquipos.getColumnModel().getColumn(0).setCellRenderer(new ColorRenderer());
        jTablePalmares.getColumnModel().getColumn(0).setCellRenderer(new ColorRenderer());
        jTableJugadores.getColumnModel().getColumn(5).setCellRenderer(new ColorRenderer());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEquipos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePalmares = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableJugadores = new javax.swing.JTable();
        jPanelJugadores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldApodo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEquipo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jCheckBoxSancion = new javax.swing.JCheckBox();
        jButtonAñadirJugador = new javax.swing.JButton();
        jButtonBorrarJugador = new javax.swing.JButton();
        jButtonActualizarJugador = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextFieldGoles = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableEquipos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Equipo", "Entrenador", "Presidente", "Ciudad", "AñoFundac.", "Estadio", "AñoPrimera", "AñosSegunda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEquipos);
        if (jTableEquipos.getColumnModel().getColumnCount() > 0) {
            jTableEquipos.getColumnModel().getColumn(6).setMinWidth(50);
            jTableEquipos.getColumnModel().getColumn(6).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Equipos", jPanel1);

        jTablePalmares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Equipo", "Ligas", "CopasRey", "Champions", "Sup.España", "Sup.Europa", "EuropaLeague"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePalmares);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Palmares", jPanel2);

        jTableJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Apodo", "Edad", "Goles", "Equipo", "Sancionado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableJugadores);

        jPanelJugadores.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 51, 51)));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Rellenar Datos");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Apodo:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Goles:");

        jLabel7.setText("Equipo:");

        jLabel8.setText("Sancionado:");

        jButtonAñadirJugador.setText("Añadir");
        jButtonAñadirJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirJugadorActionPerformed(evt);
            }
        });

        jButtonBorrarJugador.setText("Borrar");

        jButtonActualizarJugador.setText("Actualizar");

        javax.swing.GroupLayout jPanelJugadoresLayout = new javax.swing.GroupLayout(jPanelJugadores);
        jPanelJugadores.setLayout(jPanelJugadoresLayout);
        jPanelJugadoresLayout.setHorizontalGroup(
            jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxSancion))
                            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBorrarJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButtonAñadirJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonActualizarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                                        .addComponent(jTextFieldGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jTextFieldApodo)
                                    .addComponent(jTextFieldApellidos)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanelJugadoresLayout.setVerticalGroup(
            jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJugadoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldApodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldGoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(jPanelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBoxSancion))
                .addGap(18, 18, 18)
                .addComponent(jButtonAñadirJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBorrarJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonActualizarJugador)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Jugadores", jPanel4);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar Acción");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTabbedPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEquiposMouseClicked
        jButtonActualizar.setEnabled(true);
    }//GEN-LAST:event_jTableEquiposMouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        //Boton de guardar/actualizar los datos de las columnas
        //CAMBIARLO,QUE SE GUARDE EN EL OBJETO ARRAYLIST
        
        equipostablemodel.fireTableRowsUpdated(jTableEquipos.getSelectedRow(), jTableEquipos.getSelectedRow());    
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonAñadirJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirJugadorActionPerformed
        jButtonBorrarJugador.setEnabled(false);
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldApodo.setText("");
        jTextFieldGoles.setText("");
        jCheckBoxSancion.setText("");
        
    }//GEN-LAST:event_jButtonAñadirJugadorActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonBorrarJugador.setEnabled(true);
        jButtonAñadirJugador.setEnabled(true);
        jButtonActualizarJugador.setEnabled(true);
        jButtonActualizar.setEnabled(false);
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldApodo.setText("");
        jTextFieldGoles.setText("");
        jCheckBoxSancion.setText("");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonActualizarJugador;
    private javax.swing.JButton jButtonAñadirJugador;
    private javax.swing.JButton jButtonBorrarJugador;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxSancion;
    private javax.swing.JComboBox jComboBoxEquipo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelJugadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableEquipos;
    private javax.swing.JTable jTableJugadores;
    private javax.swing.JTable jTablePalmares;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldApodo;
    private javax.swing.JTextField jTextFieldGoles;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
