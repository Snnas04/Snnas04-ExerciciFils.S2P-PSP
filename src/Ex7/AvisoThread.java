package Ex7;

class AvisoThread extends Thread {
    private CountdownThread countdownThread;

    public AvisoThread(CountdownThread countdownThread) {
        this.countdownThread = countdownThread;
    }

    @Override
    public void run() {
        int tiempoTotal = countdownThread.getTiempoRestante();

        while (countdownThread.getTiempoRestante() >= 0) {
            int tiempoRestante = countdownThread.getTiempoRestante();

            var mitad = tiempoTotal/2;
            var cuarto = (tiempoTotal/4) + 1;
            var tresCuartos = ((tiempoTotal/4)*3) + 1;

            if (tiempoRestante == 0 * tiempoTotal) {
                System.out.println("TIMEOUT");
            }
            else if (tiempoRestante <= cuarto && cuarto - tiempoRestante <= 1 && cuarto - tiempoRestante >= 1) {
                System.out.println("Queda 1/4");
            }
            else if (tiempoRestante == mitad) {
                System.out.println("Queda la mitad");
            }
            else if (tiempoRestante >= tresCuartos && tiempoRestante - tresCuartos <= 1 && tiempoRestante - tresCuartos >= 1) {
                System.out.println("Queda 3/4");
            }
            try {
                sleep(1000); // Simula un segundo de espera
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
