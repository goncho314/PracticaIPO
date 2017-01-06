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
import java.awt.event.KeyEvent;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmAcerca;
	private JMenu mnTamano;
	private JRadioButtonMenuItem rdbtnmntmPequena;
	private JRadioButtonMenuItem rdbtnmntmMediana;
	private int fuente = 13;
	private JRadioButtonMenuItem rdbtnmntmGrande;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datos.setUsuario(args[0]);
					Ventana window = new Ventana();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //$NON-NLS-1$
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
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 19)); //$NON-NLS-1$
			frame.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu(Messages.getString("Ventana.mnArchivo.text"));
				mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
				menuBar.add(mnArchivo);
				{
					mntmAgenda = new JMenuItem(Messages.getString("Ventana.mntmAgenda.text"));
					mntmAgenda.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmAgenda.addActionListener(new MntmAgendaActionListener());
					mntmAgenda.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/calendar-icon3.png"))); //$NON-NLS-1$
					mnArchivo.add(mntmAgenda);
				}
				{
					mntmEspecialistas = new JMenuItem(Messages.getString("Ventana.mntmEspecialistas.text"));
					mntmEspecialistas.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmEspecialistas.addActionListener(new MntmEspecialistasActionListener());
					mntmEspecialistas.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/doctor_icon3.png"))); //$NON-NLS-1$
					mnArchivo.add(mntmEspecialistas);
				}
				{
					mntmPacientes = new JMenuItem(Messages.getString("Ventana.mntmPacientes.text"));
					mntmPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmPacientes.addActionListener(new MntmPacientesActionListener());
					mntmPacientes.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/patient-icon3.png"))); //$NON-NLS-1$
					mnArchivo.add(mntmPacientes);
				}
				{
					separator = new JSeparator();
					mnArchivo.add(separator);
				}
				{
					mntmCerrarSesin = new JMenuItem(Messages.getString("Ventana.mntmCerrarSesin.text"));
					mntmCerrarSesin.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmCerrarSesin.addActionListener(new MntmCerrarSesinActionListener());
					mntmCerrarSesin.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/cerrar-sesion-3.png"))); //$NON-NLS-1$
					mnArchivo.add(mntmCerrarSesin);
				}
				{
					mntmSalir = new JMenuItem(Messages.getString("Ventana.mntmSalir.text"));
					mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmSalir.addActionListener(new MntmSalirActionListener());
					mntmSalir.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/salir.png"))); //$NON-NLS-1$
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEdicion = new JMenu(Messages.getString("Ventana.mnEdicion.text")); //$NON-NLS-1$
				mnEdicion.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
				menuBar.add(mnEdicion);
				{
					mnTamano = new JMenu(Messages.getString("Ventana.mnTamano.text")); //$NON-NLS-1$
					mnTamano.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mnEdicion.add(mnTamano);
					{
						rdbtnmntmPequena = new JRadioButtonMenuItem(Messages.getString("Ventana.rdbtnmntmPequena.text")); //$NON-NLS-1$
						buttonGroup_1.add(rdbtnmntmPequena);
						rdbtnmntmPequena.addActionListener(new RdbtnmntmPequenaActionListener());
						rdbtnmntmPequena.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
						mnTamano.add(rdbtnmntmPequena);
					}
					{
						rdbtnmntmMediana = new JRadioButtonMenuItem(Messages.getString("Ventana.rdbtnmntmMediana.text")); //$NON-NLS-1$
						buttonGroup_1.add(rdbtnmntmMediana);
						rdbtnmntmMediana.addActionListener(new RdbtnmntmMedianaActionListener());
						rdbtnmntmMediana.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
						mnTamano.add(rdbtnmntmMediana);
					}
					{
						rdbtnmntmGrande = new JRadioButtonMenuItem(Messages.getString("Ventana.rdbtnmntmGrande.text")); //$NON-NLS-1$
						rdbtnmntmGrande.addActionListener(new RdbtnmntmGrandeActionListener());
						buttonGroup_1.add(rdbtnmntmGrande);
						rdbtnmntmGrande.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
						mnTamano.add(rdbtnmntmGrande);
					}
					rdbtnmntmPequena.setSelected(true);
				}
			}
			{
				mnAyuda = new JMenu(Messages.getString("Ventana.mnAyuda.text")); //$NON-NLS-1$
				mnAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
				menuBar.add(mnAyuda);
				{
					mntmAcerca = new JMenuItem(Messages.getString("Ventana.mntmAcerca.text")); //$NON-NLS-1$
					mntmAcerca.setFont(new Font("Segoe UI", Font.PLAIN, 18)); //$NON-NLS-1$
					mntmAcerca.addActionListener(new MntmSobreElAutorActionListener());
					mnAyuda.add(mntmAcerca);
				}
			}
		}
		{
			lblEstado = new JLabel(""); //$NON-NLS-1$
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
						btnAgenda = new JButton(Messages.getString("Ventana.btnAgenda.text")); //$NON-NLS-1$
						btnAgenda.setMnemonic(KeyEvent.VK_A);
						btnAgenda.setToolTipText(Messages.getString("Ventana.btnAgenda.toolTipText")); //$NON-NLS-1$
						panel_2.add(btnAgenda);
						btnAgenda.setContentAreaFilled(false);
						btnAgenda.setOpaque(true);
						btnAgenda.addActionListener(new BtnAgendaActionListener());
						btnAgenda.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/calendar-icon2.png"))); //$NON-NLS-1$
						btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
					}
					{
						btnEspecialistas = new JButton(Messages.getString("Ventana.btnEspecialistas.text")); //$NON-NLS-1$
						btnEspecialistas.setMnemonic(KeyEvent.VK_E);
						btnEspecialistas.setToolTipText(Messages.getString("Ventana.btnEspecialistas.toolTipText")); //$NON-NLS-1$
						panel_2.add(btnEspecialistas);
						btnEspecialistas.setContentAreaFilled(false);
						btnEspecialistas.setOpaque(true);
						btnEspecialistas.setBorderPainted(false);
						btnEspecialistas.addActionListener(new BtnEspecialistasActionListener());
						btnEspecialistas.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/doctor_icon2.png"))); //$NON-NLS-1$
						btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
					}
					{
						btnPacientes = new JButton(Messages.getString("Ventana.btnPacientes.text")); //$NON-NLS-1$
						btnPacientes.setMnemonic(KeyEvent.VK_P);
						btnPacientes.setToolTipText(Messages.getString("Ventana.btnPacientes.toolTipText")); //$NON-NLS-1$
						panel_2.add(btnPacientes);
						btnPacientes.setContentAreaFilled(false);
						btnPacientes.setOpaque(true);
						btnPacientes.setBorderPainted(false);
						btnPacientes.addActionListener(new BtnPacientesActionListener());
						btnPacientes.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/patient-icon2.png"))); //$NON-NLS-1$
						btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
					}
				}
				{
					panel_3 = new JPanel();
					panel_3.setMaximumSize(new Dimension(300, 10));
					panel.add(panel_3);
					panel_3.setLayout(new GridLayout(2, 0, 0, 0));
					{
						lblFotoMedico = new JLabel(""); //$NON-NLS-1$
						lblFotoMedico.setVerticalAlignment(SwingConstants.BOTTOM);
						lblFotoMedico.setHorizontalAlignment(SwingConstants.CENTER);
						lblFotoMedico.setIcon(null);
						panel_3.add(lblFotoMedico);
					}
					{
						lblInfoMedico = new JLabel(""); //$NON-NLS-1$
						lblInfoMedico.setHorizontalAlignment(SwingConstants.CENTER);
						lblInfoMedico.setFont(new Font("Tahoma", Font.PLAIN, 26)); //$NON-NLS-1$
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
					pnlContenido.add(pnlFondo, "Fondo"); //$NON-NLS-1$
					pnlAgenda = new Agenda(this);
					pnlContenido.add(pnlAgenda, "Agenda"); //$NON-NLS-1$
					pnlEspecialistas = new Especialistas(this);
					pnlContenido.add(pnlEspecialistas, "Especialistas"); //$NON-NLS-1$
					pnlPacientes = new Pacientes(this, ""); //$NON-NLS-1$
					pnlContenido.add(pnlPacientes, "Pacientes"); //$NON-NLS-1$
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
				btnCerrarSesion = new JButton(Messages.getString("Ventana.btnCerrarSesion.text")); //$NON-NLS-1$
				btnCerrarSesion.setMnemonic(KeyEvent.VK_C);
				btnCerrarSesion.setToolTipText(Messages.getString("Ventana.btnCerrarSesion.toolTipText")); //$NON-NLS-1$
				btnCerrarSesion.addActionListener(new BtnSalirActionListener());
				btnCerrarSesion.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/cerrar-sesion-2.png"))); //$NON-NLS-1$
				btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
				panel_4.add(btnCerrarSesion);
			}
		}
		cambiarFuente();
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
			cl.show(pnlContenido, "Agenda");			 //$NON-NLS-1$
		}
	}
	private class BtnPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(2);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Pacientes"); //$NON-NLS-1$
		}
	}
	private class BtnEspecialistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(3);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Especialistas"); //$NON-NLS-1$
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] botones = {Messages.getString("Ventana.mensajeSi"), Messages.getString("Ventana.mensajeNo")};
			int dialogo = JOptionPane.showOptionDialog(null, Messages.getString("Ventana.45"),Messages.getString("Ventana.46"), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
	        if(dialogo == JOptionPane.YES_OPTION){
				datos.salirAplicacion();
				Login log = new Login();
				log.main(null);
				frame.dispose();
	        }
		}
	}
	public void cambiarFuente(){
		Pacientes pacientes = (Pacientes)pnlContenido.getComponent(3);
		pacientes.cambiarFuente(fuente);
		
		
	}
	public Datos getDatos(){
		return datos;
	}
	
	private void coloresBotones(int num){
		btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
		btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
		btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24)); //$NON-NLS-1$
		btnAgenda.setBackground((new Color(240, 240, 240)));
		btnEspecialistas.setBackground((new Color(240, 240, 240)));
		btnPacientes.setBackground((new Color(240, 240, 240)));
		switch(num){
		case 1:
			btnAgenda.setFont(new Font("Tahoma", Font.BOLD, 36)); //$NON-NLS-1$
			btnAgenda.setBackground(SystemColor.activeCaption);
			break;
		case 2:
			btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 36)); //$NON-NLS-1$
			btnPacientes.setBackground(SystemColor.activeCaption);
			break;
		case 3:
			btnEspecialistas.setFont(new Font("Tahoma", Font.BOLD, 30)); //$NON-NLS-1$
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
		cl.show(pnlContenido, "Pacientes"); //$NON-NLS-1$
	}
	
	private class FrameWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			String[] botones = {Messages.getString("Ventana.mensajeSi"), Messages.getString("Ventana.mensajeNo")};
			int dialogo = JOptionPane.showOptionDialog(null, Messages.getString("Ventana.54"),Messages.getString("Ventana.46"), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
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
			cl.show(pnlContenido, "Agenda"); //$NON-NLS-1$
		}
	}
	private class MntmEspecialistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(3);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Especialistas"); //$NON-NLS-1$
		}
	}
	private class MntmPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(2);
			CardLayout cl = (CardLayout)(pnlContenido.getLayout());
			cl.show(pnlContenido, "Pacientes"); //$NON-NLS-1$
		}
	}
	private class MntmCerrarSesinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] botones = {Messages.getString("Ventana.mensajeSi"), Messages.getString("Ventana.mensajeNo")};
			int dialogo = JOptionPane.showOptionDialog(null, Messages.getString("Ventana.45"),Messages.getString("Ventana.46"), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
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
			String[] botones = {Messages.getString("Ventana.mensajeSi"), Messages.getString("Ventana.mensajeNo")};
			int dialogo = JOptionPane.showOptionDialog(null, Messages.getString("Ventana.61"),Messages.getString("Ventana.46"), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
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
			Object[] botones = {Messages.getString("Ventana.mensajeAceptar")};
			JOptionPane.showOptionDialog (frame, Messages.getString("Ventana.63"), Messages.getString("Ventana.TituloAutor"), JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, botones, 0);
		}
	}
	private class RdbtnmntmPequenaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fuente = 13;
			cambiarFuente();
		}
	}
	private class RdbtnmntmMedianaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fuente = 16;
			cambiarFuente();
		}
	}
	private class RdbtnmntmGrandeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fuente = 19;
			cambiarFuente();
		}
	}
}
