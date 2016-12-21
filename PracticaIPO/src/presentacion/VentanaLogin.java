package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaLogin extends JPanel {
	private JLabel lblLogo;
	private JLabel lblEspana;
	private JLabel lblInglaterra;

	/**
	 * Create the panel.
	 */
	public VentanaLogin() {
		setBounds(0, 0, 1900, 1050);
		{
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{444, 103, 179, 144, 179, 103, 0, 0};
			gbl_panel.rowHeights = new int[]{59, 121, 0, 28, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				lblEspana.setIcon(new ImageIcon(Interfaz.class.getResource("/presentacion/bandera_espana.png")));
				GridBagConstraints gbc_lblEspana = new GridBagConstraints();
				gbc_lblEspana.gridheight = 5;
				gbc_lblEspana.insets = new Insets(0, 0, 5, 5);
				gbc_lblEspana.gridx = 1;
				gbc_lblEspana.gridy = 3;
				add(lblEspana, gbc_lblEspana);
			}
		}
		{
			lblInglaterra = new JLabel("");
			lblInglaterra.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/bandera_inglaterra.png")));
			GridBagConstraints gbc_lblInglaterra = new GridBagConstraints();
			gbc_lblInglaterra.gridheight = 5;
			gbc_lblInglaterra.insets = new Insets(0, 0, 5, 5);
			gbc_lblInglaterra.gridx = 5;
			gbc_lblInglaterra.gridy = 3;
			add(lblInglaterra, gbc_lblInglaterra);
		}

	}

}
