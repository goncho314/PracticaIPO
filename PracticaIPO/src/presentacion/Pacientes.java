package presentacion;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JTextField;

import dominio.Datos;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
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
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JTextField txtFecha;
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

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Pacientes(Ventana v, String paciente) throws SQLException {
		ventana = v;
		datos = ventana.getDatos();
		setLayout(new BorderLayout(0, 0));
		{
			splitPane = new JSplitPane();
			add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				splitPane.setLeftComponent(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{79, 65, 0};
				gbl_panel.rowHeights = new int[]{45, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					lblBusqueda = new JLabel("");
					lblBusqueda.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/buscarDocumento-2.png")));
					GridBagConstraints gbc_lblBusqueda = new GridBagConstraints();
					gbc_lblBusqueda.insets = new Insets(0, 0, 5, 5);
					gbc_lblBusqueda.gridx = 0;
					gbc_lblBusqueda.gridy = 0;
					panel.add(lblBusqueda, gbc_lblBusqueda);
				}
				{
					txtBusqueda = new JTextField();
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
						btnAniadir.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/aniadir-2.png")));
						panel_2.add(btnAniadir);
					}
					{
						btnEditar = new JButton("Editar\r\n");
						btnEditar.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/editar-2.png")));
						panel_2.add(btnEditar);
					}
					{
						btnBorrar = new JButton("Borrar");
						btnBorrar.setIcon(new ImageIcon(Pacientes.class.getResource("/presentacion/resources/eliminar-2.png")));
						panel_2.add(btnBorrar);
					}
				}
			}
			{
				JPanel pnlVacio = new JPanel();
				tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				splitPane.setRightComponent(pnlVacio);
				{
					pnlDatos = new JPanel();
					tabbedPane.addTab("Datos", null, pnlDatos, null);
					pnlDatos.setLayout(new MigLayout("", "[46.00px][196px][37.00][16.00][89.00px][198.00px][35.00][303.00][99.00]", "[17.00px][39px][22px][22.00px][22px][22px][22px][22px][22px][22px][22px][][22][110][22][22][110][22][22][143.00]"));
					{
						btnGuardar = new JButton("Guardar");
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
						txtFecha = new JTextField();
						pnlDatos.add(txtFecha, "cell 5 4,growx,aligny center");
						txtFecha.setColumns(10);
					}
					{
						lblSexo = new JLabel("Sexo:");
						pnlDatos.add(lblSexo, "cell 2 6 3 1,alignx right,aligny center");
					}
					{
						cbSexo = new JComboBox();
						cbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
						pnlDatos.add(cbSexo, "cell 5 6");
					}
					{
						lblPais = new JLabel("País:");
						pnlDatos.add(lblPais, "cell 2 8 3 1,alignx right,aligny center");
					}
					{
						txtPais = new JTextField();
						pnlDatos.add(txtPais, "cell 5 8,growx,aligny center");
						txtPais.setColumns(10);
					}
					{
						lblTelfono = new JLabel("Teléfono:");
						pnlDatos.add(lblTelfono, "cell 2 10 3 1,alignx right,aligny center");
					}
					{
						txtTelefono = new JTextField();
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
				}
			}
			actualizarListaPacientes(txtBusqueda.getText());
		}

	}
	
	public void actualizarListaPacientes(String s) throws SQLException{
		datos = ventana.getDatos();
		ArrayList<String> lista = datos.getListaPacientes(s);
		int n = lista.size();
		ModeloTablaPacientes modelo = (ModeloTablaPacientes)table.getModel();
		modelo.eliminaTodo();
		if (n>0){
			for(int i = 0;i<n;i++){
				Object[] fila1= {lista.get(i)};
				modelo.aniadeFila(fila1);
			}
		}
		modelo.fireTableDataChanged();	
	}
	
	public void rellenarInfo(String s) throws SQLException{
		splitPane.setRightComponent(tabbedPane);
		txtNombre.setText((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
		ArrayList<String> lista = datos.getInfoPaciente(s);
		txtFecha.setText(lista.get(0));
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
	}
	
	public void marcarPaciente() throws SQLException{
		txtBusqueda.setText("");
		table.setRowSelectionInterval(0, 0);
		rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(),0));
		splitPane.setRightComponent(tabbedPane);
	}

	private class TxtBusquedaKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			try {
				actualizarListaPacientes(txtBusqueda.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
			}
			else
				try {
					rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				}
		}
	}
	
	private class TableKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==40 || e.getKeyCode()==38)
				try {
					rellenarInfo((String)table.getModel().getValueAt(table.getSelectedRow(), 0));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}	
}
