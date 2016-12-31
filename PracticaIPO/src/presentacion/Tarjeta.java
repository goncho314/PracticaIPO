package presentacion;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tarjeta extends JPanel {
	Especialistas especialistas;
	public Tarjeta(Especialistas esp) {
		especialistas = esp;
		setLayout(null);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblNombre.setBounds(174, 93, 305, 35);
			add(lblNombre);
		}
		{
			lblEspecialidad = new JLabel("Especialidad");
			lblEspecialidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblEspecialidad.setBounds(174, 175, 305, 37);
			add(lblEspecialidad);
		}
		{
			lblHorario = new JLabel("Horario");
			lblHorario.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblHorario.setBounds(174, 257, 305, 32);
			add(lblHorario);
		}
		{
			lblDespacho = new JLabel("Despacho");
			lblDespacho.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			lblDespacho.setBounds(174, 339, 305, 35);
			add(lblDespacho);
		}
		{
			lblFoto = new JLabel("");
			lblFoto.setIcon(null);
			lblFoto.setBounds(491, 185, 186, 230);
			add(lblFoto);
		}
		{
			btnContactar = new JButton("Contactar");
			btnContactar.addActionListener(new BtnContactarActionListener());
			btnContactar.setIcon(new ImageIcon(Tarjeta.class.getResource("/presentacion/resources/mail.png")));
			btnContactar.setBounds(491, 41, 186, 120);
			add(btnContactar);
		}
		{
			lblNombre2 = new JLabel("");
			lblNombre2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombre2.setBounds(174, 131, 305, 37);
			add(lblNombre2);
		}
		{
			lblEspecialidad2 = new JLabel("");
			lblEspecialidad2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblEspecialidad2.setBounds(174, 213, 305, 37);
			add(lblEspecialidad2);
		}
		{
			lblHorario2 = new JLabel("");
			lblHorario2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblHorario2.setBounds(174, 295, 305, 37);
			add(lblHorario2);
		}
		{
			lblDespacho2 = new JLabel("");
			lblDespacho2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblDespacho2.setBounds(174, 377, 305, 38);
			add(lblDespacho2);
		}
	}
    Image image = new ImageIcon(Fondo.class.getResource("/presentacion/resources/tarjeta-3.png")).getImage();
    private JLabel lblNombre;
    private JLabel lblEspecialidad;
    private JLabel lblHorario;
    private JLabel lblDespacho;
    private JLabel lblFoto;
    private JButton btnContactar;
    private JLabel lblNombre2;
    private JLabel lblEspecialidad2;
    private JLabel lblHorario2;
    private JLabel lblDespacho2;
 
    public void paint(Graphics g){
        g.drawImage(image, 20, 20, image.getWidth(null)+20, image.getHeight(null)+20, this);
        setOpaque(false);
        super.paint(g);
    }
    
    public void setValores(String nombre, String especialidad,  String horario, String despacho, String foto){
		lblNombre2.setText(nombre);
		lblEspecialidad2.setText(especialidad);
		lblHorario2.setText(horario);
		lblDespacho2.setText(despacho);
		lblFoto.setIcon(new ImageIcon(Ventana.class.getResource(foto)));
    }
	private class BtnContactarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			especialistas.mostrarCorreo();
		}
	}
}
