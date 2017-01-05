package presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JTextField;

import dominio.Datos;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import net.miginfocom.swing.MigLayout;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import java.util.StringTokenizer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;

public class Pacientes extends JPanel {
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblBusqueda;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JPanel pnlDatos;
	
	private Datos datos;
	private Ventana ventana;
	private JPanel panel_2;
	private JButton btnAniadir;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblFechaNacimiento;
	private JLabel lblSexo;
	private JLabel lblPais;
	private JTextField txtPais;
	private JLabel lblTelfono;
	private JTextField txtTelefono;
	private JPanel panel_1;
	private JLabel lblFoto;
	private JLabel label;
	private JButton btnGuardar;
	private JLabel lblAntecedentesFamiliares;
	private JLabel lblOperaciones;
	private JScrollPane scrollPane_1;
	private JTextArea txtAntecedentes;
	private JLabel lblAlergias;
	private JScrollPane scrollPane_2;
	private JTextArea txtAlergias;
	private JLabel lblEnfermedades;
	private JScrollPane scrollPane_3;
	private JTextArea txtEnfermedades;
	private JComboBox cbSexo;
	private JScrollPane scrollPane_4;
	private JLabel lblTratamiento;
	private JLabel lblVacunaciones;
	private JTextArea txtVacunaciones;
	private JScrollPane scrollPane_5;
	private JTextArea txtTratamiento;
	private JScrollPane scrollPane_6;
	private JTextArea txtOperaciones;
	private JPanel panel_3;
	private JFormattedTextField ftxtFecha;
	
	private boolean editando = false;
	private boolean aniadiendo = false;
	private JLabel lblFecha;
	private JTextField txtFechaI;
	private JLabel lblMedico;
	private JTextField txtMedicoI;
	private JLabel lblMotivo;
	private JScrollPane scrollPane_7;
	private JTextArea txtMotivo;
	private JLabel lblDiagnostico;
	private JScrollPane scrollPane_8;
	private JTextArea txtDiagnostico;
	private JLabel lblTratamiento_1;
	private JScrollPane scrollPane_9;
	private JTextArea txtTratamientoI;
	private JPanel panel_4;
	private JButton btnTexto;
	private JButton btnRectangulo;
	private JButton btnLapiz;
	private JScrollPane scrollPane_10;
	private JScrollPane scrollPane_11;
	private MiAreaDibujo imagen1;
	private MiAreaDibujo imagen2;
	private JPanel pnlVacio = new JPanel();
	
	private String paciente = "";
	private String textoBusqueda = "";
	private int lugarTabla = 0;
	
	private int x, y;
	
	private int size = 1;
	
	int modo = -1;
	private final int TEXTO = 1;
	private final int RECTANGULO = 2;
	private final int LAPIZ = 3;
	private JButton btnDeshacer1;
	private JButton btnDeshacer2;
	private JButton btnClear2;
	private JButton btnClear1;
	
	private JTextField txtTexto = new JTextField();
	private JComboBox cbGrosor;
	private JButton btnColor;
	
