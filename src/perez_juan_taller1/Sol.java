package perez_juan_taller1;

import processing.core.PApplet;

public class Sol extends Elemento{
	
//Defino los valores de las variables que heredo la clase
	public Sol(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		//x= 100;
		//y= 100;
		tam= 80;
		
	}
	
// Pinto lo necesario para representar la clase con figuras geometricas
	public void pintar() {
		app.fill(58, 95, 95);
		app.ellipse(x, y, tam, tam);
		app.fill(47, 96, 90);
		app.ellipse(x, y, tam-20, tam-20);
		app.fill(36, 94, 90);
		app.ellipse(x, y, tam-40, tam-40);
		app.noStroke();	
}
	
}