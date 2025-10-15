import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        comprobarCicloDeJuego();


    }

    /**
     * En esta función preguntamos al usuario por un número, que va a ser con el que se va a jugar.
     * El número introducido tiene ciertas peculiaridades: debe estar entre 10 o 99.
     * Además, si el usuario introduce la opción -1 se genera un número aleatorio entre 10 y 99.
     *
     * @return Devuelve un entero que va a ser un número en el rango de 10 a 99.
     */
    public static int preguntarUsuarioPorRango() {
        //Preguntamos al usuario por el número con el que vamos a jugar
        System.out.println("Introduce un número mayor que 10 y menor que 99 para jugar." +
                "\nSi introduces -1 el número generado es aleatorio");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //Si el número que da es el -1 genera un número aleatorio
        if (number == -1) {
            number = (int) (Math.random() * 90 + 10);

            return number;
        }
        //Aquí comprobamos que el número introducido no sea menor que 10 o mayor que 99
        else {
            while (number < 10 || number > 99) {
                if (number == -1) {
                    number = (int) (Math.random() * 90 + 10);

                    return number;
                } else {
                    System.out.println("El número introducido no es válido. Por favor, introduce un número válido");
                    number = sc.nextInt();
                }
            }
        }

        return number;

    }

    public static void comprobarCicloDeJuego() {
        int turno = 0;
        int nuevoNumero;
        int numeroAnterior;
        int contadorTotal = 0;
        int nJugadores = preguntarPorJugadores();
        boolean jugarPartida = true;

        //Hacemos un bucle jugable para jugar. Mientras la condición de jugarPartida sea true, se juega una partida. Esta condición simepre
        //es true nada más iniciar el programa.
        while (jugarPartida) {
            int rangoMaximo = preguntarUsuarioPorRango();
            //Teniendo el rango máximo ya dado por el usuario, mostramos las normas de la partida y comenzamos el primer turno
            //permitiendo que el jugador 1, únicamente en el primer turno, pueda introducir cualquier número del 1 al 9.
            System.out.println("Comienza la partida. La puntuación Objetivo es: " + rangoMaximo +
                    "\nLas normas son sencillas: el primer jugador puede introducir cualquier número " +
                    "del 1 al 9." + "\nA partir de ahí, cada jugador debe introducir un nuevo número que no debe ser " +
                    "\nel mismo que el anterior introducido y debe estar en la misma fila y columna");

            System.out.println("--- Turno del jugador " + (turno + 1) + " ---");
            nuevoNumero = introducirNumero(contadorTotal);
            contadorTotal = nuevoNumero;
            numeroAnterior = nuevoNumero;
            turno = comprobarQuienJuega(turno, nJugadores);


            while (rangoMaximo > contadorTotal) {
                System.out.println("--- Turno del jugador " + (turno + 1) + " ---");
                System.out.println("El número anterior es: " + numeroAnterior);
                nuevoNumero = introducirNumero(contadorTotal);

                //Comprobamos que no esté en la misma fila, columna o que no sea el número anterior
                if (!validarNumeros(nuevoNumero, numeroAnterior)) {
                    mostrarErrorFilasColumnas();
                } else {
                    //Si el numero introducido es valido lo suma al contador y lo convierte al numero anterior introducido
                    numeroAnterior = nuevoNumero;
                    contadorTotal = contadorTotal + nuevoNumero;
                    turno = comprobarQuienJuega(turno, nJugadores);

                }
                System.out.println("El contador total es: " + contadorTotal);

            }
            System.out.println("\nEl total (" + contadorTotal + ") ha alcanzado o superado el objetivo (" + rangoMaximo + ").");
            System.out.println("El jugador " + (turno + 1) + " ha perdido.");
            jugarPartida = repetirJuego();
            turno = 0;
            contadorTotal = 0;


        }
    }

    /**
     * Con esta función lo que se hace es comprobar que el número que introduce el usuario es válido.
     * Para ello se compara el nuevo número que se introduce con el número anterior introducido.
     * Dadas las normas del juego el nuevo número nunca será el mismo que el anterior y, además, tiene que estar en la misma
     * fila y columna en la que lo estaría en el teclado de una calculadora.
     *
     * @param nuevoNumero    Parámetro de entrada para saber cuál es el nuevo número introducido por el jugador actual.
     * @param anteriorNumero Parámetro de entrada para saber cuál es el número inmediatamente anterior introducido por el jugador anterior.
     *                       Este es el número que se compara con el nuevoNumero para saber si es válido.
     * @return Devuelve un un boolean. False en el caso de que la comprobación no sea correcta. True en el caso contrario.
     */
    public static boolean validarNumeros(int nuevoNumero, int anteriorNumero) {
        if (anteriorNumero == 1 && ((nuevoNumero == 1 || nuevoNumero == 5 || nuevoNumero == 6 || nuevoNumero == 8 || nuevoNumero == 9))) {
            return false;
        } else if (anteriorNumero == 2 && ((nuevoNumero == 2 || nuevoNumero == 4 || nuevoNumero == 7 || nuevoNumero == 6 || nuevoNumero == 9))) {
            return false;
        } else if (anteriorNumero == 3 && ((nuevoNumero == 3 || nuevoNumero == 5 || nuevoNumero == 8 || nuevoNumero == 4 || nuevoNumero == 7))) {
            return false;
        } else if (anteriorNumero == 4 && ((nuevoNumero == 4 || nuevoNumero == 8 || nuevoNumero == 9 || nuevoNumero == 2 || nuevoNumero == 3))) {
            return false;
        } else if (anteriorNumero == 5 && ((nuevoNumero == 5 || nuevoNumero == 1 || nuevoNumero == 3 || nuevoNumero == 7 || nuevoNumero == 9))) {
            return false;
        } else if (anteriorNumero == 6 && ((nuevoNumero == 6 || nuevoNumero == 1 || nuevoNumero == 2 || nuevoNumero == 7 || nuevoNumero == 8))) {
            return false;
        } else if (anteriorNumero == 7 && ((nuevoNumero == 7 || nuevoNumero == 2 || nuevoNumero == 3 || nuevoNumero == 5 || nuevoNumero == 6))) {
            return false;
        } else if (anteriorNumero == 8 && ((nuevoNumero == 8 || nuevoNumero == 1 || nuevoNumero == 3 || nuevoNumero == 4 || nuevoNumero == 6))) {
            return false;
        } else if (anteriorNumero == 9 && ((nuevoNumero == 9 || nuevoNumero == 1 || nuevoNumero == 2 || nuevoNumero == 4 || nuevoNumero == 5))) {
            return false;
        }

        return true;

    }


    /**
     * Esta función tiene como único objetivo lanzar un mensaje por pantalla que le diga
     * al usuario que el número introducido no es válido
     */
    public static void mostrarErrorFilasColumnas() {
        System.err.println("Error. El número introducido debe estar en la misma fila" +
                "o columna y no puede ser el número anterior");

    }

    /**
     * Preguntamos al usuario por un número para jugar
     *
     * @return
     */
    public static int introducirNumero(int contadorTotal) {
        int nuevoNumero;

        if (contadorTotal == 0) {
            System.out.println("Por favor, introduce un número entre el 1 y el 9 para jugar: ");

        } else {
            System.out.println("Por favor, introduce un número en la misma fila o columna" +
                    "\nsin ser el mismo número que el anterior introducido.");

        }

        Scanner sc = new Scanner(System.in);
        nuevoNumero = sc.nextInt();

        while (nuevoNumero < 1 || nuevoNumero > 9) {
            System.err.println("El número introducido debe ser un número del 1 al 9");
            nuevoNumero = sc.nextInt();
        }
        return nuevoNumero;


    }

    /**
     * Esta función sirve para calcular a quién le toca en cada turno
     *
     * @param turnoActual Parámetro de entrada que necesita saber cuál es el turno actual.
     * @param nJugadores  Parámetro de entrada que necesita saber cuántos juadores hay en la partida.
     * @return Devuelve un número entero que se traduce en el turno del jugador que le toca jugar.
     */
    public static int comprobarQuienJuega(int turnoActual, int nJugadores) {
        return (turnoActual + 1) % nJugadores;


    }

    /**
     * En esta función lo que se hace es preguntar al usuario cuántos jugadores va a tener la partida
     *
     * @return Devuelve como número entero el número que se introduce al preguntar cuántos jugadores van a jugar.
     */
    public static int preguntarPorJugadores() {
        int numeroJugadores;
        System.out.println("Cuántos jugadores van a jugar: ");
        Scanner sc = new Scanner(System.in);
        numeroJugadores = sc.nextInt();
        return numeroJugadores;
    }

    /**
     * Esta funcion pregunta al usuario al finalizar la partida si quiere jugar otra vez
     * Compara la respuesta dada por el usuario en una String con otra es String.
     *
     * @return Si la comparación da 0 devuelve true. En caso contrario devuelve false.
     */
    public static boolean repetirJuego() {
        String respuestaSi = "Si";
        System.out.println("¿Desea jugar otra partida? Si / No");
        Scanner sc = new Scanner(System.in);
        String respuestaUsuario = sc.next();

        if (respuestaSi.compareToIgnoreCase(respuestaUsuario) == 0) {
            return true;
        }
        return false;


    }
}