	private Color colorGraficos = Color.RED;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Pacientes(Ventana v, String paciente) throws SQLException {
		UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
		ventana = v;
		datos = ventana.getDatos();
		setLayout(new BorderLayout(0, 0));
		{
			splitPane = new JSplitPane();
			splitPane.setMinimumSize(new Dimension(200, 27));
			add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(350, 10));
				panel.setMinimumSize(new Dimension(350, 10));
				splitPane.setLeftComponent(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{79, 65, 0};
				gbl_panel.rowHeights = new int[]{45, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					lblBusqueda = new JLabel("");
					lblBusqueda.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/busqueda-2.png")));
					GridBagConstraints gbc_lblBusqueda = new GridBagConstraints();
					gbc_lblBusqueda.insets = new Insets(0, 0, 5, 5);
					gbc_lblBusqueda.gridx = 0;
					gbc_lblBusqueda.gridy = 0;
					panel.add(lblBusqueda, gbc_lblBusqueda);
				}
				{
					txtBusqueda = new JTextField();
					txtBusqueda.setToolTipText("Escriba el término que desea buscar");
					txtBusqueda.addKeyListener(new TxtBusquedaKeyListener());
					GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
					gbc_txtBusqueda.insets = new Insets(0, 0, 5, 0);
					gbc_txtBusqueda.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtBusqueda.gridx = 1;
					gbc_txtBusqueda.gridy = 0;
					panel.add(txtBusqueda, gbc_txtBusqueda);
					txtBusqueda.setColumns(10);
				}
				{
					scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
					gbc_scrollPane.gridwidth = 2;
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridx = 0;
					gbc_scrollPane.gridy = 1;
					panel.add(scrollPane, gbc_scrollPane);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
						
						table = new JTable();
						table.addMouseListener(new TableMouseListener());
						table.addKeyListener(new TableKeyListener());
						scrollPane.setViewportView(table);
						table.setFont(new Font("Tahoma", Font.PLAIN, 22));
						ModeloTablaPacientes modeloTabla = new ModeloTablaPacientes();
						table.setModel(modeloTabla);
						table.setRowHeight(30);
					}
				}
				{
					panel_2 = new JPanel();
					GridBagConstraints gbc_panel_2 = new GridBagConstraints();
					gbc_panel_2.gridwidth = 2;
					gbc_panel_2.insets = new Insets(0, 0, 0, 5);
					gbc_panel_2.fill = GridBagConstraints.BOTH;
					gbc_panel_2.gridx = 0;
					gbc_panel_2.gridy = 2;
					panel.add(panel_2, gbc_panel_2);
					panel_2.setLayout(new GridLayout(0, 3, 0, 0));
					{
						btnAniadir = new JButton("Añadir");
						btnAniadir.setToolTipText("Pulse para añadir un paciente");
						btnAniadir.addActionListener(new BtnAniadirActionListener());
						btnAniadir.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/aniadir-2.png")));
						panel_2.add(btnAniadir);
					}
					{
						btnEditar = new JButton("Editar\r\n");
						btnEditar.setToolTipText("Pulse para editar un paciente seleccionado");
						btnEditar.addActionListener(new BtnEditarActionListener());
						btnEditar.setEnabled(false);
						btnEditar.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/editar-2.png")));
						panel_2.add(btnEditar);
					}
					{
						btnBorrar = new JButton("Borrar");
						btnBorrar.setToolTipText("Pulse para borrar un paciente seleccionado");
						btnBorrar.addActionListener(new BtnBorrarActionListener());
						btnBorrar.setEnabled(false);
						btnBorrar.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/eliminar-2.png")));
						panel_2.add(btnBorrar);
					}
				}
			}
			{
				tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.addChangeListener(new TabbedPaneChangeListener());
				splitPane.setRightComponent(tabbedPane);
				//splitPane.setRightComponent(pnlVacio);
				{
					pnlDatos = new JPanel();
					tabbedPane.addTab("Datos", null, pnlDatos, null);
					pnlDatos.setLayout(new MigLayout("", "[46.00px][196px][37.00][16.00][89.00px][198.00px][35.00][303.00][99.00]", "[17.00px][39px][22px][22.00px][22px][22px][22px][22px][22px][22px][22px][][22][110][22][22][110][22][22][143.00]"));
					{
						btnGuardar = new JButton("Guardar");
						btnGuardar.setToolTipText("Pulse para confirmar los cambios");
						btnGuardar.addActionListener(new BtnGuardarActionListener());
						btnGuardar.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/guardar-2.png")));
						pnlDatos.add(btnGuardar, "cell 1 1,growx,aligny center");
						btnGuardar.setVisible(false);
					}
					{
						panel_1 = new JPanel();
						pnlDatos.add(panel_1, "cell 1 2 1 9,grow");
						{
							lblFoto = new JLabel("");
							lblFoto.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/p0.png")));
							panel_1.add(lblFoto);
						}
					}
					{
						lblNombre = new JLabel("Nombre:");
						pnlDatos.add(lblNombre, "cell 2 2 3 1,alignx right,aligny top");
					}
					{
						txtNombre = new JTextField();
						txtNombre.setEditable(false);
						pnlDatos.add(txtNombre, "cell 5 2,growx,aligny center");
						txtNombre.setColumns(10);
					}
					{
						lblAlergias = new JLabel("Alergias:");
						pnlDatos.add(lblAlergias, "cell 7 2,aligny bottom");
					}
					{
						scrollPane_2 = new JScrollPane();
						pnlDatos.add(scrollPane_2, "cell 7 3 2 8,grow");
						{
							txtAlergias = new JTextArea();
							txtAlergias.setEditable(false);
							txtAlergias.setLineWrap(true);
							txtAlergias.setWrapStyleWord(true);							
							scrollPane_2.setViewportView(txtAlergias);
						}
					}
					{
						lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
						pnlDatos.add(lblFechaNacimiento, "cell 2 4 3 1,alignx right,aligny center");
					}
					{
						MaskFormatter formatoFecha;
						try {
							formatoFecha = new MaskFormatter("##/##/####");
							formatoFecha.setPlaceholderCharacter('X');
							ftxtFecha = new JFormattedTextField(formatoFecha);
							ftxtFecha.setEditable(false);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						pnlDatos.add(ftxtFecha, "cell 5 4,growx");
					}
					{
						lblSexo = new JLabel("Sexo:");
						pnlDatos.add(lblSexo, "cell 2 6 3 1,alignx right,aligny center");
					}
					{
						cbSexo = new JComboBox();
						cbSexo.setEnabled(false);
						cbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
						pnlDatos.add(cbSexo, "cell 5 6");
					}
					{
						lblPais = new JLabel("País:");
						pnlDatos.add(lblPais, "cell 2 8 3 1,alignx right,aligny center");
					}
					{
						txtPais = new JTextField();
						txtPais.setEditable(false);
						pnlDatos.add(txtPais, "cell 5 8,growx,aligny center");
						txtPais.setColumns(10);
					}
					{
						lblTelfono = new JLabel("Teléfono:");
						pnlDatos.add(lblTelfono, "cell 2 10 3 1,alignx right,aligny center");
					}
					{
						MaskFormatter formatoTelefono;
						try {
							formatoTelefono = new MaskFormatter("### ### ###");
							formatoTelefono.setPlaceholderCharacter('X');
							txtTelefono = new JFormattedTextField(formatoTelefono);
							txtTelefono.setEditable(false);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						pnlDatos.add(txtTelefono, "cell 5 10,growx,aligny center");
						txtTelefono.setColumns(10);
					}
					{
						label = new JLabel("");
						pnlDatos.add(label, "cell 0 0,alignx center,aligny center");
					}
					{
						lblAntecedentesFamiliares = new JLabel("Antecedentes familiares:");
						pnlDatos.add(lblAntecedentesFamiliares, "cell 1 12");
					}
					{
						lblEnfermedades = new JLabel("Enfermedades:");
						pnlDatos.add(lblEnfermedades, "cell 7 12");
					}
					{
						scrollPane_1 = new JScrollPane();
						pnlDatos.add(scrollPane_1, "cell 1 13 5 1,grow");
						{
							txtAntecedentes = new JTextArea();
							txtAntecedentes.setEditable(false);
							txtAntecedentes.setLineWrap(true);
							txtAntecedentes.setWrapStyleWord(true);							
							scrollPane_1.setViewportView(txtAntecedentes);
						}
					}
					{
						scrollPane_3 = new JScrollPane();
						pnlDatos.add(scrollPane_3, "cell 7 13 2 1,grow");
						{
							txtEnfermedades = new JTextArea();
							txtEnfermedades.setEditable(false);
							txtEnfermedades.setLineWrap(true);
							txtEnfermedades.setWrapStyleWord(true);	
							scrollPane_3.setViewportView(txtEnfermedades);
						}
					}
					{
						lblVacunaciones = new JLabel("Vacunaciones:");
						pnlDatos.add(lblVacunaciones, "cell 1 15");
					}
					{
						lblTratamiento = new JLabel("Tratamiento habitual:");
						pnlDatos.add(lblTratamiento, "cell 7 15");
					}
					{
						scrollPane_4 = new JScrollPane();
						pnlDatos.add(scrollPane_4, "cell 1 16 5 1,grow");
						{
							txtVacunaciones = new JTextArea();
							txtVacunaciones.setEditable(false);
							txtVacunaciones.setLineWrap(true);
							txtVacunaciones.setWrapStyleWord(true);	
							scrollPane_4.setViewportView(txtVacunaciones);
						}
					}
					{
						scrollPane_5 = new JScrollPane();
						pnlDatos.add(scrollPane_5, "cell 7 16 2 1,grow");
						{
							txtTratamiento = new JTextArea();
							txtTratamiento.setEditable(false);
							txtTratamiento.setLineWrap(true);
							txtTratamiento.setWrapStyleWord(true);	
							scrollPane_5.setViewportView(txtTratamiento);
						}
					}
					{
						lblOperaciones = new JLabel("Operaciones:");
						pnlDatos.add(lblOperaciones, "cell 1 18");
					}
					{
						scrollPane_6 = new JScrollPane();
						pnlDatos.add(scrollPane_6, "cell 1 19 8 1,grow");
						{
							txtOperaciones = new JTextArea();
							txtOperaciones.setEditable(false);
							txtOperaciones.setLineWrap(true);
							txtOperaciones.setWrapStyleWord(true);	
							scrollPane_6.setViewportView(txtOperaciones);
						}
					}
				}
				{
					panel_3 = new JPanel();
					tabbedPane.addTab("Informes", null, panel_3, null);
					panel_3.setLayout(new MigLayout("", "[63.00][298.00][245.00][28.00][47.00][16.00][185.00][28.00]", "[][48.00][6.00][][19.00][][][13.00][][198.00][32.00][][24][17.00][156][][][198.00]"));
					{
						panel_4 = new JPanel();
						panel_3.add(panel_4, "cell 5 1 2 1,grow");
						panel_4.setLayout(new GridLayout(0, 5, 0, 0));
						{
							btnTexto = new JButton("");
							btnTexto.setToolTipText("Pulse para añadir un texto");
							btnTexto.addActionListener(new BtnTextoActionListener());
							btnTexto.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/texto-2.png")));
							btnTexto.setContentAreaFilled(false);
							btnTexto.setOpaque(true);
							panel_4.add(btnTexto);
						}
						{
							btnRectangulo = new JButton("");
							btnRectangulo.setToolTipText("Pulse para dibujar un rectángulo");
							btnRectangulo.addActionListener(new BtnRectanguloActionListener());
							btnRectangulo.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/rectangulo.png")));
							btnRectangulo.setContentAreaFilled(false);
							btnRectangulo.setOpaque(true);
							panel_4.add(btnRectangulo);
						}
						{
							btnLapiz = new JButton("");
							btnLapiz.setToolTipText("Pulse para dibujar una forma libre");
							btnLapiz.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/lapiz-2.png")));
							btnLapiz.addActionListener(new BtnLapizActionListener());
							btnLapiz.setContentAreaFilled(false);
							btnLapiz.setOpaque(true);
							panel_4.add(btnLapiz);
						}
						{
							btnColor = new JButton("Color");
							btnColor.setToolTipText("Pulse para seleccionar el color");
							btnColor.setForeground(colorGraficos);
							btnColor.addActionListener(new BtnColorActionListener());
							panel_4.add(btnColor);
						}
						{
							cbGrosor = new JComboBox();
							cbGrosor.setToolTipText("Pulse para seleccionar el tamaño del elemento");
							cbGrosor.setVisible(false);
							cbGrosor.addActionListener(new CbGrosorActionListener());
							cbGrosor.setModel(new DefaultComboBoxModel(new String[] {"Pequeño", "Mediano", "Grande"}));
							panel_4.add(cbGrosor);
						}
					}
					{
						lblFecha = new JLabel("Fecha");
						panel_3.add(lblFecha, "cell 1 2");
					}
					{
						txtFechaI = new JTextField();
						txtFechaI.setEditable(false);
						panel_3.add(txtFechaI, "cell 1 3,growx");
						txtFechaI.setColumns(10);
					}
					{
						scrollPane_10 = new JScrollPane();
						panel_3.add(scrollPane_10, "cell 5 3 3 10,grow");
						{
							imagen1 = new MiAreaDibujo();
							imagen1.addMouseMotionListener(new Imagen1MouseMotionListener());
							imagen1.addMouseListener(new Imagen1MouseListener());
							scrollPane_10.setViewportView(imagen1);
						}
					}
					{
						lblMedico = new JLabel("Medico");
						panel_3.add(lblMedico, "cell 1 5");
					}
					{
						txtMedicoI = new JTextField();
						txtMedicoI.setEditable(false);
						panel_3.add(txtMedicoI, "cell 1 6,growx");
						txtMedicoI.setColumns(10);
					}
					{
						lblMotivo = new JLabel("Motivo");
						panel_3.add(lblMotivo, "cell 1 8");
					}
					{
						btnDeshacer1 = new JButton("");
						btnDeshacer1.setToolTipText("Pulse para borrar el último elemento añadido");
						btnDeshacer1.addActionListener(new BtnDeshacer1ActionListener());
						btnDeshacer1.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/deshacer.png")));
						panel_3.add(btnDeshacer1, "cell 4 7 1 2,grow");
					}
					{
						scrollPane_7 = new JScrollPane();
						panel_3.add(scrollPane_7, "cell 1 9 2 1,grow");
						{
							txtMotivo = new JTextArea();
							txtMotivo.setEditable(false);
							txtMotivo.setLineWrap(true);
							txtMotivo.setWrapStyleWord(true);	
							scrollPane_7.setViewportView(txtMotivo);
						}
					}
					{
						btnClear1 = new JButton("");
						btnClear1.setToolTipText("Pulse para borrar todos los elementos añadidos");
						btnClear1.addActionListener(new BtnClear1ActionListener());
						btnClear1.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/eliminar-2.png")));
						panel_3.add(btnClear1, "cell 4 9,growx,aligny top");
					}
					{
						lblDiagnostico = new JLabel("Diagnóstico");
						panel_3.add(lblDiagnostico, "cell 1 11");
					}
					{
						scrollPane_8 = new JScrollPane();
						panel_3.add(scrollPane_8, "cell 1 12 2 3,grow");
						{
							txtDiagnostico = new JTextArea();
							txtDiagnostico.setEditable(false);
							txtDiagnostico.setLineWrap(true);
							txtDiagnostico.setWrapStyleWord(true);	
							scrollPane_8.setViewportView(txtDiagnostico);
						}
					}
					{
						scrollPane_11 = new JScrollPane();
						panel_3.add(scrollPane_11, "cell 5 14 3 4,grow");
						{
							imagen2 = new MiAreaDibujo();
							imagen2.addMouseMotionListener(new Imagen2MouseMotionListener());
							imagen2.addMouseListener(new Imagen2MouseListener());
							scrollPane_11.setViewportView(imagen2);
						}
					}
					{
						btnDeshacer2 = new JButton("");
						btnDeshacer2.setToolTipText("Pulse para borrar el último elemento añadido");
						btnDeshacer2.addActionListener(new BtnDeshacer2ActionListener());
						btnDeshacer2.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/deshacer.png")));
						panel_3.add(btnDeshacer2, "cell 4 15 1 2,grow");
					}
					{
						lblTratamiento_1 = new JLabel("Tratamiento");
						panel_3.add(lblTratamiento_1, "cell 1 16");
					}
					{
						scrollPane_9 = new JScrollPane();
						panel_3.add(scrollPane_9, "cell 1 17 2 1,grow");
						{
							txtTratamientoI = new JTextArea();
							txtTratamientoI.setEditable(false);
							txtTratamientoI.setLineWrap(true);
							txtTratamientoI.setWrapStyleWord(true);
							scrollPane_9.setViewportView(txtTratamientoI);
						}
					}
					{
						btnClear2 = new JButton("");
						btnClear2.setToolTipText("Pulse para borrar todos los elementos añadidos");
						btnClear2.addActionListener(new BtnClear2ActionListener());
						btnClear2.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/eliminar-2.png")));
						panel_3.add(btnClear2, "cell 4 17,growx,aligny top");
					}
				}
			}
			actualizarListaPacientes(txtBusqueda.getText());		
		}

	}
	
