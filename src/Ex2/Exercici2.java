package Ex2;

public class Exercici2 implements Runnable {

    private Comptes xobj;

    public Exercici2(Comptes m) {
        xobj=m;
    }

    public void run(){
        int valInicial = 100;
        xobj.setSuma(valInicial);
        xobj.setResta(valInicial);
        System.out.println("Tirada fil " + Thread.currentThread().getName() + ": " + valInicial);
    }

    public static void main(String[] args) throws InterruptedException {
        Comptes ans=new Comptes(0);

        Exercici2 obj1 = new Exercici2(ans);
        Exercici2 obj2 = new Exercici2(ans);

        Thread fil_1 = new Thread(obj1);
        fil_1.setName("Suma");
        Thread fil_2 = new Thread(obj2);
        fil_2.setName("Resta");

        fil_1.start();
        fil_2.start();

         fil_1.join(); //Espera el fil_1 que el fil principal, el que l'ha invocat acabi
         fil_2.join();

        System.out.println("Total tirada: "+ ans.getSuma());
        System.out.println("Final Fil Principal");

    }
}