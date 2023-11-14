package Ex7;

class CountdownThread extends Thread {
    private int tiempoRestante;

    public CountdownThread(int tiempoTotal) {
        this.tiempoRestante = tiempoTotal;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    @Override
    public void run() {
        while (tiempoRestante >= 0) {
            System.out.println(tiempoRestante);
            try {
                sleep(1000); // Simula un segundo de espera
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tiempoRestante--;
        }
    }
}