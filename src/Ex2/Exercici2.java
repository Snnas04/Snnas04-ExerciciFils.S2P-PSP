public class Exercici2 extends Thread {
    private static int[] compte = {1000};

    public static void main(String[] args) {
        Exercici2 filSuma = new Exercici2();
        filSuma.setName("Fil suma");

        Exercici2 filResta = new Exercici2();
        filResta.setName("Fil resta");

        filSuma.start();
        filResta.start();
    }

    public void run() {
        int registre;

        synchronized (compte) {
            System.out.println(getName() + " => compte: " + compte[0]);
            registre = compte[0];

            if (getName().equals("Fil suma")) {
                registre += 10;
            } else if (getName().equals("Fil resta")) {
                registre -= 10;
            }

            System.out.println(getName() + " => registre: " + registre);
            compte[0] = registre;
            System.out.println(getName() + " => compte: " + compte[0]);
        }
    }
}
