package perez_juan_taller1;

import processing.core.PApplet;

public class Cadena extends Elemento {
	
//Defino los valores de las variables que heredo la clase
	public Cadena(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=50;
	}

// Pinto lo necesario para representar la clase con figuras geometricas
	@Override
	public void pintar() {
		app.fill(200);
		app.strokeWeight(2);
		app.stroke(0);
		for (int i = 0; i < 6; i++) {
			app.ellipse(x+40*(i), y, tam, tam);

		}
		app.noStroke();
	}

}
