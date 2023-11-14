package Ex6;

import java.util.Random;
import java.util.Scanner;

public class Exercici6 {
    public static void main(String[] args) {
        int totalNumbers = 3;

        RandomNumberThread thread1 = new RandomNumberThread(totalNumbers);
        RandomNumberThread thread2 = new RandomNumberThread(totalNumbers);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona 'q' per interrumpir");

        thread1.start();
        thread1.setName("Fil1");
        thread2.start();
        thread2.setName("Fil2");

        while (thread1.isAlive()) {
            String input = scanner.nextLine();
            if (input.equals("q")) {
                thread1.interrupt();
                thread2.interrupt();
                break;
            }
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado.");
    }
}