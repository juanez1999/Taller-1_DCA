package perez_juan_taller1;

import processing.core.PApplet;

public class Estrellas extends Elemento {

	public Estrellas(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=10;
	}


	@Override
	public void pintar() {
		app.fill(360);
		app.ellipse(x, y, tam, tam);
	}

}