	public void actualizarListaPacientes(String s) throws SQLException{
		datos = ventana.getDatos();
		ArrayList<String> lista = datos.getListaPacientes(s);
		int n = lista.size();
		ModeloTabla modelo = (ModeloTabla)table.getModel();
		modelo.eliminaTodo();
		if (n>0){
			for(int i = 0;i<n;i++){
				Object[] fila1= {lista.get(i)};
				modelo.aniadeFila(fila1);
			}
		}
		modelo.fireTableDataChanged();	
	}
	
	public void actualizarListaInformes(String s) throws SQLException{
		datos = ventana.getDatos();
		ArrayList<String> lista = datos.getListaInformes(paciente, s);
		int n = lista.size();
		ModeloTablaInformes modelo = (ModeloTablaInformes)table.getModel();
		modelo.eliminaTodo();
		if (n>0){
			for(int i = 0;i<n;i+=2){
				Object[] fila1= {lista.get(i), lista.get(i+1)};
				modelo.aniadeFila(fila1);
			}
		}
		modelo.fireTableDataChanged();	
	}
	
	public void rellenarInfo(String s) throws SQLException, ParseException{
		splitPane.setRightComponent(tabbedPane);
		txtNombre.setText((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
		ArrayList<String> lista = datos.getInfoPaciente(s);
		ftxtFecha.setText(lista.get(0));
		if(lista.get(1).equals("F"))
			cbSexo.setSelectedIndex(0);
		else
			cbSexo.setSelectedIndex(1);
		txtPais.setText(lista.get(2));
		txtTelefono.setText(lista.get(3));
		txtAlergias.setText(lista.get(4));
		txtAntecedentes.setText(lista.get(5));
		txtEnfermedades.setText(lista.get(6));
		txtVacunaciones.setText(lista.get(7));
		txtTratamiento.setText(lista.get(8));
		txtOperaciones.setText(lista.get(9));
		lblFoto.setIcon(new ImageIcon(Pacientes.class.getResource(lista.get(10))));
		btnEditar.setEnabled(true);
		btnBorrar.setEnabled(true);
		txtAlergias.setVisible(true);
		txtAntecedentes.setVisible(true);
		txtEnfermedades.setVisible(true);
		txtVacunaciones.setVisible(true);
		txtTratamiento.setVisible(true);
		txtOperaciones.setVisible(true);
		btnGuardar.setVisible(false);
		
	}
	
	public void rellenarInforme(String fecha, String nombre) throws SQLException{
		imagen1.setIcon(null);
		imagen2.setIcon(null);
		ArrayList<String> lista = datos.getInforme(fecha, nombre);
		txtFechaI.setText(lista.get(0));
		txtMedicoI.setText(lista.get(1));
		txtMotivo.setText(lista.get(2));
		txtDiagnostico.setText(lista.get(3));
		txtTratamientoI.setText(lista.get(4));
		if(!lista.get(5).equals("null"))
			imagen1.setIcon(new ImageIcon(Pacientes.class.getResource(lista.get(5))));
		if(!lista.get(6).equals("no"))
			imagen2.setIcon(new ImageIcon(Pacientes.class.getResource(lista.get(6))));
	}
	
	public void marcarPaciente() throws SQLException, ParseException{
		txtBusqueda.setText("");
		table.setRowSelectionInterval(0, 0);
		paciente = (String)table.getModel().getValueAt(table.getSelectedRow(),0);
		textoBusqueda = (String)table.getModel().getValueAt(table.getSelectedRow(),0);
		lugarTabla = 0;
		rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(),0));
		txtBusqueda.setText((String)table.getModel().getValueAt(table.getSelectedRow(),0));
		splitPane.setRightComponent(tabbedPane);
	}
	
