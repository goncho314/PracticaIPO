package presentacion;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.UIManager;

import dominio.Datos;

import java.awt.BorderLayout;

public class Interfaz {

	private JFrame frame;
	private VentanaLogin panelLogin;

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
			panelLogin = new VentanaLogin();
			frame.getContentPane().add(panelLogin, BorderLayout.CENTER);
			
		}
	}

}
