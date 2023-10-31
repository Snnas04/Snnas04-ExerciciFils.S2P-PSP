package Ex1;

public class Exercici1 extends Thread {
    public static void main(String[] args) {
        Exercici1 primer = new Exercici1();
        primer.setName("Fil 1");

        Exercici1 segon = new Exercici1();
        segon.setName("Fil 2");

        Exercici1 tercer = new Exercici1();
        tercer.setName("Fil 3");

        Exercici1 quart = new Exercici1();
        quart.setName("Fil 4");

        primer.start();
        segon.start();
        tercer.start();
        quart.start();
    }

    public void run() {
        int rnum = (int) (Math.random() * 99 + 1);

        System.out.println(Thread.currentThread().getName()+ ": iniciat");
        System.out.println(Thread.currentThread().getName()+ ": Valor " + rnum);
        System.out.println(Thread.currentThread().getName()+ ": finalitzat");
    }
}
