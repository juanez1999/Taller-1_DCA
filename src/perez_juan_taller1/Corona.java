package perez_juan_taller1;

import processing.core.PApplet;
import processing.core.PConstants;

public class Corona extends Elemento {

	public Corona(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		tam=20;
	}


	@Override
	public void pintar() {
		
	
		app.fill(35, 50, 40);
		app.rectMode(app.CENTER);
		app.triangle(x-40, y-10, x+20, y-20, x-40, y-10);
		app.triangle(x-10, y-10, x+10, y-40, x+30, y-10);
		app.triangle(x+30, y-10, x+50, y-20, x+80, y-10);
		app.rect(x, y, tam+80, tam);
		app.fill(360,0,0,0);
		app.ellipseMode(app.CENTER);
		app.ellipse(x, y, 100, 100);
		app.rectMode(app.CORNER);
		
	}
}
