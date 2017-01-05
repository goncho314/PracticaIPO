package presentacion;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JLabel;
public class MiAreaDibujo extends JLabel{
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();
	public MiAreaDibujo(){
	}
	void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}
	public ObjetoGrafico getUltimoObjetoGrafico(){
		return objetosGraficos.get(objetosGraficos.size()-1);
	}
	public void paint(Graphics g){
		super.paint(g);
		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof LineaGrafico){
				ArrayList<Punto> l = ((LineaGrafico)objg).getLista();
				g.setColor(((LineaGrafico)objg).getColor());
				int grosor = ((LineaGrafico)objg).getGrosor();
				for(int j = 0;j<l.size();j++){
					g.setColor(((LineaGrafico)objg).getColor());
					int x = l.get(j).getX();
					int y = l.get(j).getY();
					Ellipse2D.Double circle = new Ellipse2D.Double(x, y, grosor, grosor);
					((Graphics2D)g).fill(circle);
				}
				
			}
			else if (objg instanceof RectanguloGrafico){
				int xinicio = objg.getX(), yinicio = objg.getY();
				g.setColor(((RectanguloGrafico)objg).getColor());
				int w = ((RectanguloGrafico)objg).getX1() - objg.getX();
				int h = ((RectanguloGrafico)objg).getY1() - objg.getY();
				if(w<0)
					xinicio = ((RectanguloGrafico)objg).getX1();
				if(h<0)
					yinicio = ((RectanguloGrafico)objg).getY1();
				g.drawRect(xinicio, yinicio, Math.abs(w), Math.abs(h));
			}
			else {
				Font fuenteActual = g.getFont();
				Font nuevaFuente = new Font(fuenteActual.getFontName(),1, ((TextoGrafico)objg).getSize());
				g.setColor(((TextoGrafico)objg).getColor());			
				g.setFont(nuevaFuente);
				g.drawString(((TextoGrafico)objg).getTexto(),objg.getX(),objg.getY());
			}

		}
	}
	void removeObjetosGraficos(){
		objetosGraficos.clear();
		repaint();
	}
	
	void removeUltimo(){
		int n = objetosGraficos.size();
		if(n>0)
			objetosGraficos.remove(n-1);
		repaint();
	}
}