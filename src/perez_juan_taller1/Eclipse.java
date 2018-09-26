package perez_juan_taller1;

import processing.core.PApplet;

public class Eclipse extends Elemento {
	public Eclipse(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=60;

	}


	@Override
	public void pintar() {
		app.fill(58, 95, 95);
		app.ellipse(x, y, tam, tam);
		app.fill(47, 96, 90);
		app.ellipse(x, y, tam-20, tam-20);
		app.fill(36, 94, 90);
		app.ellipse(x, y, tam-40, tam-40);
		app.noStroke();
		app.fill(0,0,0,90);
		app.ellipse(x+20, y, tam, tam);

	}

}
