package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dominio.Datos;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblEspana;     
	private JLabel lblInglaterra;
	private JRadioButton rdbtnEspaol;
	private JRadioButton rdbtnIngls;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtfUsuario;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblBienvenidoALa;
	private JButton btnEntrar;
	private JLabel lblMensaje;
	private JPasswordField txtfContrasena;
	
	private Datos datos = new Datos();
	private JLabel lblLogo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1900, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			{
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{444, 103, 179, 144, 179, 103, 0, 0};
				gbl_panel.rowHeights = new int[]{59, 121, 0, 28, 0, 0, 0, 0, 40, 66, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					lblEspana = new JLabel("");
					lblEspana.setToolTipText("Pulse para cambiar el idioma a español");
					lblEspana.addMouseListener(new LblEspanaMouseListener());
					{
						lblLogo = new JLabel("");
						lblLogo.setIcon(new ImageIcon(Login.class.getResource("/presentacion/resources/logo.png")));
						GridBagConstraints gbc_lblLogo = new GridBagConstraints();
						gbc_lblLogo.gridwidth = 3;
						gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
						gbc_lblLogo.gridx = 2;
						gbc_lblLogo.gridy = 1;
						panel.add(lblLogo, gbc_lblLogo);
					}
					{
						lblBienvenidoALa = new JLabel("<html>Bienvenido a la aplicación del<br>    hospital Sagrado Corazón</html>");
						lblBienvenidoALa.setFont(new Font("Tahoma", Font.PLAIN, 20));
						GridBagConstraints gbc_lblBienvenidoALa = new GridBagConstraints();
						gbc_lblBienvenidoALa.gridwidth = 3;
						gbc_lblBienvenidoALa.insets = new Insets(0, 0, 5, 5);
						gbc_lblBienvenidoALa.gridx = 2;
						gbc_lblBienvenidoALa.gridy = 2;
						panel.add(lblBienvenidoALa, gbc_lblBienvenidoALa);
					}
					lblEspana.setIcon(new ImageIcon(Login.class.getResource("/presentacion/resources/bandera_espana.png")));
					GridBagConstraints gbc_lblEspana = new GridBagConstraints();
					gbc_lblEspana.gridheight = 7;
					gbc_lblEspana.insets = new Insets(0, 0, 5, 5);
					gbc_lblEspana.gridx = 1;
					gbc_lblEspana.gridy = 3;
					panel.add(lblEspana, gbc_lblEspana);
				}
			}
			{
				lblInglaterra = new JLabel("");
				lblInglaterra.setToolTipText("Pulse para cambiar el idioma a inglés");
				lblInglaterra.addMouseListener(new LblInglaterraMouseListener());
				lblInglaterra.setEnabled(false);
				lblInglaterra.setIcon(new ImageIcon(Login.class.getResource("/presentacion/resources/bandera_inglaterra.png")));
				GridBagConstraints gbc_lblInglaterra = new GridBagConstraints();
				gbc_lblInglaterra.gridheight = 7;
				gbc_lblInglaterra.insets = new Insets(0, 0, 5, 5);
				gbc_lblInglaterra.gridx = 5;
				gbc_lblInglaterra.gridy = 3;
				panel.add(lblInglaterra, gbc_lblInglaterra);
			}
			{
				lblUsuario = new JLabel("Usuario");
				lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
				gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblUsuario.gridx = 3;
				gbc_lblUsuario.gridy = 4;
				panel.add(lblUsuario, gbc_lblUsuario);
			}
			{
				txtfUsuario = new JTextField();
				txtfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_txtfUsuario = new GridBagConstraints();
				gbc_txtfUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_txtfUsuario.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtfUsuario.gridx = 3;
				gbc_txtfUsuario.gridy = 5;
				panel.add(txtfUsuario, gbc_txtfUsuario);
				txtfUsuario.setColumns(10);
			}
			{
				lblContrasea = new JLabel("Contraseña");
				lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
				gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblContrasea.gridx = 3;
				gbc_lblContrasea.gridy = 6;
				panel.add(lblContrasea, gbc_lblContrasea);
			}
			{
				txtfContrasena = new JPasswordField();
				txtfContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_txtfContrasena = new GridBagConstraints();
				gbc_txtfContrasena.insets = new Insets(0, 0, 5, 5);
				gbc_txtfContrasena.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtfContrasena.gridx = 3;
				gbc_txtfContrasena.gridy = 7;
				panel.add(txtfContrasena, gbc_txtfContrasena);
			}
			{
				lblMensaje = new JLabel("");
				lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
				GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
				gbc_lblMensaje.gridwidth = 3;
				gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
				gbc_lblMensaje.gridx = 2;
				gbc_lblMensaje.gridy = 8;
				panel.add(lblMensaje, gbc_lblMensaje);
			}
			{
				btnEntrar = new JButton("Entrar");
				btnEntrar.addActionListener(new BtnEntrarActionListener());
				btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
				gbc_btnEntrar.fill = GridBagConstraints.BOTH;
				gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
				gbc_btnEntrar.gridx = 3;
				gbc_btnEntrar.gridy = 9;
				panel.add(btnEntrar, gbc_btnEntrar);
			}
			{
				rdbtnEspaol = new JRadioButton("Español");
				rdbtnEspaol.setEnabled(false);
				rdbtnEspaol.setFont(new Font("Tahoma", Font.PLAIN, 22));
				rdbtnEspaol.setSelected(true);
				buttonGroup.add(rdbtnEspaol);
				GridBagConstraints gbc_rdbtnEspaol = new GridBagConstraints();
				gbc_rdbtnEspaol.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnEspaol.gridx = 1;
				gbc_rdbtnEspaol.gridy = 10;
				panel.add(rdbtnEspaol, gbc_rdbtnEspaol);
			}
			{
				rdbtnIngls = new JRadioButton("Inglés");
				rdbtnIngls.setEnabled(false);
				rdbtnIngls.setFont(new Font("Tahoma", Font.PLAIN, 22));
				buttonGroup.add(rdbtnIngls);
				GridBagConstraints gbc_rdbtnIngls = new GridBagConstraints();
				gbc_rdbtnIngls.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnIngls.gridx = 5;
				gbc_rdbtnIngls.gridy = 10;
				panel.add(rdbtnIngls, gbc_rdbtnIngls);
			}
		}		
	}
	private class LblEspanaMouseListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			rdbtnEspaol.setSelected(true);
			lblEspana.setEnabled(true);
			lblInglaterra.setEnabled(false);
		}
	}
	private class LblInglaterraMouseListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			rdbtnIngls.setSelected(true);
			lblInglaterra.setEnabled(true);
			lblEspana.setEnabled(false);
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(txtfUsuario.getText().isEmpty() || txtfContrasena.getText().isEmpty()){
				lblMensaje.setForeground(Color.RED);
				lblMensaje.setText("Debe rellenar los dos campos");
			}
			else {
				try {
					if (datos.comprobarLogin(txtfUsuario.getText(), txtfContrasena.getText())){
						datos.setUsuario(txtfUsuario.getText());
						Ventana iu = new Ventana();
						String[]arg = {txtfUsuario.getText()};
						iu.main(arg);
						dispose();
					}
					else{
						lblMensaje.setForeground(Color.RED);
						lblMensaje.setText("Usuario o contraseña incorrectos");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
