package Ex3;

public class Exercici3_Factorial extends Thread {
    private int number;

    public Exercici3_Factorial(String threadName, int number, int priority) {
        super(threadName);
        this.number = number;
        setPriority(priority);
    }

    @Override
    public void run() {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println(getName() + " - Prioridad " + getPriority() + ": " + factorial);
    }
}
