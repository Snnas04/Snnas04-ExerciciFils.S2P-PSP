package Ex2;

import java.util.Arrays;

public class Exercici2 extends Thread {
    // queremos que "compte" cambié de valor cada vez que se realiza una operacion, y que el siguiente hilo coja el valor de "compte" que ha dejado el anterior hilo
    private int operacio;
    private int resultat;
    private static int compte = 990;

    public Exercici2(int operacio) {
        this.operacio = operacio;
    }

    public void run() {
        try {
            if (Thread.currentThread().getName().equals("Suma")) {
                resultat = compte + operacio;
                compte = resultat;
                System.out.println("Suma compte: " + resultat);
            } else if (Thread.currentThread().getName().equals("Resta")) {
                resultat = compte - operacio;
                compte = resultat;
                System.out.println("Resta compte: " + resultat);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Exercici2 obj1 = new Exercici2(10);
        Exercici2 obj2 = new Exercici2(20);

        Thread fil_1 = new Thread(obj1);
        fil_1.setName("Suma");

        Thread fil_2 = new Thread(obj2);
        fil_2.setName("Resta");

        fil_1.start();
        fil_2.start();

        fil_1.join();
        fil_2.join();

        System.out.println("Total: " + compte);
        System.out.println("Final Fil Principal");
    }
}