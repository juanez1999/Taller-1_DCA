package perez_juan_taller1;

import processing.core.PApplet;

public class Estrellas extends Elemento {

//Defino los valores de las variables que heredo la clase
	public Estrellas(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=10;
	}

// Pinto lo necesario para representar la clase con figuras geometricas
	@Override
	public void pintar() {
		app.fill(360);
		app.ellipse(x, y, tam, tam);
	}

}
