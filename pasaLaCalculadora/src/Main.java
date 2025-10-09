import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        comprobarNumeroParaJugar();


    }

    /**
     * En esta función preguntamos al usuario por un número, que va a ser con el que se va a jugar.
     * El número introducido tiene ciertas peculiaridades: debe estar entre 10 o 99.
     * Además, si el usuario introduce la opción -1 se genera un número aleatorio entre 10 y 99.
     *
     * @return
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
            System.out.println(number);
            return number;
        }
        //Aquí comprobamos que el número introducido no sea menor que 10 o mayor que 99
        else {
            while (number < 10 || number > 99) {
                if (number == -1) {
                    number = (int) (Math.random() * 90 + 10);
                    System.out.println(number);
                    return number;
                } else {
                    System.out.println("El número introducido no es válido. Por favor, introduce un número válido");
                    number = sc.nextInt();
                }
            }
        }
        System.out.println(number);
        return number;

    }

    public void comprobarNumeroParaJugar() {
        int nuevoNumero;
        int numeroAnterior;
        int contadorTotal;
        int rangoMaximo = preguntarUsuarioPorRango();
        boolean numberIsValid = true;


        //En turno 1 permitimos cualquier número del 1 al 9

        nuevoNumero = introducirNumero();
        contadorTotal = nuevoNumero;
        numeroAnterior = nuevoNumero;


        while (rangoMaximo > contadorTotal) {
            System.out.println(numeroAnterior);
            nuevoNumero = introducirNumero();
            //Comprobamos que no esté en la misma fila, columna o que no sea el número anterior
            if (numeroAnterior == 1 && ((nuevoNumero == 1 || nuevoNumero == 5 || nuevoNumero == 6 || nuevoNumero == 8 || nuevoNumero == 9))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 2 && ((nuevoNumero == 2 || nuevoNumero == 4 || nuevoNumero == 7 || nuevoNumero == 6 || nuevoNumero == 9))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 3 && ((nuevoNumero == 3 || nuevoNumero == 5 || nuevoNumero == 8 || nuevoNumero == 4 || nuevoNumero == 7))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 4 && ((nuevoNumero == 4 || nuevoNumero == 5 || nuevoNumero == 8 || nuevoNumero == 9 || nuevoNumero == 6))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 5 && ((nuevoNumero == 5 || nuevoNumero == 1 || nuevoNumero == 3 || nuevoNumero == 7 || nuevoNumero == 9))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 6 && ((nuevoNumero == 6 || nuevoNumero == 1 || nuevoNumero == 2 || nuevoNumero == 7 || nuevoNumero == 8))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 7 && ((nuevoNumero == 7 || nuevoNumero == 2 || nuevoNumero == 3 || nuevoNumero == 5 || nuevoNumero == 6))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 8 && ((nuevoNumero == 8 || nuevoNumero == 1 || nuevoNumero == 3 || nuevoNumero == 4 || nuevoNumero == 6))) {
                mostrarErrorFilasColumnas();
            } else if (numeroAnterior == 9 && ((nuevoNumero == 9 || nuevoNumero == 1 || nuevoNumero == 2 || nuevoNumero == 4 || nuevoNumero == 5))) {
                mostrarErrorFilasColumnas();
            } else {
                numeroAnterior = nuevoNumero;
            }

            contadorTotal = nuevoNumero + numeroAnterior;
            System.out.println(contadorTotal);
        }

        //Comprobamos que la suma del nuevo número introducido con el anterior no sea superior al rango del usuario
        contadorTotal = nuevoNumero + numeroAnterior;
        System.out.println(contadorTotal);


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
    public int introducirNumero() {
        int nuevoNumero;
        System.out.println("Por favor, introduce un número entre el 1 y el 9 para jugar  ");
        Scanner sc = new Scanner(System.in);
        nuevoNumero = sc.nextInt();
        if (nuevoNumero < 1 || nuevoNumero > 9) {
            System.err.println("El número introducido debe ser un número del 1 al 9");
            introducirNumero();
        }
        return nuevoNumero;

    }

}