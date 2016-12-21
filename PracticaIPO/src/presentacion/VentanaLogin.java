package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

import dominio.Datos;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JPanel {
	private JLabel lblLogo;
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
	
	private Datos datos;

	/**
	 * Create the panel.
	 */
	public VentanaLogin() {
		setBounds(0, 0, 1900, 1050);
		datos = new Datos();
		{
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{444, 103, 179, 144, 179, 103, 0, 0};
			gbl_panel.rowHeights = new int[]{59, 121, 0, 28, 0, 0, 0, 0, 40, 66, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gbl_panel);
			{
				lblLogo = new JLabel("\r\n\r\n");
				lblLogo.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/logo.png")));
				GridBagConstraints gbc_lblLogo = new GridBagConstraints();
				gbc_lblLogo.gridwidth = 3;
				gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
				gbc_lblLogo.gridx = 2;
				gbc_lblLogo.gridy = 1;
				add(lblLogo, gbc_lblLogo);
			}
			{
				lblEspana = new JLabel("");
				lblEspana.addMouseListener(new LblEspanaMouseListener());
				{
					lblBienvenidoALa = new JLabel("<html>Bienvenido a la aplicación del<br>    hospital Sagrado Corazón</html>");
					lblBienvenidoALa.setFont(new Font("Tahoma", Font.PLAIN, 20));
					GridBagConstraints gbc_lblBienvenidoALa = new GridBagConstraints();
					gbc_lblBienvenidoALa.gridwidth = 3;
					gbc_lblBienvenidoALa.insets = new Insets(0, 0, 5, 5);
					gbc_lblBienvenidoALa.gridx = 2;
					gbc_lblBienvenidoALa.gridy = 2;
					add(lblBienvenidoALa, gbc_lblBienvenidoALa);
				}
				lblEspana.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/bandera_espana.png")));
				GridBagConstraints gbc_lblEspana = new GridBagConstraints();
				gbc_lblEspana.gridheight = 7;
				gbc_lblEspana.insets = new Insets(0, 0, 5, 5);
				gbc_lblEspana.gridx = 1;
				gbc_lblEspana.gridy = 3;
				add(lblEspana, gbc_lblEspana);
			}
		}
		{
			lblInglaterra = new JLabel("");
			lblInglaterra.addMouseListener(new LblInglaterraMouseListener());
			lblInglaterra.setEnabled(false);
			lblInglaterra.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/bandera_inglaterra.png")));
			GridBagConstraints gbc_lblInglaterra = new GridBagConstraints();
			gbc_lblInglaterra.gridheight = 7;
			gbc_lblInglaterra.insets = new Insets(0, 0, 5, 5);
			gbc_lblInglaterra.gridx = 5;
			gbc_lblInglaterra.gridy = 3;
			add(lblInglaterra, gbc_lblInglaterra);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
			gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsuario.gridx = 3;
			gbc_lblUsuario.gridy = 4;
			add(lblUsuario, gbc_lblUsuario);
		}
		{
			txtfUsuario = new JTextField();
			txtfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_txtfUsuario = new GridBagConstraints();
			gbc_txtfUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_txtfUsuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfUsuario.gridx = 3;
			gbc_txtfUsuario.gridy = 5;
			add(txtfUsuario, gbc_txtfUsuario);
			txtfUsuario.setColumns(10);
		}
		{
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
			gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
			gbc_lblContrasea.gridx = 3;
			gbc_lblContrasea.gridy = 6;
			add(lblContrasea, gbc_lblContrasea);
		}
		{
			txtfContrasena = new JPasswordField();
			txtfContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_txtfContrasena = new GridBagConstraints();
			gbc_txtfContrasena.insets = new Insets(0, 0, 5, 5);
			gbc_txtfContrasena.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfContrasena.gridx = 3;
			gbc_txtfContrasena.gridy = 7;
			add(txtfContrasena, gbc_txtfContrasena);
		}
		{
			lblMensaje = new JLabel("");
			GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
			gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
			gbc_lblMensaje.gridx = 3;
			gbc_lblMensaje.gridy = 8;
			add(lblMensaje, gbc_lblMensaje);
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
			add(btnEntrar, gbc_btnEntrar);
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
			add(rdbtnEspaol, gbc_rdbtnEspaol);
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
			add(rdbtnIngls, gbc_rdbtnIngls);
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
			if(datos.comprobarLogin(txtfUsuario.getText(), txtfContrasena.getText()))
				lblMensaje.setText("OK");
			else
				lblMensaje.setText("Usuario o contraseña incorrectos");
		}
	}
}