	public boolean comprobarFecha(){
		boolean b = false;
		int dia, mes, year;
		String fecha = ftxtFecha.getText();
		StringTokenizer st;
		st = new StringTokenizer(fecha, "/");
		dia = Integer.parseInt(st.nextToken());
		mes = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
		if(dia<1 || dia>31 || mes<1 || mes>12)
			b = false;
		else{
			if(mes==2)
				if(year%4==0)
					if(dia<30)
						b=true;								
				else
					if(dia<29)
						b=true;
			if(mes==4 || mes==6 || mes==9 || mes== 11){
				if(dia<31)
					b=true;
			}
			else
				b = true;			
		}
		btnGuardar.setVisible(b);
		return b;
	}
	
	public boolean comprobarTelefono(){
		return Character.isDigit(txtTelefono.getText().charAt(0)) && Character.isDigit(txtTelefono.getText().charAt(1)) && Character.isDigit(txtTelefono.getText().charAt(2)) && Character.isDigit(txtTelefono.getText().charAt(4)) && Character.isDigit(txtTelefono.getText().charAt(5)) && Character.isDigit(txtTelefono.getText().charAt(6)) && Character.isDigit(txtTelefono.getText().charAt(8)) && Character.isDigit(txtTelefono.getText().charAt(9)) && Character.isDigit(txtTelefono.getText().charAt(10)) && txtTelefono.getText().charAt(3)==' ' && txtTelefono.getText().charAt(7)==' ';
	}
	
