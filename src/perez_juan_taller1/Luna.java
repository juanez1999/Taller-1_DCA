package perez_juan_taller1;

import processing.core.PApplet;

public class Luna extends Elemento {

	private float stroke;

	public Luna(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=80;
		color=360;
		stroke = 0;
	}
	
	public float getStroke() {
		return stroke;
	}

	public void setStroke(float stroke) {
		this.stroke = stroke;
	}

	public void pintar() {
		app.fill(360);
		app.strokeWeight(stroke);
		app.stroke(color, 56, 97);
		app.ellipse(x, y, tam, tam);
		app.noStroke();
		app.fill(0, 0, 30, 80);
		app.ellipse(x+20,y-20,tam-60,tam-60);
		app.fill(0, 0, 30, 40);
		app.ellipse(x+5,y-30,tam-70,tam-70);

	}

}
