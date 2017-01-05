package presentacion;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
public class LineaGrafico extends ObjetoGrafico implements Serializable{
private ArrayList<Punto> lista = new ArrayList<Punto>();
private Color color;
private int grosor;
public LineaGrafico(int x, int y, int grosor, Color color) {
super(x,y);
this.color=color;
this.grosor = grosor;
addPunto(x, y);
}
public void addPunto(int x, int y) {lista.add(new Punto(x, y, grosor)); }
public void setColor(Color color) {this.color = color; }
public Punto getPunto(){
	return lista.get(lista.size()-1);
}
public ArrayList getLista(){
	return lista;
}
public Color getColor() {return color;}
public int getGrosor() {return this.grosor;}
}