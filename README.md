He recreado el ajedrez en java es un proyecto que empece hace 4 meses.Despues de 4 meses desde la ultima vez que lo he manipulado me he ayudado con chatGPT a solucionar problemas.Ahora he decidido subir y crear un repositorio local y virtual para mejorarlo y no pasar al olvido esta paliza que me he metido al recrear el ajedrez.He de mejorar los metodos y he añadido comentarios para entenderlo mejor, no como hace 4 meses que no comente y duramtes el ultimo mes te pierdes mucho.

Paso estructura del proyecto(Si, utilice chatGPT para uqe me genrase de manera visual el proyecto y como organizarme):

ProyectoAjedrez/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           └── ajedrez/
│   │   │               ├── Main.java
│   │   │               ├── controller/
│   │   │               │   └── Controller.java
│   │   │               ├── model/
│   │   │               │   ├── Pieza.java
│   │   │               │   ├── Rey.java
│   │   │               │   ├── Torre.java
│   │   │               │   ├── Tablero.java
│   │   │               │   └── JuegoAjedrez.java
│   │   │               └── utils/
│   │   │                   └── ChessUtils.java
│   │   ├── resources/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           └── ajedrez/
│   │   │               ├── view.fxml
│   │   │               └── images/
│   │   │                   ├── rey_blanco.png
│   │   │                   ├── rey_negro.png
│   │   │                   └── ... (otras imágenes de piezas)
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── ejemplo/
│   │               └── ajedrez/
│   │                   └── (archivos de prueba)
└── pom.xml (para proyectos con Maven)


EXPLICACION de la estructura:
src/main/java/com/ejemplo/ajedrez/Main.java:
La clase principal que carga el archivo view.fxml y lanza la aplicación JavaFX.

controller/Controller.java:
El controlador de la vista. Contiene la lógica que conecta la interfaz de usuario con el modelo del ajedrez (las piezas, el tablero y la lógica de movimiento).
model/:
Contiene las clases que representan la lógica y las reglas del ajedrez.
Pieza.java: Clase abstracta para piezas de ajedrez.
Rey.java, Torre.java, y otras clases para cada tipo de pieza.
Tablero.java: Representa el tablero y contiene métodos para gestionar el estado del juego.
JuegoAjedrez.java: Maneja el flujo y las reglas del juego, incluyendo el cambio de turnos y la lógica de jaque y jaque mate.

utils/ChessUtils.java:
Clases de utilidades para operaciones adicionales, como comprobaciones de posiciones, validaciones o conversiones de coordenadas. Estas clases ayudan a mantener el código limpio y modular.

src/main/resources/com/ejemplo/ajedrez/view.fxml:
El archivo FXML define la interfaz gráfica (UI) del tablero de ajedrez y otros elementos visuales.
Define una GridPane que representa el tablero de 8x8 con botones o Labels para las casillas.

src/main/resources/com/ejemplo/ajedrez/images/:
Carpeta que contiene las imágenes para las piezas de ajedrez (rey_blanco.png, rey_negro.png, etc.).
Opcionalmente, puedes agregar un fondo para el tablero o imágenes adicionales
