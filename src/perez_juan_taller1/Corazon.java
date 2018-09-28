package perez_juan_taller1;

import processing.core.PApplet;

public class Corazon extends Elemento {
	
//Defino los valores de las variables que heredo la clase
	public Corazon(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=50;
		color=5;
	}

// Pinto lo necesario para representar la clase con figuras geometricas
	@Override
	public void pintar() {
		app.fill(color, 91, 83);
		app.ellipse(x+20, y, tam, tam);
		app.ellipse(x, y, tam, tam);
		app.triangle(x-25, y, x+10, y+50, x+45, y);
	}
}
