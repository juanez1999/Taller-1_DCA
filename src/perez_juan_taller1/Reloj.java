package perez_juan_taller1;

import processing.core.PApplet;

public class Reloj extends Elemento {
	
//Defino los valores de las variables que heredo la clase
	public Reloj(PApplet app, int x, int y) {
		super(app);
		this.x = x;
		this.y = y;
		tam = 60;
	}


// Pinto lo necesario para representar la clase con figuras geometricas
	@Override
	public void pintar() {
		app.stroke(59, 89, 100);
		app.strokeWeight(4);
		app.noFill();
		app.ellipse(x, y, tam, tam);
		app.noStroke();
		app.fill(360);
		app.rect(x - 30, y, 30, 1);
		app.rect(x, y, 1, 30);
		app.noFill();

	}

}
