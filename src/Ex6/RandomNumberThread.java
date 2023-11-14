package Ex6;

import java.util.Random;

class RandomNumberThread extends Thread {
    private int totalNumbers;

    public RandomNumberThread(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    public void run() {
        Random random = new Random();

        if (totalNumbers > 0) {
            for (int i = 0; i < totalNumbers && !Thread.interrupted(); i++) {
                int number = random.nextInt(100) + 1;
                System.out.println(getName() + ": " + number);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interromput");
                    return;
                }
            }
        } else {
            while (!Thread.interrupted()) {
                int number = random.nextInt(100) + 1;
                System.out.println(getName() + ": " + number);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interromput");
                    return;
                }
            }
        }
    }
}