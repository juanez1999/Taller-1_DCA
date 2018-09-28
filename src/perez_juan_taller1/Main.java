package perez_juan_taller1;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet{

	//Variable de tipo logica, con la cual llamara los metodos que se encuentran en la logica
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

// Metodo que uso para validar cuando el mouse tenga el click presionado llame los metodos acontinuacion
	public void mousePressed() {
		System.out.println(mouseX + ", " + mouseY);
		log.presionado();
		//log.reemplazarSol();
		log.desaparecerSol();
		if(mouseButton== RIGHT) {
			log.cambiarCadena();
		}
	}
	
// Metodo para validar cuando el mouse este arrastrando algo
	public void mouseDragged() {
		log.sostener();
		log.CambiarFondoLunar();
		log.arrastrarLuna();
	}
	
//Cada vez que se suelte el mouse el evento relacionado se llama
	public void mouseReleased() {
		log.soltar();
		
	}

// Cada dos click el evento se llama al evento doubleclicked
	public void mouseClicked(MouseEvent evt) {
		if (evt.getCount() == 2)doubleClicked();
	}
// Este metodo verifica que ya se haya dado el dobleclick y llama al metodo eliminarEstrella
	private void doubleClicked() {
		log.eliminarEstrella();
	}
	
//Metodo para validar los eventos del teclado, cuando se unda una tecla especifica por ejemplo se llama a los metodos
	public void keyPressed() {
		if(keyCode == ENTER) {
			log.moverPajaro();
		}
		
		if(key == 'e' || key == 'E') {
			log.completarEclipse();
		}
		
		if(keyCode == UP) {
			log.cambiarCorazon();
		}
		
	}
	

}
