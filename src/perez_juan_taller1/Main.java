package perez_juan_taller1;

import processing.core.PApplet;

public class Main extends PApplet{

		private Logica log;
		
	public static void main(String[] args) {
		PApplet.main("perez_juan_taller1.Main");
	}
	
	public void settings() {
		size(1000,600);
	}
	
	public void setup() {
		colorMode(HSB,360,100,100,100);
		log= new Logica(this);
		log.crearFigura();

	}
	
	public void draw() {
		background(100);
		log.pintar();
	}
	
	public void mouseDragged() {
		log.sostener();
		log.CambiarFondoLunar();
		log.arrastrarLuna();
	}
	
	public void mousePressed() {
		System.out.println(mouseX + ", " + mouseY);
		log.presionado();
		//log.reemplazarSol();
		log.desaparecerSol();
	
	}
	
	public void mouseReleased() {
		log.soltar();
		
	}
	
	public void keyPressed() {
		if(keyCode == ENTER) {
			log.moverPajaro();
		}
	}
	

}
