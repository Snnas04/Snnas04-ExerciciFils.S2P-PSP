package Ex6;

import Ex4.Exercici4;

public class Exercici6 implements Runnable {
    private Random robj;

    public Exercici6(Random n) {
        robj = n;
    }

    public static void main(String[] args) {
        Random num = new Random(10);

        Exercici6 obj1 = new Exercici6(num);
        Exercici6 obj2 = new Exercici6(num);

        Thread fil_1 = new Thread(obj1);
        fil_1.setName("Fil 1");

        Thread fil_2 = new Thread(obj2);
        fil_2.setName("Fil 2");

        fil_1.start();
        fil_2.start();

        try {
            fil_1.join();
            fil_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Fil Principal");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            int resultat = (int) (Math.random() * 10) + 1;
            robj.setNum(resultat);
            System.out.println(Thread.currentThread().getName() + ": ");
        } catch (InterruptedException e) {
        }
    }
}
