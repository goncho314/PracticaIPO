package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import dominio.Datos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Especialistas extends JPanel {
	private JSplitPane splitPane;
	private JPanel panel;
	private JPanel panel_1;
	
	public Ventana v;
	private static Datos datos;
	private JSplitPane splitPane_1;
	private JPanel panel_2;
	private JLabel lblBusqueda;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtBusqueda;
	private JPanel panel_3;
	private JPanel pnlTarjeta;
	private JLabel label;
	private Correo pnlCorreo;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Especialistas(Ventana ventana) throws SQLException {
		v = ventana;
		setLayout(new BorderLayout(0, 0));
		{
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			add(splitPane, BorderLayout.CENTER);
			{
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(10, 500));
				panel.setMinimumSize(new Dimension(10, 500));
				splitPane.setLeftComponent(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					splitPane_1 = new JSplitPane();
					panel.add(splitPane_1, BorderLayout.CENTER);
					{
						panel_2 = new JPanel();
						panel_2.setPreferredSize(new Dimension(600, 10));
						panel_2.setMaximumSize(new Dimension(500, 32767));
						panel_2.setMinimumSize(new Dimension(600, 10));
						splitPane_1.setLeftComponent(panel_2);
						GridBagLayout gbl_panel_2 = new GridBagLayout();
						gbl_panel_2.columnWidths = new int[]{111, 69, 276, 16, 0};
						gbl_panel_2.rowHeights = new int[]{0, 0, 211, 0};
						gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
						gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
						panel_2.setLayout(gbl_panel_2);
						{
							label = new JLabel("");
							GridBagConstraints gbc_label = new GridBagConstraints();
							gbc_label.insets = new Insets(0, 0, 5, 5);
							gbc_label.gridx = 0;
							gbc_label.gridy = 0;
							panel_2.add(label, gbc_label);
						}
						{
							lblBusqueda = new JLabel("");
							lblBusqueda.setIcon(new ImageIcon(Especialistas.class.getResource("/presentacion/resources/busqueda-2.png")));
							GridBagConstraints gbc_lblBusqueda = new GridBagConstraints();
							gbc_lblBusqueda.anchor = GridBagConstraints.EAST;
							gbc_lblBusqueda.insets = new Insets(0, 0, 5, 5);
							gbc_lblBusqueda.gridx = 1;
							gbc_lblBusqueda.gridy = 1;
							panel_2.add(lblBusqueda, gbc_lblBusqueda);
						}
						{
							txtBusqueda = new JTextField();
							txtBusqueda.addKeyListener(new TxtBusquedaKeyListener());
							GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
							gbc_txtBusqueda.insets = new Insets(0, 0, 5, 5);
							gbc_txtBusqueda.fill = GridBagConstraints.HORIZONTAL;
							gbc_txtBusqueda.gridx = 2;
							gbc_txtBusqueda.gridy = 1;
							panel_2.add(txtBusqueda, gbc_txtBusqueda);
							txtBusqueda.setColumns(10);
						}
						{
							scrollPane = new JScrollPane();
							GridBagConstraints gbc_scrollPane = new GridBagConstraints();
							gbc_scrollPane.gridwidth = 2;
							gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
							gbc_scrollPane.fill = GridBagConstraints.BOTH;
							gbc_scrollPane.gridx = 1;
							gbc_scrollPane.gridy = 2;
							panel_2.add(scrollPane, gbc_scrollPane);
							{
								table = new JTable();
								table.addMouseListener(new TableMouseListener());
								table.addKeyListener(new TableKeyListener());
								scrollPane.setViewportView(table);
								table.setFont(new Font("Tahoma", Font.PLAIN, 22));
								ModeloTablaEspecialistas modeloTabla = new ModeloTablaEspecialistas();
								table.setModel(modeloTabla);
								{
									panel_3 = new JPanel();
									panel_3.setMinimumSize(new Dimension(500, 10));
									splitPane_1.setRightComponent(panel_3);
								}
								table.getColumnModel().getColumn(0).setMinWidth(200);
								table.getColumnModel().getColumn(1).setMinWidth(790);
								table.getColumnModel().getColumn(1).setWidth(790);
								table.setRowHeight(30);
							}
						}
					}
				}
				{
					{
						ModeloTablaEspecialistas modeloTabla = new ModeloTablaEspecialistas();
					}
				}
			}
			{			
				
				panel_1 = new JPanel();
				panel_1.setPreferredSize(new Dimension(10, 100));
				splitPane.setRightComponent(panel_1);
			}
			actualizarLista("");
		}
	}
	
	public void actualizarLista(String s) throws SQLException{
		datos = v.getDatos();
		ArrayList<String> lista = datos.getListaEspecialistas(s);
		int n = lista.size();
		ModeloTablaEspecialistas modelo = (ModeloTablaEspecialistas)table.getModel();
		modelo.eliminaTodo();
		if (n>0){
			for(int i = 0;i<n;i+=2){
				Object[] fila1= {lista.get(i), lista.get(i+1)};
				modelo.aniadeFila(fila1);
			}
		}
		modelo.fireTableDataChanged();	
	}
	
	public void rellenarInformacion(JPanel t, String s) throws SQLException{
		datos = v.getDatos();
		ArrayList<String> info = datos.getInfoEspecialistas(s);
		((Tarjeta) t).setValores(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4));
		t.setVisible(true);
	}
	
	public void vaciarInformacion(){
		panel_3.setVisible(false);
	}
	
	public void ponerTarjeta(){
		pnlTarjeta = new Tarjeta(this);
		splitPane_1.setRightComponent(pnlTarjeta);
	}
	
	public void mostrarCorreo(){
		pnlCorreo = new Correo();
		splitPane.setRightComponent(pnlCorreo);
	}
	
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
			}
			else
				try {
					ponerTarjeta();
					pnlTarjeta.setMinimumSize(new Dimension(800, 10));
					rellenarInformacion(pnlTarjeta, (String)table.getModel().getValueAt(table.getSelectedRow(), 0));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				}
		}
	}
	private class TxtBusquedaKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			try {
				actualizarLista(txtBusqueda.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class TableKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==40 || e.getKeyCode()==38)
				try {
					ponerTarjeta();
					pnlTarjeta.setMinimumSize(new Dimension(800, 10));
					rellenarInformacion(pnlTarjeta, (String)table.getModel().getValueAt(table.getSelectedRow(), 0));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}	
}
