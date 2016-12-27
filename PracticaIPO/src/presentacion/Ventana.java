package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dominio.Datos;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class Ventana extends JFrame {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem mntmArchivo;
	private JLabel lblEstado;
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnAgenda;
	private JButton btnPacientes;
	private JButton btnEspecialistas;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnSalir;
	private JLabel lblFotoMedico;
	private JLabel lblInfoMedico;

	private static Datos datos = new Datos();
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
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1900, 1050);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				mntmArchivo = new JMenuItem("Archivo");
				menuBar.add(mntmArchivo);
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
						panel_2.add(btnAgenda);
						btnAgenda.addActionListener(new BtnAgendaActionListener());
						btnAgenda.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/calendar-icon2.png")));
						btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
					}
					{
						btnPacientes = new JButton("Pacientes");
						panel_2.add(btnPacientes);
						btnPacientes.addActionListener(new BtnPacientesActionListener());
						btnPacientes.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/patient-icon2.png")));
						btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
					}
					{
						btnEspecialistas = new JButton("Especialistas");
						panel_2.add(btnEspecialistas);
						btnEspecialistas.addActionListener(new BtnEspecialistasActionListener());
						btnEspecialistas.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/doctor_icon2.png")));
						btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
				panel_1 = new JPanel();
				splitPane.setRightComponent(panel_1);
				panel_1.setLayout(new CardLayout(0, 0));
			}
		}
		{
			panel_4 = new JPanel();
			panel_4.setPreferredSize(new Dimension(10, 40));
			panel_4.setMinimumSize(new Dimension(10, 40));
			frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
			panel_4.setLayout(new GridLayout(0, 6, 0, 0));
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new BtnSalirActionListener());
				btnSalir.setIcon(new ImageIcon(Ventana.class.getResource("/presentacion/resources/salir.png")));
				btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 24));
				panel_4.add(btnSalir);
			}
		}
	}

	private class BtnAgendaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(1);
		}
	}
	private class BtnPacientesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(2);
		}
	}
	private class BtnEspecialistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			coloresBotones(3);
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Login log = new Login();
			log.main(null);
			frame.dispose();
		}
	}
	
	private void coloresBotones(int num){
		btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		switch(num){
		case 1:
			btnAgenda.setFont(new Font("Tahoma", Font.BOLD, 36));
			break;
		case 2:
			btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 36));
			break;
		case 3:
			btnEspecialistas.setFont(new Font("Tahoma", Font.BOLD, 30));
			break;
			
		}
	}
	
	private void cargarDatosMedico(){
		lblFotoMedico.setIcon(new ImageIcon(Ventana.class.getResource(datos.getFotoMedico())));
		lblInfoMedico.setText(datos.getInfoMedico());
	}
}
