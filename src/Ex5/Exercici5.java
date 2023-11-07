package Ex5;

public class Exercici5 extends Thread {
    private static int n = 4;

    public Exercici5(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Exercici5 obj1 = new Exercici5(n);
        Thread fil_1 = new Thread(obj1);
        Thread fil_2 = new Thread(obj1);

        fil_1.setName("TIC");
        fil_2.setName("TAC");

        fil_1.start();
        fil_2.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            String msg;

            if (Thread.currentThread().getName().equals("TIC")) {
                msg = "TIC";
            } else {
                msg = "TAC";
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }

            System.out.println(msg);
        }
    }
}
