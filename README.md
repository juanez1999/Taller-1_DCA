# Taller 1 Dise�ando con Algoritmos - Juan Esteban P�rez C�d. A00347501

## Clase Main

En esta clase sucede todo lo relacionado con la ejecuci�n de la aplicaci�n, los metodos que se encuentran
en la logica son llamados aqu� para ser ejecutados por los metodos bases como el draw, el setup, el mousePressed,
mouseDragged y el keyPressed.

### Variables:
* PApplet app // Esta variable es la que uso para llamar el core de proccesing para poder realizar todos lo que necesito
con la interfaz de processing como el pintar y utilizar los metodos que el proccessing ya tiene en s�.
* Logica log // Esta variable global es la que utilizo para llamar los metodos que he definido con anterioridad en la logica
para realizar todo el proceso de ejecucion de estos metodos.

### Metodos:
* void main(String[] // Este metodo lo utilizo para llamar el package con el que voy a trabajar e incluir el core
de proccessing mi PApplet.
* void settings() // Este metodo lo utilizare para dar el tama�o al lienzo de la aplicaci�n.
* void setup() // Este motodo lo utilizare para inicializar las variables globales, para luego poder utilizarlas, como en
el caso de la logica, para utilizar en los metodos de abajo.
* void draw() // Este metodo lo utilizar� para realizar todo el trabajo de pintado que he definido en la logica.
* void mousePressed() // Este metodo sera utilizado para definir lo que suceder� cuando el usuario mantenga presionado el click.
* void mouseDragged() // Este metodo lo utlizar� para definir lo que sucede cuando el usuario mantenga arrastrado el click con el mouse.
* void keyPressed() // Este metodo sera utilizado para validar cuando el usuario presione cierta tecla del teclado y lo que sucedera cuando eso pase.
