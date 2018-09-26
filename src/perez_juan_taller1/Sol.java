package perez_juan_taller1;

import processing.core.PApplet;

public class Sol extends Elemento{
	
	private float angulo;
	private float distancia;
	private float trianguloX,trianguloY;
	
	public Sol(PApplet app, int x, int y) {
		super(app);
		this.x=x;
		this.y=y;
		//x= 100;
		//y= 100;
		tam= 80;
		distancia=60;
		angulo= app.PI/2;
		
	}
	
	public void pintar() {
		app.fill(58, 95, 95);
		app.ellipse(x, y, tam, tam);
		app.fill(47, 96, 90);
		app.ellipse(x, y, tam-20, tam-20);
		app.fill(36, 94, 90);
		app.ellipse(x, y, tam-40, tam-40);
		app.noStroke();
//		trianguloX= x+app.cos(angulo) * distancia;
//		trianguloY= y+ app.sin(angulo) * distancia;
//		app.fill(43, 98, 94);
//		//app.rect(trianguloX, trianguloY, 10, 10);
//		//app.triangle(trianguloX, trianguloY, trianguloX+40, trianguloY+20, trianguloX+40, trianguloY-20);
////		app.ellipse(trianguloX, trianguloY, 10, 10);
////		app.ellipse(trianguloX+20, trianguloY+20, 10, 10);
////		angulo += app.PI/40;
	}
	
	/*public void sostenerSol() {
		int contadorSegundos= 0;
	}*/

	
}