	public void transformarSize(String s){
		if(s.equals("Pequeño") || s.equals("Small")){
			size = 1;
		}
		else if(s.equals("Mediano") || s.equals("Medium")){
			size = 2;
		}
		else if(s.equals("Grande") || s.equals("Big")){
			size = 3;
		}
		
	}
	
	public void vaciarCampos(){
		txtNombre.setText("");
		ftxtFecha.setText("");
		cbSexo.setSelectedIndex(0);;
		txtPais.setText("");
		txtTelefono.setText("");
		txtAlergias.setText("");
		txtAntecedentes.setText("");
		txtEnfermedades.setText("");
		txtVacunaciones.setText("");
		txtTratamiento.setText("");
		txtOperaciones.setText("");
		lblFoto.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/p0.png")));
	}
	
	public void vaciarInforme(){
		txtFechaI.setText("");
		txtMedicoI.setText("");
		txtMotivo.setText("");
		txtDiagnostico.setText("");
		txtTratamientoI.setText("");
		imagen1.setIcon(null);
		imagen2.setIcon(null);
		imagen1.removeObjetosGraficos();
		imagen2.removeObjetosGraficos();
		imagen1.repaint();
		imagen2.repaint();
	}
	
	public void aniadirPaciente(){
		txtNombre.setEditable(true);
		ftxtFecha.setEditable(true);
		cbSexo.setEnabled(true);
		txtPais.setEditable(true);
		txtTelefono.setEditable(true);
		vaciarCampos();
		btnGuardar.setVisible(true);
		lblFoto.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/p0.png")));
		txtAlergias.setVisible(false);
		txtAntecedentes.setVisible(false);
		txtEnfermedades.setVisible(false);
		txtVacunaciones.setVisible(false);
		txtTratamiento.setVisible(false);
		txtOperaciones.setVisible(false);
	}
	
