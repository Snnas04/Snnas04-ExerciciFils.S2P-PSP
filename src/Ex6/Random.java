package Ex6;

public class Random {
    int num;

    public Random(int n) {
        num = n;
    }

    public synchronized void setNum(int n) {
        num = n;
    }
}
