# Taller 1 Diseñando con Algoritmos - Juan Esteban Pérez Cód. A00347501

## Clase Main

En esta clase sucede todo lo relacionado con la ejecución de la aplicación, los metodos que se encuentran
en la logica son llamados aquí para ser ejecutados por los metodos bases como el draw, el setup, el mousePressed,
mouseDragged y el keyPressed.

### Variables:
* PApplet app // Esta variable es la que uso para llamar el core de proccesing para poder realizar todos lo que necesito
con la interfaz de processing como el pintar y utilizar los metodos que el proccessing ya tiene en sí.
* Logica log // Esta variable global es la que utilizo para llamar los metodos que he definido con anterioridad en la logica
para realizar todo el proceso de ejecucion de estos metodos.

### Metodos:
* void main(String[] // Este metodo lo utilizo para llamar el package con el que voy a trabajar e incluir el core
de proccessing mi PApplet.
* void settings() // Este metodo lo utilizare para dar el tamaño al lienzo de la aplicación.
* void setup() // Este motodo lo utilizare para inicializar las variables globales, para luego poder utilizarlas, como en
el caso de la logica, para utilizar en los metodos de abajo.
* void draw() // Este metodo lo utilizaré para realizar todo el trabajo de pintado que he definido en la logica.
* void mousePressed() // Este metodo sera utilizado para definir lo que sucederá cuando el usuario mantenga presionado el click.
* void mouseDragged() // Este metodo lo utlizaré para definir lo que sucede cuando el usuario mantenga arrastrado el click con el mouse.
* void keyPressed() // Este metodo sera utilizado para validar cuando el usuario presione cierta tecla del teclado y lo que sucedera cuando eso pase.

## Clase Logica

Esta clase contiene todos los metodos para que se ejecuten en el Main y así se ejecute la aplicación de manera adecuada. Es la clase donde contiene
lo logico de la aplicación.

### Variables:
* PApplet app // Esta variable la utilizo para hacer uso del PApplet y así utilizar sus metodos en la logica.
* ArrayList <Elemento> elementos // Esta variable la utilizo para crear un ArrayList de la clase Elemento, es decir,
crear una Lista con varios objetos de la clase Elementos para luego pintarlos en la Logica y que se vean en el lienzo
de la aplicación.
* String text // Con esta variable hare el cargue del texto que se va a utilizar para realizar
toda la aplicación interactiva.


### Metodos:
* Logica (PApplet) // Este metodo me servira para inicializar todas las variables y así mismo, 
hacer uso de ellas.
* void pintar() // En este metodo realizare todo lo referente al pintar de la aplicacion, traere los metodos de pintar
de la clase Elemento para que todo se piense en el lienzo de la aplicación.
* void mouse() // En este metodo usare todos los eventos del mouse que necesite en la clase Elemento para que el usuario haga las interacciones, aquí los llamo,
para poder utilizarlos luego en la clase main.
* void teclado() // En este metodo llamare los metodos del evento del teclado que utilizo en la clase Elemento, eventos con los que el usuario interactua con la aplicación,
para luego poder utilizarlos en el Main y que la aplicación los reconozca.

## Clase Elemento
Esta clase sera abstracta ya que sera la clase padre que definirá ciertas caracteristicas iguales que tendran las hijas, esta clase me sirve para no repetir lineas de codigos que
son iguales en cada clase hija.

### Variables:
* PApplet app // Esta variable la utilizo para hacer uso del PApplet y así utilizar sus metodos en esta clase.
* int posX // Esta variable me definira la posición en x en el lienzo de los elementos.
* int posY // Esta variable me definira la posición en y en el lienzo de los elementos. 
* int tam // Esta variable define el tamaño del objeto cuando se cree.
* char letra // Esta variable sirve para que reciba un char previamente cargado del texto de la aplicación y así, poder realizar algun objeto con este char.
* String frase // Esta variable me sirve para seleccionar una frase previamente del texto, y realizar un objeto de la clase con esta frase.

### Metodos:
* Elemento(PApplet) // Metodo constructor donde inicializo las variables, me recibe el PApplet para poder trabajar aquí con los metodos del core de Proccessing.
* void pintar() // Metodo abstracto ya que cada hija se encargara de pintarse de la manera que necesite, por lo tanto, heredan el metodo pero cada hija lo sobreescribe.
* void mover() // Metodo abstracto ya que cada hija se encargara de moverse de la manera que necesite, por lo tanto, heredan el metodo pero cada hija lo sobreescribe.
* getLetra() // Metodo encargado de obtener un char del texto que se cargo para luego poder utilizarlo.
* getFrase() // Metodo encargado de obtener un String del texto que se cargo para luego poder utilizarlo.

## Clase Sol
Esta clase creera el Elemento sol, a partir de circulos y triangulos a su alrededor.

### Metodos: 
* Sol(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Sol donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Sol su movimiento sera distinto a las otras, tendra eventos a partir del uso del mouse.

## Clase Luna
Esta clase creera el Elemento luna, a partir de circulos y circulos mas pequeños en su interior.

### Metodos: 
* Luna(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Luna donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Luna su movimiento sera distinto a las otras, tendra eventos a partir del uso del mouse.

## Clase Cadena
Esta clase creera el Elemento cadena, a partir de circulos, formando una cadena compuesta de circulos.

### Metodos: 
* Cadena(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Cadena donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas como el circulo.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Cadena su movimiento sera distinto a las otras, tendra eventos a partir del uso del mouse.

## Clase Reloj
Esta clase creera el Elemento Reloj, a partir de un circulo y dos rectangulos para el minutero, formando un reloj.

### Metodos: 
* Reloj(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Reloj donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas como el circulo.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Reloj su movimiento sera distinto a las otras, tendra eventos a partir del uso del teclado.

## Clase Estrellas
Esta clase creera el Elemento Reloj, a partir de un circulo y dos rectangulos para el minutero, formando un reloj.

### Metodos: 
* Estrellas(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Estrellas donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas como el circulo.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Estrellas su movimiento sera distinto a las otras, tendra eventos a partir del uso del mouse, como arrastrar.

## Clase Corona
Esta clase creera el Elemento Corona, a partir de un rectangulo y tres triangulos, formando un corona.

### Metodos: 
* Corona(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Corona donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas como el circulo.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Corona su movimiento sera distinto a las otras, tendra eventos a partir del uso del teclado, al undir una tecla se cambia de lado.

## Clase Rayos
Esta clase creera el Elemento Rayos, a partir de un rectangulo de diferentes tamaños, formando una especie de rayos.

### Metodos: 
* Rayos(PApplet) // El constructor de la clase donde se define el valor de las variables de la clase padre.
* void pintar() // El metodo pintar de la clase Rayos donde se utilizaran las variables de la clase Padre para crear el elemento gráfico,
a partir de figuras geometricas como el circulo.
* void mover() // El metodo heredado donde se sobreescribe ya que la clase Rayos su movimiento sera distinto a las otras, tendra eventos a partir del uso del teclado, al undir una tecla hara que bajen su posición en y.