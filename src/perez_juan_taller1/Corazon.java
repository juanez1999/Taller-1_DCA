package perez_juan_taller1;

import processing.core.PApplet;

public class Corazon extends Elemento {

	public Corazon(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=50;
	}


	@Override
	public void pintar() {
		app.fill(5, 91, 83);
		app.ellipse(x+20, y, tam, tam);
		app.ellipse(x, y, tam, tam);
		app.triangle(x-25, y, x+10, y+50, x+45, y);
	}
}
