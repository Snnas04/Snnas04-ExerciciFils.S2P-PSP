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

            if (tiempoRestante < tiempoTotal/4) {
                System.out.println("Queda 3/4");
            } else if (tiempoRestante == tiempoTotal/2) {
                System.out.println("Queda la mitad");
            } else if (tiempoRestante <= tiempoTotal/4) {
                System.out.println("Queda 1/3");
            } else if (tiempoRestante == 0 * tiempoTotal) {
                System.out.println("TIMEOUT");
            }

            try {
                sleep(1000); // Simula un segundo de espera
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
