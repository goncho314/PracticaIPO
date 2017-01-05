package presentacion;

import java.io.Serializable;

public class Punto {
	public int x;
	public int y;
	public int grosor;
	public Punto(int x, int y, int anchura) {
		this.x = x;
		this.y = y;
		grosor = anchura;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getGrosor() {
		return grosor;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}	
	public void setGrosor(int anchura) {
		this.grosor = anchura;
	}		
}
