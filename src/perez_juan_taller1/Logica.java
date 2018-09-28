package perez_juan_taller1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {
/* Variables que utilizare para los metodos */
	private PApplet app;
	private ArrayList<Elemento> elementos;
	private int fondoAzul;
	private int fondoAmarillo;
	private int fondoAzul2;
	private int fondoAmarillo2;
	private int fondoAzul3;
	private int fondoAmarillo3;
	private Elemento selector;
	private String[] text;
	private String[] partesText;
	private boolean encontreSol;
	private int contador;
	private int xline, yline;
	private int contadorSeg;
	private char[] caracteres;
/*---------------------------------------------------------------------------------------------------------------------------------*/
	/*Constructor de la logica donde inicializo las variables que utilizare*/
	public Logica(PApplet app) {
		this.app = app;
	//Varaible que utilizo para dar el objeto que quiero usar para mover, le doy su valor dejando asi de ser null	
		selector = null;
		elementos = new ArrayList<>();
		contador = 0;
		xline = 500;
		yline = 200;
	//Cargo el texto para poder trabajar con el
		text = app.loadStrings("text.txt");
	//Divido el texto por espacios en un arreglo	
		partesText = text[0].split(" ");
		caracteres = new char[partesText.length];
		for (int i = 0; i < partesText.length; i++) {
			String parte = partesText[i];
			char[] letras = parte.toCharArray();

		}
		
	//Variables que utilizo para variar el color de fondo	
		fondoAmarillo =57;
		fondoAmarillo2 = 56;
		fondoAmarillo3 =97;
		fondoAzul = 222;
		fondoAzul2=97;
		fondoAzul3= 27;
	}
/*---------------------------------------------------------------------------------------------------------------------------------------*/

	public void pintar() {
		/* Fondo de los escenarios, escenario del sol amarillo claro y la luna azul oscuro*/
		app.fill(fondoAmarillo, fondoAmarillo2, fondoAmarillo3);
		app.rect(0, 0, app.width / 2, app.height);
		app.fill(fondoAzul, fondoAzul2, fondoAzul3);
		app.rect(500, 0, 500, app.height);
		// Lineas punteadas del fondo
		app.fill(360);
		for (int i = 0; i < 10; i++) {
			app.rect(xline, yline, 40, 10);
			app.rect(xline + 50 * (i), yline, 40, 10);
		}
		
		/* for que me recorre el array de elementos y cada que encuentre algo lo va a pintar */
		for (int i = 0; i < elementos.size(); i++) {
			elementos.get(i).pintar();
		}
		

		/* Texto que me aclara que zona es cada una, una representa el sol y la otra luna */
		app.fill(222, 97, 27);
		app.textSize(50);
		app.text("SOLAR", 180, 50);
		app.fill(57, 56, 97);
		app.text("LUNAR", 700, 50);
		app.noFill();
		
/*Metodo que validan la posicion de mi mouse sobre las figuras para dar las instrucciones de lo que se debe hacer */
		validarSol();
		validarReloj();
		validarPajaro();
		validarLuna();
		validarEclipse();
		validarEstrella();
		validarCadena();
		validarCorazon();
/*-------------------------------------------------------------------------------------------------------------------------------*/
	}
/*-------------------------------------------------------------------------------------------------------------------------------------*/

	/*Metodo que me sirve para crear las figuras a partir de la lectura del texto original*/
	public void crearFigura() {
		boolean encontreEstrella;
		boolean encontreLuna;
		int contadorN = 0;
		int letrasEnPal = 0;
		int contadorE = 0;
		int contadorR = 0;

//Cada palabra sol que me encuentre en el texto agregara un objeto de la clase sol al arraylist de elementos
		for (int i = 0; i < partesText.length; i++) {
			if (partesText[i].equals("sol") == true) {
				encontreSol = true;
			} else {
				encontreSol = false;
			}
			if (encontreSol == true) {
				elementos.add(new Sol(app, (int) app.random(0, 400), (int) app.random(100, 500)));
			}
		}

// Cada 5 "a" que encuentre al dividir el texto en char creara una estrella
		int contadorA = 0;
		for (int i = 0; i < partesText.length; i++) {
			for (int j = 0; j < partesText[i].length(); j++) {
				char p = partesText[i].charAt(j);
				if (p == 'a') {
					contadorA += 1;
				}

				if (contadorA == 5) {
					contadorA = 0;
					elementos.add(new Estrellas(app, (int) app.random(app.width / 2, app.width), (int) app.random(10, app.height)));
				}
			}
		}
		
// Cada palabra terminada en N crea un objeto de la clase luna
		for (int i = 0; i < partesText.length; i++) {
			char p = partesText[i].charAt(partesText[i].length() - 1);
			if (p == 'n') {
				contadorN += 1;
			}
			if (contadorN == 10) {
				contadorN = 0;
				elementos.add(new Luna(app, (int) app.random(501,996), (int) app.random(205,596)));
			}
		}

/* Las primeras 5 palabras las evalua y mira si su cantidad de char es par o impar y crea la clase, si es par la crea*/
		for (int i = 0; i < 5; i++) {
			// El primer for es para evaluar las palabras separas por espacios
			// El segundo for es para evaluar la cantidad de letras que tiene una palabra  desde su inicio hasta su final
			for (int j = 0; j < partesText[i].length(); j++) {
				// letras en pal suma la cantidad de char que tiene cada palabra
				letrasEnPal += 1;
			}
			// coloco el if fuera del for para que evalue cada palabra por separado
			if (letrasEnPal % 2 == 0) {
				//System.out.println(letrasEnPal);
				letrasEnPal = 0;
				elementos.add(new Cadena(app, (int) app.random(app.width / 2, app.width), (int) app.random(10, app.height)));
			}
		}

// Contar segunda letra, que sea la E y si es la "e" entonces me crea el objeto de la clase corona
		for (int i = 0; i < partesText.length; i++) {
			// Evalua que la palabra tenga mas de dos caracteres para saber si la segunda es
			// la e
			if (partesText[i].length() >= 2) {
				for (int j = 0; j < partesText[i].length(); j++) {
					char p = partesText[i].charAt(1);

					if (p == 'e') {
						contadorE += 1;
					//	System.out.println(contadorE);
					}

					if (contadorE == 20) {
						contadorE = 0;
						elementos.add(new Corona(app, (int) app.random(0, (app.width / 2)-100), (int) app.random(10, app.height)));
					}
				}
			}
		}

		int cont = 0;
// Contar cuando una palabra tiene mas de 7 letras
		for (int i = 0; i < partesText.length; i++) {
			if (partesText[i].length() >= 7) {
				cont++;
				if (cont >= 20) {
					cont = 0;
					elementos.add(new Reloj(app, (int) app.random(app.width/2, app.width), (int) app.random(10, app.height)));
				}
			}
		}

// Cada palabra que contenga en ella una letra r, creera un objeto nuevo de la clase corazon
		for (int i = 0; i < partesText.length; i++) {
			for (int j = 0; j < partesText[i].length(); j++) {
				char p = partesText[i].charAt(j);
				if (p == 'r') {
					contadorR += 1;
				}

				if (contadorR == 20) {
//			System.out.println(contadorR);
					contadorR = 0;
					elementos.add(new Corazon(app, (int) app.random(100,997), (int) app.random(466,500)));
				}
			}
		}

// Cada palabra que termina en infinitivo, es decir, que terminan en er, ar, ir crea algo
		for (int i = 0; i < partesText.length; i++) {
			if (partesText[i].length() >= 2) {

				char ant = partesText[i].charAt(partesText[i].length() - 1);
				char ul = partesText[i].charAt(partesText[i].length() - 2);
				if ((ant == 'a' || ant == 'e' || ant == 'i') && ul == 'r') {
//					System.out.println("hi");
					elementos.add(new Eclipse(app, (int) app.random(50, (app.width/2)-100), (int) app.random(100, app.height)));
				}
			}
		}

	}
	
/* --------------------------------------------------------------------------------------------------------------------------------------*/
//Este metodo sobreescribe el nuevo archivo de texto que se ha creado vacio con la informacion del anterior archivo de texto 
	public void escribirNewTexto() {
		String temp = PApplet.join(partesText, " ");
		try {
			File archivo = new File("textoNuevo.txt");
			archivo.createNewFile();
			BufferedWriter nt = new BufferedWriter(new FileWriter(archivo));
			nt.write(temp);
			nt.flush();
			nt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
/* metodo que me sirve para cambiar todas las letras e en el nuevo documento por un # */
	public void reemplazarSol() {
		for (int i = 0; i < partesText.length; i++) {
			char[] letras = partesText[i].toCharArray();
			for (int j = 0; j < letras.length; j++) {
				if (letras[j] == 'e') {
					letras[j] = '#';
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
	
/* metodo que me sirve para cambiar todas las palabras amor por mentira en el nuevo documento de texto */
	public void reemplazarReloj() {	
		for (int i = 0; i < partesText.length; i++) {
			String letras = partesText[i].toString();
			for (int j = 0; j < letras.length(); j++) {
				if (letras.equals("amor")) {
					letras = "mentira";
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
/* metodo que me sirve reemplazar las cada 5 'a' en el texto por un '_' */	
	public void reemplazarPajaro() {	
		int contadorA = 0;
		for (int i = 0; i < partesText.length; i++) {
			char[] letras = partesText[i].toCharArray();
			for (int j = 0; j < partesText[i].length(); j++) {
				//char p = partesText[i].charAt(j);
				if (letras[j]== 'a') {
					contadorA += 1;
				}

				if (contadorA == 5) {
					contadorA = 0;
					letras[j]= '_';
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
/* metodo que me sirve reemplazar las palabras que contienen mas de 7 caracteres por un NOTHING */		
	public void reemplazarLuna() {
		int cont=0;
		for (int i = 0; i < partesText.length; i++) {
			String letras = partesText[i].toString();
			for (int j = 0; j < letras.length(); j++) {
				if (partesText[i].length() >= 7) {
					cont++;
					if (cont >= 20) {
						cont = 0;
						letras = "NOTHING";
					}
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
	
/* metodo que me sirve para reemplazar las r que estan contenidas en las palabras cada 20 por una x */		
	public void reemplazarEclipse() {
		int contadorR=0;
		for (int i = 0; i < partesText.length; i++) {
			char[] letras = partesText[i].toCharArray();
			for (int j = 0; j < partesText[i].length(); j++) {
				char p = partesText[i].charAt(j);
				if (letras[j] == 'r') {
					contadorR += 1;
				}

				if (contadorR == 20) {
					contadorR = 0;
					letras[j]= + 'x';
				}
			}
			partesText[i]= new String(letras);

		}
		escribirNewTexto();
	}
	
/* metodo que me sirve para reemplazar las palabras con carecteres pares, pero solo me reemplaza las primeras
   5 palabras que encuentre que son par */		
	public void reemplazarEstrella() {
		int letrasEnPal = 0;
		for (int i = 0; i < 5; i++) {
			String letras = partesText[i].toString();
			for (int j = 0; j < partesText[i].length(); j++) {
				letrasEnPal += 1;
				
				if (letrasEnPal % 2 == 0) {
					letrasEnPal = 0;
					letras= "ja! era par";
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
	
/* metodo que me sirve para reemplazar caracteres aleatorios cada 5 cambia un caracter por ; en el texto nuevo */		
	public void reemplazarCadena() {
		int contadorN=0;
		for (int i = 0; i < partesText.length; i++) {
			char[] letras = partesText[i].toCharArray();
			char p = partesText[i].charAt(partesText[i].length() - 1);
			for (int j = 0; j < partesText[i].length(); j++) {
				if (p == 'n') {
					contadorN += 1;
				}
				if (contadorN == 5) {
					contadorN = 0;
					letras[j]= ';';
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
/* metodo que me sirve para reemplazar palabras dentro del texto nuevo, primero cambia una y luego cambia la palabra luna */			
	public void reemplazarCorazon() {
		for (int i = 0; i < partesText.length; i++) {
			String letras = partesText[i].toString();
			for (int j = 0; j < letras.length(); j++) {
				if (letras.equals("una")) {
					letras = "mas de una";
				}
				
				if (letras.equals("luna")) {
					letras = "La luna morira";
				}
			}
			partesText[i]= new String(letras);
		}
		escribirNewTexto();
	}
	
	
	

	
/*------------------------------------------------------------------------------------------------------------------------------------------*/
	/* Metodo que utilizo para que recorrar el array de la clase Elemento y al validar que este sobre un objeto el selector
	 * se convierta en este objeto para luego poder usar su valor, dejando así de ser null el selector */

	public void presionado() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			if (PApplet.dist(app.mouseX, app.mouseY, e.getX(), e.getY()) < e.getTam()) {
				selector = e;
				break;
			}
		}
	}
/* Metodo que utilizo para que hacer que la posicion del elemento el cual tengo presionado pase a tener las posiciones de
 * mi mouse*/
	public void sostener() {
		if (selector != null) {
			selector.setX(app.pmouseX);
			selector.setY(app.pmouseY);
		}
	}
/* Metodo que me sirve para validar cuando suelte el objeto la variable selector vuelva a ser null para poder agarrar
 * luego otro elemento*/
 
	public void soltar() {
		selector = null;
	}
	
/*----------------------------------------------------------------------------------------------------------------------------------------------*/	
	public void validarSol() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento e = elementos.get(i);
			if (e instanceof Sol && PApplet.dist(app.mouseX, app.mouseY, e.getX(), e.getY()) < e.getTam()-60) {
				app.fill(0);
				app.textSize(20);
				app.text("Click para eliminar el sol", e.x-100, e.y+60);
			}
		}
	}
	
	
// Si doy click en cada sol este lo que hara es desaparecer y llamar el metodo reemplazar sol, el cual modificara el nuevo texto*/	
	public void desaparecerSol() {
		contadorSeg= app.millis();
		//Llamo al metodo reemplazar sol para sobreescribir el nuevo txt
		reemplazarSol();
		for (int i = 0; i < elementos.size(); i++) {
		Elemento e = elementos.get(i);
		if (e instanceof Sol && PApplet.dist(app.mouseX, app.mouseY, e.getX(), e.getY()) < e.getTam()-60) {
			elementos.remove(i);
		}
		}
	}
	
/* metodo para validar que este sobre el reloj y me escribe el texto de instruccion */	
	public void validarReloj() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Reloj && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-40) {
				app.fill(360);
				app.textSize(15);
				app.text("Arrastra el reloj para cambiar el color del fondo", u.x-80, u.y+60);
			}
		}
	}
/* metodo para que valide cuando se arrastre el reloj entonces cambie el fondo lunar de color */
	public void CambiarFondoLunar() {
 //Llamo al metodo reemplazar reloj para sobreescribir el nuevo txt
		reemplazarReloj();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Reloj && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-40) {
				fondoAzul= (int) app.random(0,360);
			}
		}
	}
/* Metodo para validar que mi mouse este sobre el pajaro para dar las instrucciones al usuario */
	public void validarPajaro() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Corona && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()){
				app.fill(0);
				app.textSize(20);
				app.text("Presiona enter para moverlos", u.x, u.y+30);
			}
		}
	}
/* Metodo que al ser llamado por el enter hara que la posicion de los pajaros en x aumente*/
	public void moverPajaro() {
		reemplazarPajaro();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Corona ) {
				u.x+=10;
			}
	}
		}

/* Metodo que valida cuando tengo el click sobre alguna luna para poder dar la instruccion al usuario */
	public void validarLuna() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Luna && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-50){
				app.fill(360);
				app.textSize(20);
				app.text("Suelta la luna en la zona de las lineas", u.x-200, u.y+60);
			}
		}
	}
/* Metodo que al arrastrar alguna luna a la zona de las lineas, el tamaño y el color del stroke cambien aleatoriamente*/
	public void arrastrarLuna() {
		reemplazarLuna();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Luna && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-50) {
			 if(u.x>500 && u.x < 995 && u.y > 0 && u.y <196) {
				u.color= (int) app.random(0,360);
				((Luna) u).setStroke(app.random(1,10));
			 }
			}
	}
	}
	
/* Metodo que valida cuando tengo el click sobre algun eclipse para poder dar la instruccion al usuario */
	public void validarEclipse() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Eclipse && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-20){
				app.fill(0);
				app.textSize(20);
				app.text("Presiona e para que el eclipse sea total", u.x-150, u.y+60);
			}
		}
	}
	
/* Este metodo sirve para hacer que el eclipse complete su totalidad al desaparecer el sol y solo quedar el circulo negro,
 * representando el eclipse en su totalidad*/
	public void completarEclipse() {
		reemplazarEclipse();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Eclipse && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-20) {
				((Eclipse) u).opacidad-=20;
			}
	}
	}	
/* Metodo que valida cuando tengo el click sobre alguna estrella para poder dar la instruccion al usuario */	
	public void validarEstrella() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Estrellas && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()){
				app.fill(360);
				app.textSize(15);
				app.text("Doble click para eliminar la estrella", u.x-80, u.y+30);
			}
		}
	}
	
