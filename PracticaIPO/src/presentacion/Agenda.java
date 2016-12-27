package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Agenda extends JPanel {
	private JSplitPane splitPane;
	private JPanel panel;
	private JButton btnAnterior;
	private JLabel lblMes;
	private JButton btnSiguiente;
	private JPanel panel_1;
	private JButton btnL1;
	private JButton btnL2;
	private JButton btnL3;
	private JButton btnL4;
	private JButton btnL5;
	private JButton btnL6;
	private JButton btnM1;
	private JButton btnM2;
	private JButton btnM3;
	private JButton btnM4;
	private JButton btnM5;
	private JButton btnM6;
	private JButton btnX1;
	private JButton btnX2;
	private JButton btnX3;
	private JButton btnX4;
	private JButton btnX5;
	private JButton btnX6;
	private JButton btnJ1;
	private JButton btnJ2;
	private JButton btnJ3;
	private JButton btnJ4;
	private JButton btnJ5;
	private JButton btnJ6;
	private JButton btnV1;
	private JButton btnV2;
	private JButton btnV3;
	private JButton btnV4;
	private JButton btnV5;
	private JButton btnV6;
	private JButton btnS1;
	private JButton btnS2;
	private JButton btnS3;
	private JButton btnS4;
	private JButton btnS5;
	private JButton btnS6;
	private JButton btnD1;
	private JButton btnD2;
	private JButton btnD3;
	private JButton btnD4;
	private JButton btnD5;
	private JButton btnD6;
	private JLabel lblLunes;
	private JLabel lblMartes;
	private JLabel lblMiercoles;
	private JLabel lblJueves;
	private JLabel lblViernes;
	private JLabel lblSabado;
	private JLabel lblDomingo;
	private Calendar calendar = Calendar.getInstance();
	
	private ArrayList<JButton> botones = new ArrayList();
	private String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	private int mesActual = calendar.get(calendar.MONTH);
	private int yearActual = calendar.get(calendar.YEAR);
	private int diaActual = calendar.get(calendar.DAY_OF_MONTH);
	
	
	private int mes = calendar.get(calendar.MONTH);
	private int year = calendar.get(calendar.YEAR);
	private int dia = calendar.get(calendar.DAY_OF_MONTH);
	

	/**
	 * Create the panel.
	 */
	public Agenda() {
		setLayout(new BorderLayout(0, 0));
		{
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				panel.setMinimumSize(new Dimension(10, 550));
				splitPane.setLeftComponent(panel);
				panel.setLayout(new MigLayout("", "[227.00][170px,grow,center][170px,grow,center][170px,grow,center][170px,grow,center][170px,grow,center][170px,grow,center][170px,grow,center][227]", "[45][][grow][grow][grow][grow][grow][grow]"));
				{
					btnAnterior = new JButton("");
					btnAnterior.setIcon(new ImageIcon(Agenda.class.getResource("/presentacion/resources/anterior.png")));
					btnAnterior.addActionListener(new BtnAnteriorActionListener());
					panel.add(btnAnterior, "cell 1 0,grow");
				}
				{
					lblMes = new JLabel("DICIEMBRE 2016");
					lblMes.setHorizontalAlignment(SwingConstants.CENTER);
					lblMes.setFont(new Font("Tahoma", Font.PLAIN, 28));
					panel.add(lblMes, "cell 2 0 5 1,grow");
				}
				{
					btnSiguiente = new JButton("");
					btnSiguiente.setIcon(new ImageIcon(Agenda.class.getResource("/presentacion/resources/siguiente.png")));
					btnSiguiente.addActionListener(new BtnSiguienteActionListener());
					panel.add(btnSiguiente, "cell 7 0,grow");
				}
				{
					lblLunes = new JLabel("Lunes");
					lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
					lblLunes.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblLunes, "cell 1 1");
				}
				{
					lblMartes = new JLabel("Martes");
					lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
					lblMartes.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblMartes, "cell 2 1");
				}
				{
					lblMiercoles = new JLabel("Miercoles");
					lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
					lblMiercoles.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblMiercoles, "cell 3 1");
				}
				{
					lblJueves = new JLabel("Jueves");
					lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
					lblJueves.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblJueves, "cell 4 1");
				}
				{
					lblViernes = new JLabel("Viernes");
					lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
					lblViernes.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblViernes, "cell 5 1");
				}
				{
					lblSabado = new JLabel("Sabado");
					lblSabado.setHorizontalAlignment(SwingConstants.CENTER);
					lblSabado.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblSabado, "cell 6 1");
				}
				{
					lblDomingo = new JLabel("Domingo");
					lblDomingo.setHorizontalAlignment(SwingConstants.CENTER);
					lblDomingo.setFont(new Font("Tahoma", Font.PLAIN, 20));
					panel.add(lblDomingo, "cell 7 1");
				}
				{
					btnL1 = new JButton("");
					btnL1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL1.setContentAreaFilled(false);
					btnL1.setOpaque(false);
					panel.add(btnL1, "cell 1 2,grow");
				}
				{
					btnM1 = new JButton("");
					btnM1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM1.setContentAreaFilled(false);
					btnM1.setOpaque(true);
					panel.add(btnM1, "cell 2 2,grow");
				}
				{
					btnX1 = new JButton("");
					btnX1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX1.setContentAreaFilled(false);
					btnX1.setOpaque(true);
					panel.add(btnX1, "cell 3 2,grow");
				}
				{
					btnJ1 = new JButton("");
					btnJ1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ1.setContentAreaFilled(false);
					btnJ1.setOpaque(true);
					panel.add(btnJ1, "cell 4 2,grow");
				}
				{
					btnV1 = new JButton("");
					btnV1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV1.setContentAreaFilled(false);
					btnV1.setOpaque(true);
					panel.add(btnV1, "cell 5 2,grow");
				}
				{
					btnS1 = new JButton("");
					btnS1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS1.setContentAreaFilled(false);
					btnS1.setOpaque(true);
					panel.add(btnS1, "cell 6 2,grow");
				}
				{
					btnD1 = new JButton("");
					btnD1.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD1.setContentAreaFilled(false);
					btnD1.setOpaque(true);
					panel.add(btnD1, "cell 7 2,grow");
				}
				{
					btnL2 = new JButton("");
					btnL2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL2.setContentAreaFilled(false);
					btnL2.setOpaque(true);
					panel.add(btnL2, "cell 1 3,grow");
				}
				{
					btnM2 = new JButton("");
					btnM2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM2.setContentAreaFilled(false);
					btnM2.setOpaque(true);
					panel.add(btnM2, "cell 2 3,grow");
				}
				{
					btnX2 = new JButton("");
					btnX2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX2.setContentAreaFilled(false);
					btnX2.setOpaque(true);
					panel.add(btnX2, "cell 3 3,grow");
				}
				{
					btnJ2 = new JButton("");
					btnJ2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ2.setContentAreaFilled(false);
					btnJ2.setOpaque(true);
					panel.add(btnJ2, "cell 4 3,grow");
				}
				{
					btnV2 = new JButton("");
					btnV2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV2.setContentAreaFilled(false);
					btnV2.setOpaque(true);
					panel.add(btnV2, "cell 5 3,grow");
				}
				{
					btnS2 = new JButton("");
					btnS2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS2.setContentAreaFilled(false);
					btnS2.setOpaque(true);
					panel.add(btnS2, "cell 6 3,grow");
				}
				{
					btnD2 = new JButton("");
					btnD2.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD2.setContentAreaFilled(false);
					btnD2.setOpaque(true);
					panel.add(btnD2, "cell 7 3,grow");
				}
				{
					btnL3 = new JButton("");
					btnL3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL3.setContentAreaFilled(false);
					btnL3.setOpaque(true);
					panel.add(btnL3, "cell 1 4,grow");
				}
				{
					btnM3 = new JButton("");
					btnM3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM3.setContentAreaFilled(false);
					btnM3.setOpaque(true);
					panel.add(btnM3, "cell 2 4,grow");
				}
				{
					btnX3 = new JButton("");
					btnX3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX3.setContentAreaFilled(false);
					btnX3.setOpaque(true);
					panel.add(btnX3, "cell 3 4,grow");
				}
				{
					btnJ3 = new JButton("");
					btnJ3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ3.setContentAreaFilled(false);
					btnJ3.setOpaque(true);
					panel.add(btnJ3, "cell 4 4,grow");
				}
				{
					btnV3 = new JButton("");
					btnV3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV3.setContentAreaFilled(false);
					btnV3.setOpaque(true);
					panel.add(btnV3, "cell 5 4,grow");
				}
				{
					btnS3 = new JButton("");
					btnS3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS3.setContentAreaFilled(false);
					btnS3.setOpaque(true);
					panel.add(btnS3, "cell 6 4,grow");
				}
				{
					btnD3 = new JButton("");
					btnD3.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD3.setContentAreaFilled(false);
					btnD3.setOpaque(true);
					panel.add(btnD3, "cell 7 4,grow");
				}
				{
					btnL4 = new JButton("");
					btnL4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL4.setContentAreaFilled(false);
					btnL4.setOpaque(true);
					panel.add(btnL4, "cell 1 5,grow");
				}
				{
					btnM4 = new JButton("");
					btnM4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM4.setContentAreaFilled(false);
					btnM4.setOpaque(true);
					panel.add(btnM4, "cell 2 5,grow");
				}
				{
					btnX4 = new JButton("");
					btnX4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX4.setContentAreaFilled(false);
					btnX4.setOpaque(true);
					panel.add(btnX4, "cell 3 5,grow");
				}
				{
					btnJ4 = new JButton("");
					btnJ4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ4.setContentAreaFilled(false);
					btnJ4.setOpaque(true);
					panel.add(btnJ4, "cell 4 5,grow");
				}
				{
					btnV4 = new JButton("");
					btnV4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV4.setContentAreaFilled(false);
					btnV4.setOpaque(true);
					panel.add(btnV4, "cell 5 5,grow");
				}
				{
					btnS4 = new JButton("");
					btnS4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS4.setContentAreaFilled(false);
					btnS4.setOpaque(true);
					panel.add(btnS4, "cell 6 5,grow");
				}
				{
					btnD4 = new JButton("");
					btnD4.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD4.setContentAreaFilled(false);
					btnD4.setOpaque(true);
					panel.add(btnD4, "cell 7 5,grow");
				}
				{
					btnL5 = new JButton("");
					btnL5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL5.setContentAreaFilled(false);
					btnL5.setOpaque(true);
					panel.add(btnL5, "cell 1 6,grow");
				}
				{
					btnM5 = new JButton("");
					btnM5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM5.setContentAreaFilled(false);
					btnM5.setOpaque(true);
					panel.add(btnM5, "cell 2 6,grow");
				}
				{
					btnX5 = new JButton("");
					btnX5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX5.setContentAreaFilled(false);
					btnX5.setOpaque(true);
					panel.add(btnX5, "cell 3 6,grow");
				}
				{
					btnJ5 = new JButton("");
					btnJ5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ5.setContentAreaFilled(false);
					btnJ5.setOpaque(true);
					panel.add(btnJ5, "cell 4 6,grow");
				}
				{
					btnV5 = new JButton("");
					btnV5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV5.setContentAreaFilled(false);
					btnV5.setOpaque(true);
					panel.add(btnV5, "cell 5 6,grow");
				}
				{
					btnS5 = new JButton("");
					btnS5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS5.setContentAreaFilled(false);
					btnS5.setOpaque(true);
					panel.add(btnS5, "cell 6 6,grow");
				}
				{
					btnD5 = new JButton("");
					btnD5.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD5.setContentAreaFilled(false);
					btnD5.setOpaque(true);
					panel.add(btnD5, "cell 7 6,grow");
				}
				{
					btnL6 = new JButton("");
					btnL6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnL6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnL6.setContentAreaFilled(false);
					btnL6.setOpaque(true);
					panel.add(btnL6, "cell 1 7,grow");
				}
				{
					btnM6 = new JButton("");
					btnM6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnM6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnM6.setContentAreaFilled(false);
					btnM6.setOpaque(true);
					panel.add(btnM6, "cell 2 7,grow");
				}
				{
					btnX6 = new JButton("");
					btnX6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnX6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnX6.setContentAreaFilled(false);
					btnX6.setOpaque(true);
					panel.add(btnX6, "cell 3 7,grow");
				}
				{
					btnJ6 = new JButton("");
					btnJ6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnJ6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnJ6.setContentAreaFilled(false);
					btnJ6.setOpaque(true);
					panel.add(btnJ6, "cell 4 7,grow");
				}
				{
					btnV6 = new JButton("");
					btnV6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnV6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnV6.setContentAreaFilled(false);
					btnV6.setOpaque(true);
					panel.add(btnV6, "cell 5 7,grow");
				}
				{
					btnS6 = new JButton("");
					btnS6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnS6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnS6.setContentAreaFilled(false);
					btnS6.setOpaque(true);
					panel.add(btnS6, "cell 6 7,grow");
				}
				{
					btnD6 = new JButton("");
					btnD6.setFont(new Font("Tahoma", Font.PLAIN, 30));
					btnD6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					btnD6.setContentAreaFilled(false);
					btnD6.setOpaque(true);
					panel.add(btnD6, "cell 7 7,grow");
				}	
			}
			{
				panel_1 = new JPanel();
				splitPane.setRightComponent(panel_1);
			}
			addBotones();
			colocarNumeros();
		}

	}
	public void colocarNumeros(){
		vaciarBotones();		
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(calendar.DAY_OF_WEEK));
		Calendar tmp = new GregorianCalendar(year, mes, 1);
		System.out.println("tmp "+tmp.getTime());
		int inicio = tmp.get(tmp.DAY_OF_WEEK)-2;
		if(inicio<0)
			inicio += 7;
		System.out.println(inicio);
		int diasMes = tmp.getActualMaximum(tmp.DAY_OF_MONTH);
		System.out.println("Inicio: "+inicio);
		for(int i = inicio;i<inicio+diasMes;i++){
			botones.get(i).setText(String.valueOf((i-inicio+1)));
		}
		marcarHoy();
	}
	
	public void addBotones(){
		botones.add(btnL1);
		botones.add(btnM1);
		botones.add(btnX1);
		botones.add(btnJ1);
		botones.add(btnV1);
		botones.add(btnS1);
		botones.add(btnD1);
		botones.add(btnL2);
		botones.add(btnM2);
		botones.add(btnX2);
		botones.add(btnJ2);
		botones.add(btnV2);
		botones.add(btnS2);
		botones.add(btnD2);
		botones.add(btnL3);
		botones.add(btnM3);
		botones.add(btnX3);
		botones.add(btnJ3);
		botones.add(btnV3);
		botones.add(btnS3);
		botones.add(btnD3);
		botones.add(btnL4);
		botones.add(btnM4);
		botones.add(btnX4);
		botones.add(btnJ4);
		botones.add(btnV4);
		botones.add(btnS4);
		botones.add(btnD4);
		botones.add(btnL5);
		botones.add(btnM5);
		botones.add(btnX5);
		botones.add(btnJ5);
		botones.add(btnV5);
		botones.add(btnS5);
		botones.add(btnD5);
		botones.add(btnL6);
		botones.add(btnM6);
		botones.add(btnX6);
		botones.add(btnJ6);
		botones.add(btnV6);
		botones.add(btnS6);
		botones.add(btnD6);
	}
	
	public void vaciarBotones(){
		for(int i = 0;i<botones.size();i++){
			botones.get(i).setText("");
			botones.get(i).setBackground(new Color(240,240,240));
		}
	}
	
	public void marcarHoy(){
		boolean seguir = true;
		if(mes==mesActual && year==yearActual){
			for(int i = 0;i<botones.size() && seguir;i++){
				if(botones.get(i).getText().equals(String.valueOf(dia))){
					botones.get(i).setBackground(new Color(255,255,153));
					seguir = false;
				}
			}
		}
	}

	private class BtnAnteriorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mes -= 1;
			if(mes<0){
				mes = 11;
				year -= 1;
			}
			colocarNumeros();
			lblMes.setText(meses[mes]+" "+year);
		}
	}
	private class BtnSiguienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mes += 1;
			if(mes>11){
				mes = 0;
				year += 1;
			}	
			colocarNumeros();
			lblMes.setText(meses[mes]+" "+year);
		}
	}
}