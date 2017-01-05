package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import dominio.Datos;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class Ventana extends JFrame {

	private JFrame frame;
	private JMenuBar menuBar;
	private JLabel lblEstado;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel pnlContenido;
	private JButton btnAgenda;
	private JButton btnPacientes;
	private JButton btnEspecialistas;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnCerrarSesion;
	private JLabel lblFotoMedico;
	private JLabel lblInfoMedico;

	private static Datos datos = new Datos();
	private JPanel pnlFondo;
	private JPanel pnlAgenda;
	private JPanel pnlEspecialistas;
	private JPanel pnlPacientes;
	private JMenu mnArchivo;
	private JMenu mnEdicion;
	private JMenu mnAyuda;
	private JMenuItem mntmAgenda;
	private JMenuItem mntmPacientes;
	private JMenuItem mntmEspecialistas;
	private JSeparator separator;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmSalir;
	private JMenu mnIdioma;
	private JRadioButtonMenuItem rdbtnmntmEspaol;
	private JRadioButtonMenuItem rdbtnmntmIngls;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmAcerca;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datos.setUsuario(args[0]);
					Ventana window = new Ventana();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					window.setExtendedState(window.getExtendedState()|JFrame.MAXIMIZED_BOTH );
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Ventana() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		//frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new FrameWindowListener());
		frame.setBounds(0, 0, 1900, 1050);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				{
					mntmAgenda = new JMenuItem("Agenda");
					mntmAgenda.addActionListener(new MntmAgendaActionListener());
					mntmAgenda.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/calendar-icon3.png")));
					mnArchivo.add(mntmAgenda);
				}
				{
					mntmEspecialistas = new JMenuItem("Especialistas");
					mntmEspecialistas.addActionListener(new MntmEspecialistasActionListener());
					mntmEspecialistas.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/doctor_icon3.png")));
					mnArchivo.add(mntmEspecialistas);
				}
				{
					mntmPacientes = new JMenuItem("Pacientes");
					mntmPacientes.addActionListener(new MntmPacientesActionListener());
					mntmPacientes.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/patient-icon3.png")));
					mnArchivo.add(mntmPacientes);
				}
				{
					separator = new JSeparator();
					mnArchivo.add(separator);
				}
				{
					mntmCerrarSesin = new JMenuItem("Cerrar sesión");
					mntmCerrarSesin.addActionListener(new MntmCerrarSesinActionListener());
					mntmCerrarSesin.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/cerrar-sesion-3.png")));
					mnArchivo.add(mntmCerrarSesin);
				}
				{
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.addActionListener(new MntmSalirActionListener());
					mntmSalir.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/salir.png")));
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEdicion = new JMenu("Edición");
				menuBar.add(mnEdicion);
				{
					mnIdioma = new JMenu("Idioma");
					mnEdicion.add(mnIdioma);
					{
						rdbtnmntmEspaol = new JRadioButtonMenuItem("Español");
						buttonGroup.add(rdbtnmntmEspaol);
						rdbtnmntmEspaol.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/bandera_espana-2.png")));
						mnIdioma.add(rdbtnmntmEspaol);
					}
					{
						rdbtnmntmIngls = new JRadioButtonMenuItem("Inglés");
						buttonGroup.add(rdbtnmntmIngls);
						rdbtnmntmIngls.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/bandera_inglaterra-2.png")));
						mnIdioma.add(rdbtnmntmIngls);
					}
				}
			}
			{
				mnAyuda = new JMenu("Ayuda");
				menuBar.add(mnAyuda);
				{
					mntmAcerca = new JMenuItem("Acerca de...");
					mntmAcerca.addActionListener(new MntmSobreElAutorActionListener());
					mnAyuda.add(mntmAcerca);
				}
			}
		}
		{
			lblEstado = new JLabel("");
			frame.getContentPane().add(lblEstado, BorderLayout.SOUTH);
		}
		{
			splitPane = new JSplitPane();
			splitPane.setPreferredSize(new Dimension(300, 27));
			splitPane.setMaximumSize(new Dimension(300, 27));
			splitPane.setMinimumSize(new Dimension(300, 27));
			frame.getContentPane().add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(300, 10));
				panel.setMaximumSize(new Dimension(1000, 10));
				panel.setMinimumSize(new Dimension(315, 10));
				splitPane.setLeftComponent(panel);
				panel.setLayout(new GridLayout(2, 1, 0, 0));
				{
					panel_2 = new JPanel();
					panel_2.setMaximumSize(new Dimension(300, 10));
					panel.add(panel_2);
					panel_2.setLayout(new GridLayout(3, 0, 0, 0));
					{
						btnAgenda = new JButton("Agenda");
						btnAgenda.setToolTipText("Pulse para ver el calendario con las citas");
						panel_2.add(btnAgenda);
						btnAgenda.setContentAreaFilled(false);
						btnAgenda.setOpaque(true);
						btnAgenda.addActionListener(new BtnAgendaActionListener());
						btnAgenda.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/calendar-icon2.png")));
						btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
					}
					{
						btnEspecialistas = new JButton("Especialistas");
						btnEspecialistas.setToolTipText("Pulse para ver el listado de especialistas");
						panel_2.add(btnEspecialistas);
						btnEspecialistas.setContentAreaFilled(false);
						btnEspecialistas.setOpaque(true);
						btnEspecialistas.setBorderPainted(false);
						btnEspecialistas.addActionListener(new BtnEspecialistasActionListener());
						btnEspecialistas.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/doctor_icon2.png")));
						btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24));
					}
					{
						btnPacientes = new JButton("Pacientes");
						btnPacientes.setToolTipText("Pulse para ver el directorio de pacientes");
						panel_2.add(btnPacientes);
						btnPacientes.setContentAreaFilled(false);
						btnPacientes.setOpaque(true);
						btnPacientes.setBorderPainted(false);
						btnPacientes.addActionListener(new BtnPacientesActionListener());
						btnPacientes.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/patient-icon2.png")));
						btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
					}
				}
				{
					panel_3 = new JPanel();
					panel_3.setMaximumSize(new Dimension(300, 10));
					panel.add(panel_3);
					panel_3.setLayout(new GridLayout(2, 0, 0, 0));
					{
						lblFotoMedico = new JLabel("");
						lblFotoMedico.setVerticalAlignment(SwingConstants.BOTTOM);
						lblFotoMedico.setHorizontalAlignment(SwingConstants.CENTER);
						lblFotoMedico.setIcon(null);
						panel_3.add(lblFotoMedico);
					}
					{
						lblInfoMedico = new JLabel("");
						lblInfoMedico.setHorizontalAlignment(SwingConstants.CENTER);
						lblInfoMedico.setFont(new Font("Tahoma", Font.PLAIN, 26));
						panel_3.add(lblInfoMedico);
						cargarDatosMedico();
					}
				}
			}
			{
				pnlContenido = new JPanel();
				splitPane.setRightComponent(pnlContenido);
				pnlContenido.setLayout(new CardLayout(0, 0));
				{
					pnlFondo = new Fondo();
					pnlContenido.add(pnlFondo, "Fondo");
					pnlAgenda = new Agenda(this);
					pnlContenido.add(pnlAgenda, "Agenda");
					pnlEspecialistas = new Especialistas(this);
					pnlContenido.add(pnlEspecialistas, "Especialistas");
					pnlPacientes = new Pacientes(this, "");
					pnlContenido.add(pnlPacientes, "Pacientes");
				}
			}
		}
		{
			panel_4 = new JPanel();
			panel_4.setPreferredSize(new Dimension(10, 40));
			panel_4.setMinimumSize(new Dimension(10, 40));
			frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
			panel_4.setLayout(new GridLayout(0, 6, 0, 0));
			{
				btnCerrarSesion = new JButton("Cerrar sesión");
				btnCerrarSesion.setToolTipText("Pulse para cerrar la sesión actual");
				btnCerrarSesion.addActionListener(new BtnSalirActionListener());
				btnCerrarSesion.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/cerrar-sesion-2.png")));
				btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 24));
				panel_4.add(btnCerrarSesion);
			}
		}
		/*if(idioma =="ingles")
			rdbtnmntmIngls.setSelected(true);
		else
			rdbtnmntmEspaol.setSelected(true);
			*/
	}

	private class BtnAgendaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(1);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Agenda");			
		}
	}
	private class BtnPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(2);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Pacientes");
		}
	}
	private class BtnEspecialistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(3);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Especialistas");
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int dialogo = JOptionPane.showConfirmDialog (null, "¿Seguro que desea cerrar la sesión?","Confirmación", JOptionPane.YES_NO_OPTION);
	        System.out.println(dialogo);
	        if(dialogo == JOptionPane.YES_OPTION){
				datos.salirAplicacion();
				Login log = new Login();
				log.main(null);
				frame.dispose();
	        }
		}
	}
	
	public Datos getDatos(){
		return datos;
	}
	
	private void coloresBotones(int num){
		btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAgenda.setBackground((new Color(240, 240, 240)));
		btnEspecialistas.setBackground((new Color(240, 240, 240)));
		btnPacientes.setBackground((new Color(240, 240, 240)));
		switch(num){
		case 1:
			btnAgenda.setFont(new Font("Tahoma", Font.BOLD, 36));
			btnAgenda.setBackground(SystemColor.activeCaption);
			break;
		case 2:
			btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 36));
			btnPacientes.setBackground(SystemColor.activeCaption);
			break;
		case 3:
			btnEspecialistas.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnEspecialistas.setBackground(SystemColor.activeCaption);
			break;
			
		}
	}
	
	private void cargarDatosMedico() throws SQLException{
		lblFotoMedico.setIcon(new ImageIcon(Ventana.class.getResource(datos.getFotoMedico())));
		lblInfoMedico.setText(datos.getInfoMedico());
	}
	
	public void verPaciente(String s) throws SQLException, ParseException{
		coloresBotones(2);
		Pacientes pacientes = (Pacientes)pnlContenido.getComponent(3);
		pacientes.cambiarADatos();
		pacientes.actualizarListaPacientes(s);
		pacientes.marcarPaciente();
		CardLayout cl = (CardLayout)(pnlContenido.getLayout());		
		cl.show(pnlContenido, "Pacientes");
	}
	
	private class FrameWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int dialogo = JOptionPane.showConfirmDialog (null, "¿Seguro que desea salir de la aplicación?","Confirmación", JOptionPane.YES_NO_OPTION);
	        if(dialogo == JOptionPane.YES_OPTION){
	        	datos.salirAplicacion();
	        	frame.dispose();
	        }
	        else
	        	frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	private class MntmAgendaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(1);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Agenda");
		}
	}
	private class MntmEspecialistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(3);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Especialistas");
		}
	}
	private class MntmPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(2);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Pacientes");
		}
	}
	private class MntmCerrarSesinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int dialogo = JOptionPane.showConfirmDialog (null, "¿Seguro que desea cerrar la sesión?","Confirmación", JOptionPane.YES_NO_OPTION);
	        System.out.println(dialogo);
	        if(dialogo == JOptionPane.YES_OPTION){
				datos.salirAplicacion();
				Login log = new Login();
				log.main(null);
				frame.dispose();
	        }
		}
	}
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int dialogo = JOptionPane.showConfirmDialog (null, "¿Seguro que desea salir de la aplicación?","Confirmación", JOptionPane.YES_NO_OPTION);
	        if(dialogo == JOptionPane.YES_OPTION){
	        	datos.salirAplicacion();
	        	frame.dispose();
	        }
	        else
	        	frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	private class MntmSobreElAutorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame,"Autor: Gonzalo García Moreno\nFecha: 07/01/2017\nVersión: 1.0", null, JOptionPane.PLAIN_MESSAGE);
		}
	}
}
