package presentacion;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	public Fondo() {
	}
    Image image = new ImageIcon(Fondo.class.getResource("/presentacion/resources/fondo-alfa2.png")).getImage();
 
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

}