/* Este metodo sirve para eliminar la estrella en la cual se este dando doble click*/	
	public void eliminarEstrella() {
		reemplazarEstrella();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Estrellas && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()) {
				elementos.remove(i);
			}
	}
	}
	
/* Metodo que valida cuando tengo el click sobre alguna estrella para poder dar la instruccion al usuario */	
	public void validarCadena() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Cadena && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-30){
				app.fill(360);
				app.textSize(15);
				app.text("Click derecho para cambiar tamaño", u.x-80, u.y+50);
			}
		}
	}
	
/* Este metodo sirve para cambiar el tamaño de la cadena en 5 cada vez que se unda el click derecho*/	
	public void cambiarCadena() {
		reemplazarCadena();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Cadena && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()-30) {
				u.tam-=5;
			}
	}
	}
	
	/* Metodo que valida cuando tengo el click sobre algun corazon para poder dar la instruccion al usuario */	
	public void validarCorazon() {
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Corazon && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()){
				app.fill(155);
				app.textSize(20);
				app.text("Flecha arriba para cambiar color", u.x-80, u.y+70);
			}
		}
	}
	
	/* Este metodo sirve para cambiar el color del corazon por uno aletorio al dar flecha arriba*/	
	public void cambiarCorazon() {
		reemplazarCorazon();
		for (int i = 0; i < elementos.size(); i++) {
			Elemento u= elementos.get(i);
			if(u instanceof Corazon && PApplet.dist(app.mouseX, app.mouseY, u.getX(), u.getY()) < u.getTam()) {
			u.color= (int) app.random(0,360);
			}
	}
	}
	
	
	
	

	
	

	
	
	
	
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
}
	


