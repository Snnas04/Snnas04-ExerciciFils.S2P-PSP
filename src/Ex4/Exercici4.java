package Ex4;

import java.util.Scanner;

public class Exercici4 extends Thread {
    public static void main(String[] args) {
        Fibonacci(50);
    }

    private final int n;

    public Exercici4(int n) {
        this.n = n;
    }

    public static void Fibonacci(int n) {
        Scanner sc = new Scanner(System.in);

        Exercici4 obj1 = new Exercici4(n);
        Thread fil_1 = new Thread(obj1);
        fil_1.start();

        String exit = sc.nextLine();
        if (exit.equals("exit")) {
            fil_1.interrupt();
            System.out.println("Fil interrumpit");
        }

        sc.close();
    }

    public void run() {
        int num1 = 0;
        int num2 = 1;
        int suma = 0;

        System.out.println(1);

        while (suma < n) {
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
            System.out.println(suma);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Proces finalitzat");
                break;
            }
        }
    }
}
