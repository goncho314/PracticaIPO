package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Interfaz {

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
	private JLabel lblVacio1;
	private JLabel lblVacio2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
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
			frame.getContentPane().add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				panel.setMinimumSize(new Dimension(250, 10));
				splitPane.setLeftComponent(panel);
				panel.setLayout(new GridLayout(9, 1, 0, 0));
				{
					btnAgenda = new JButton("Agenda");
					btnAgenda.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/calendar-icon2.png")));
					btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 24));
					panel.add(btnAgenda);
				}
				{
					btnPacientes = new JButton("Pacientes");
					btnPacientes.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/patient-icon2.png")));
					btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
					panel.add(btnPacientes);
				}
				{
					btnEspecialistas = new JButton("Especialistas");
					btnEspecialistas.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/doctor_icon2.png")));
					btnEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 24));
					panel.add(btnEspecialistas);
				}
				{
					lblVacio1 = new JLabel("");
					panel.add(lblVacio1);
				}
				{
					lblVacio2 = new JLabel("");
					panel.add(lblVacio2);
				}
			}
			{
				panel_1 = new JPanel();
				splitPane.setRightComponent(panel_1);
			}
		}
	}

}
