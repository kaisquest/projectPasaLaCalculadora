import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        preguntarUsuarioPorRango();



    }

    public static int preguntarUsuarioPorRango() {
        //Preguntamos al usuario por el número con el que vamos a jugar
        System.out.println("Introduce un número mayor que 10 y menor que 99 para jugar." +
                "\nSi introduces -1 el número generado es aleatorio");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == -1) {
            number = (int) (Math.random() * 90 + 10);
            System.out.println(number);
            return number;
        } else {
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

}