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

        while (true) {
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                fil_1.interrupt();
                System.out.println("Fil interrumpit");
                break;
            }
        }
        sc.close();
        System.out.println("Proces finalitzat");
    }

    public void run() {
        int sleepTime = 1500;
        int num1 = 0;
        int num2 = 1;
        int suma = 0;

        System.out.println(1);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }

        while (suma < n) {
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;

            if (suma < n) {
                System.out.println(suma);
            } else {
                System.out.println("Proces finalitzat");
                break;
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
