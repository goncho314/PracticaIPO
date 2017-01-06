package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Correo extends JPanel {
	private JTextField txtAsunto;
	private JButton btnEnviar;
	private JButton btnAdjuntar;
	private JLabel lblAsunto;
	private JLabel lblMensaje;
	private JLabel label;
	private JTextArea txtaMensaje;
	private JLabel lblAdjuntos;
	private int adjuntos = 0;

	/**
	 * Create the panel.
	 */
	public Correo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{79, 0, 789, 21, 109, 0};
		gridBagLayout.rowHeights = new int[]{74, 42, 18, 243, 43, 70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			add(label, gbc_label);
		}
		{
			lblAsunto = new JLabel(Messages.getString("Correo.lblAsunto.text")); //$NON-NLS-1$
			lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
			gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
			gbc_lblAsunto.anchor = GridBagConstraints.EAST;
			gbc_lblAsunto.gridx = 1;
			gbc_lblAsunto.gridy = 1;
			add(lblAsunto, gbc_lblAsunto);
		}
		{
			txtAsunto = new JTextField();
			txtAsunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_txtAsunto = new GridBagConstraints();
			gbc_txtAsunto.insets = new Insets(0, 0, 5, 5);
			gbc_txtAsunto.fill = GridBagConstraints.BOTH;
			gbc_txtAsunto.gridx = 2;
			gbc_txtAsunto.gridy = 1;
			add(txtAsunto, gbc_txtAsunto);
			txtAsunto.setColumns(10);
		}
		{
			lblMensaje = new JLabel(Messages.getString("Correo.lblMensaje.text")); //$NON-NLS-1$
			lblMensaje.setVerticalAlignment(SwingConstants.TOP);
			lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
			gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
			gbc_lblMensaje.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblMensaje.gridx = 1;
			gbc_lblMensaje.gridy = 3;
			add(lblMensaje, gbc_lblMensaje);
		}
		{
			txtaMensaje = new JTextArea();
			txtaMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtaMensaje.setLineWrap(true);
			txtaMensaje.setWrapStyleWord(true);
			GridBagConstraints gbc_txtaMensaje = new GridBagConstraints();
			gbc_txtaMensaje.insets = new Insets(0, 0, 5, 5);
			gbc_txtaMensaje.fill = GridBagConstraints.BOTH;
			gbc_txtaMensaje.gridx = 2;
			gbc_txtaMensaje.gridy = 3;
			add(txtaMensaje, gbc_txtaMensaje);
		}
		{
			btnEnviar = new JButton(Messages.getString("Correo.btnEnviar.text")); //$NON-NLS-1$
			btnEnviar.setToolTipText(Messages.getString("Correo.btnEnviar.toolTipText")); //$NON-NLS-1$
			btnEnviar.addActionListener(new BtnEnviarActionListener());
			btnEnviar.setHorizontalAlignment(SwingConstants.LEADING);
			btnEnviar.setIcon(new ImageIcon(Correo.class.getResource("/presentacion/resources/enviar-2.png")));
			btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
			gbc_btnEnviar.insets = new Insets(0, 0, 5, 0);
			gbc_btnEnviar.gridx = 4;
			gbc_btnEnviar.gridy = 3;
			add(btnEnviar, gbc_btnEnviar);
		}
		{
			btnAdjuntar = new JButton(Messages.getString("Correo.btnAdjuntar.text")); //$NON-NLS-1$
			btnAdjuntar.setToolTipText(Messages.getString("Correo.btnAdjuntar.toolTipText")); //$NON-NLS-1$
			btnAdjuntar.addActionListener(new BtnAdjuntarActionListener());
			btnAdjuntar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnAdjuntar.setIcon(new ImageIcon(Correo.class.getResource("/presentacion/resources/adjuntar-2.png")));
			GridBagConstraints gbc_btnAdjuntar = new GridBagConstraints();
			gbc_btnAdjuntar.anchor = GridBagConstraints.WEST;
			gbc_btnAdjuntar.fill = GridBagConstraints.VERTICAL;
			gbc_btnAdjuntar.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdjuntar.gridx = 2;
			gbc_btnAdjuntar.gridy = 4;
			add(btnAdjuntar, gbc_btnAdjuntar);
		}
		{
			lblAdjuntos = new JLabel("");
			lblAdjuntos.setVerticalTextPosition(SwingConstants.TOP);
			lblAdjuntos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblAdjuntos = new GridBagConstraints();
			gbc_lblAdjuntos.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblAdjuntos.insets = new Insets(0, 0, 0, 5);
			gbc_lblAdjuntos.gridx = 2;
			gbc_lblAdjuntos.gridy = 5;
			add(lblAdjuntos, gbc_lblAdjuntos);
		}

	}
	
	public String archivosAdjuntos(){
		String s = "";
		if(adjuntos==1)
			s = " archivo adjunto.";
		else
			s = " archivos adjuntos.";
		return adjuntos+s;
	}

	private class BtnAdjuntarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(getParent());
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				ImageIcon icon;
				icon = new ImageIcon(Correo.class.getResource("/presentacion/resources/tick-2.png"));
				JOptionPane.showMessageDialog(null, fcAbrir.getSelectedFile().getName()+" cargado correctamente.", "Adjuntar archivo", JOptionPane.PLAIN_MESSAGE, icon);
				adjuntos++;
				lblAdjuntos.setText(archivosAdjuntos());
			}
			else
				System.out.println("El usuario ha cancelado el proceso de lectura.");
		}
	}
	private class BtnEnviarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ImageIcon icon;
			if(txtAsunto.getText().equals("") || txtaMensaje.getText().equals("")){
				icon = new ImageIcon(Correo.class.getResource("/presentacion/resources/error-2.png"));
				JOptionPane.showMessageDialog(null, "No se pudo enviar. Debe rellenar todos los campos.", "Mensaje", JOptionPane.PLAIN_MESSAGE, icon);
			}
			else{
				icon = new ImageIcon(Correo.class.getResource("/presentacion/resources/tick-2.png"));
				JOptionPane.showMessageDialog(null, "Mensaje enviado.", "Mensaje", JOptionPane.PLAIN_MESSAGE, icon);
			}
		}
	}
}
