package presentacion;
import java.awt.Color;
import java.io.Serializable;
public class TextoGrafico extends ObjetoGrafico implements Serializable{
private String texto;
private Color color;
private int size;
public TextoGrafico(int x, int y, String text, Color color, int size) {
super(x,y);
this.texto=text;
this.color=color;
this.size = size;
}
public void setTexto(String texto) {this.texto = texto; }
public void setColor(Color color) {this.color = color; }
public String getTexto() {return texto;}
public Color getColor() {return color;}
public void setSize(int size) {this.size = size; }
public int getSize() {return size;}
}