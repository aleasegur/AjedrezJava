package utils;

import model.Pieza;

/*en cualquier parte del código donde necesites realizar operaciones relacionadas con la notación del tablero o validar posiciones.
Por ejemplo, al imprimir el estado del tablero después de un movimiento:
AjedrezUtils.imprimirTablero(juego.getTablero().getCasillas());
*/
public class AjedrezUtils {
    /* Convierte coordenadas de una posición en el tablero a un formato legible.*/
    public static String coordenadasANotacion(int x, int y) {
        char columna = (char) ('a' + y); // Convierte la columna a letra (0 -> 'a', 1 -> 'b', ...)
        int fila = 8 - x; // Convierte la fila (0 -> '8', 1 -> '7', ...)
        return "" + columna + fila; // Combina ambos para la notación
    }

    /*Convierte una notación algebraica a coordenadas del tablero.*/
    public static int[] notacionACoordenadas(String notacion) {
        int res[];
        int columna = notacion.charAt(0) - 'a'; // Convierte la letra a índice (0 -> 'a', 1 -> 'b', ...)
        int fila = 8 - Character.getNumericValue(notacion.charAt(1)); // Convierte el número
        return res=new int[]{fila, columna}; // Devuelve las coordenadas
    }

    /*Verifica si una posición está dentro de los límites del tablero. */
    public static boolean dentroDelTablero(int x, int y) {
        boolean res;
        res= x >= 0 && x < 8 && y >= 0 && y < 8;
        return res;
    }

    /*Imprime el estado del tablero en la consola.*/
    public static void imprimirTablero(Pieza[][] tablero) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getClass().getSimpleName().charAt(0) + " "); // Imprime la inicial de la pieza
                } else {
                    System.out.print(". "); // Representa una casilla vacía
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}
