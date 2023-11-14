package Ex7;

public class Main {
    public static void main(String[] args) {
        int tiempoTotal = 10; // Número de segundos para la cuenta atrás

        CountdownThread countdownThread = new CountdownThread(tiempoTotal);
        AvisoThread avisoThread = new AvisoThread(countdownThread);

        countdownThread.start();
        avisoThread.start();

        try {
            countdownThread.join();
            avisoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}