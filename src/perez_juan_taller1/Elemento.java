package perez_juan_taller1;

import processing.core.PApplet;

public abstract class Elemento {
	
	protected PApplet app;
	protected int x,y, tam;
	protected int color;
	
	public Elemento(PApplet app) {
		this.app=app;
	}
	
	//public abstract void pintar(int x, int y);
	
	public abstract void pintar();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	
	
	
}