	public void editarPaciente(){
		txtNombre.setEditable(true);
		ftxtFecha.setEditable(true);
		cbSexo.setEnabled(true);
		txtPais.setEditable(true);
		txtTelefono.setEditable(true);
	}
	
	public void noEditando(){
		txtNombre.setEditable(false);
		ftxtFecha.setEditable(false);
		cbSexo.setEnabled(false);
		txtPais.setEditable(false);
		txtTelefono.setEditable(false);
		lugarTabla = table.getSelectedRow();
		table.clearSelection();
		btnEditar.setEnabled(false);
		btnBorrar.setEnabled(false);
		//vaciarCampos();
		btnGuardar.setVisible(false);
	}
	
	public void cambiarADatos(){
		tabbedPane.setSelectedIndex(0);
		vaciarInforme();
	}
	
	public void pressedMouse(MiAreaDibujo m, MouseEvent e){
		x = e.getX();
		y = e.getY();
		if (m.getIcon() != null){
		switch (modo){
			case RECTANGULO:
				m.addObjetoGrafico(new RectanguloGrafico(x,y,x,y, colorGraficos));
				m.repaint();
				break;
			case TEXTO:
				txtTexto.setBounds(x, y, 200,30);
				txtTexto.setVisible(true);
				txtTexto.requestFocus();
				txtTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg) {
					if(!txtTexto.getText().equals(""))
						m.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(), colorGraficos, size*9));
						txtTexto.setText("");
						txtTexto.setVisible(false);
						m.repaint();
					}
				});
				m.add(txtTexto);
				break;
			case LAPIZ:
				m.addObjetoGrafico(new LineaGrafico(x,y, size*size+1, colorGraficos));
				m.repaint();
				break;
			}
		}
	}
	
	public void draggedMouse(MiAreaDibujo m, MouseEvent e){
		x = e.getX();
		y = e.getY();
		if (modo == RECTANGULO && m.getIcon()!=null) {
			((RectanguloGrafico)m.getUltimoObjetoGrafico()).setX1(x);
			((RectanguloGrafico)m.getUltimoObjetoGrafico()).setY1(y);
			m.repaint();
		}
		else if(modo == LAPIZ && m.getIcon()!=null){
			((LineaGrafico)m.getUltimoObjetoGrafico()).addPunto(x, y);
			m.repaint();
		}
	}

	private class TxtBusquedaKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if(tabbedPane.getSelectedIndex()==0){
				try {
					actualizarListaPacientes(txtBusqueda.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else{
				try {
					actualizarListaInformes(txtBusqueda.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				splitPane.setRightComponent(tabbedPane);
				vaciarInforme();
				if(tabbedPane.getSelectedIndex()==0){
					noEditando();
					table.setRowSelectionInterval(lugarTabla, lugarTabla);
					paciente = (String)table.getModel().getValueAt(table.getSelectedRow(), 0);
					textoBusqueda = txtBusqueda.getText();
					lugarTabla = table.getSelectedRow();
					rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
				}
				else{
					rellenarInforme((String)table.getModel().getValueAt(table.getSelectedRow(), 0), (String)table.getModel().getValueAt(table.getSelectedRow(), 1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private class TableKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==40 || e.getKeyCode()==38)
				splitPane.setRightComponent(tabbedPane);
				vaciarInforme();
				if(tabbedPane.getSelectedIndex()==0){
					noEditando();
					table.setRowSelectionInterval(lugarTabla, lugarTabla);
					try {
						rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				else{
					try {
						rellenarInforme((String)table.getModel().getValueAt(table.getSelectedRow(), 0), (String)table.getModel().getValueAt(table.getSelectedRow(), 1));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		}
	}
	
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editando && !aniadiendo){
				if(comprobarFecha() && !txtNombre.getText().equals("") && comprobarTelefono() && !txtPais.getText().equals("")){
					try {
						if(datos.editarPaciente(paciente, txtNombre.getText(), ftxtFecha.getText(), (String)cbSexo.getSelectedItem(), txtPais.getText(), txtTelefono.getText())){
							String s = txtNombre.getText();
							actualizarListaPacientes(txtNombre.getText());
							table.getSelectionModel().setSelectionInterval(0, 0);
							rellenarInfo(s);
							actualizarListaPacientes(textoBusqueda);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}						
				}
			}
			else if(!editando && aniadiendo){
				if(comprobarFecha() && !txtNombre.getText().equals("") && comprobarTelefono() && !txtPais.getText().equals("")){
					if(datos.aniadirPaciente(txtNombre.getText(), ftxtFecha.getText(), (String)cbSexo.getSelectedItem(), txtPais.getText(), txtTelefono.getText())){
						try {
							actualizarListaPacientes("");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}		
			}
			noEditando();
		}
	}

	private class BtnAniadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			table.clearSelection();
			aniadirPaciente();
			aniadiendo=true;
			editando = false;
			btnEditar.setEnabled(false);
			btnBorrar.setEnabled(false);
			vaciarCampos();
		}
	}
	
	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			editarPaciente();
			editando = true;
			aniadiendo = false;
			btnGuardar.setVisible(true);
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				splitPane.setRightComponent(pnlVacio);
				editando = false;
				aniadiendo = false;
				btnBorrar.setEnabled(false);
				btnEditar.setEnabled(false);
				datos.borrarPaciente((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
				actualizarListaPacientes("");
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			table.clearSelection();
			vaciarCampos();
		}
	}
	private class TabbedPaneChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int selectedIndex = tabbedPane.getSelectedIndex();
			if(selectedIndex==0){
				lblBusqueda.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/busqueda-2.png")));
				txtBusqueda.setText(textoBusqueda);
				try {
					actualizarListaPacientes(textoBusqueda);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				panel_2.setVisible(true);
				ModeloTablaPacientes modeloTablaPacientes = new ModeloTablaPacientes();
				table.setModel(modeloTablaPacientes);
				try {
					actualizarListaPacientes(txtBusqueda.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else{
				btnBorrar.setEnabled(false);
				lblBusqueda.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/buscarDocumento-2.png")));
				txtBusqueda.setText("");
				panel_2.setVisible(false);
				ModeloTablaInformes modeloTablaInformes = new ModeloTablaInformes();
				table.setModel(modeloTablaInformes);
				try {
					actualizarListaInformes(txtBusqueda.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	private class Imagen1MouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			pressedMouse(imagen1, e);
		}
	}
	private class Imagen1MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			draggedMouse(imagen1, e);
		}
	}
	private class Imagen2MouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			pressedMouse(imagen2, e);
		}
	}
	private class Imagen2MouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			draggedMouse(imagen2, e);
		}
	}
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnLapiz.setBackground((new Color(240, 240, 240)));
			btnTexto.setBackground((new Color(240, 240, 240)));
			btnRectangulo.setBackground(SystemColor.activeCaption);
			cbGrosor.setVisible(false);
			modo = RECTANGULO;
		}
	}
	private class BtnDeshacer1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			imagen1.removeUltimo();
		}
	}
	private class BtnClear1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			imagen1.removeObjetosGraficos();
		}
	}
	private class BtnDeshacer2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			imagen2.removeUltimo();
		}
	}
	private class BtnClear2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			imagen2.removeObjetosGraficos();				
		}
	}
	private class BtnTextoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnRectangulo.setBackground((new Color(240, 240, 240)));
			btnLapiz.setBackground((new Color(240, 240, 240)));
			btnTexto.setBackground(SystemColor.activeCaption);
			cbGrosor.setVisible(true);
			modo = TEXTO;
		}
	}
	private class BtnLapizActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnTexto.setBackground((new Color(240, 240, 240)));
			btnRectangulo.setBackground((new Color(240, 240, 240)));
			btnLapiz.setBackground(SystemColor.activeCaption);
			cbGrosor.setVisible(true);
			modo = LAPIZ;
		}
	}
	private class BtnColorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			colorGraficos = JColorChooser.showDialog(null, "Choose Background Color",null);
			btnColor.setForeground(colorGraficos);
		}
	}
	private class CbGrosorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			transformarSize((String)cbGrosor.getSelectedItem());
		}
	}
}
