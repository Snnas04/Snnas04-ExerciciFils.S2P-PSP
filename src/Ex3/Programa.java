package Ex3;

public class Programa {
    public static void main(String[] args) {
        prueba1();
//        prueba2();
    }

    public static void prueba1() {
        Exercici3_Factorial fil1 = new Exercici3_Factorial("Fil 1", 5, Thread.MIN_PRIORITY);
        Exercici3_Factorial fil2 = new Exercici3_Factorial("Fil 2", 5, Thread.MAX_PRIORITY);

        fil1.start();
        fil2.start();
    }

    public static void prueba2() {
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                Exercici3_Factorial fil = new Exercici3_Factorial("Fil " + i, 5, Thread.MIN_PRIORITY);
                fil.start();
            } else {
                Exercici3_Factorial fil = new Exercici3_Factorial("Fil " + i, 5, Thread.MAX_PRIORITY);
                fil.start();
            }
        }
    }
}
