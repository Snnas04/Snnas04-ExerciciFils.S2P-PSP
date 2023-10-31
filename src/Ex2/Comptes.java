package Ex2;

class Comptes {
    private int num;

    public Comptes (int e) {
        num=e;
    }

    public synchronized int getSuma() {
        return num;
    }

    public synchronized void setSuma(int e) {
        num += e;
    }

    public synchronized int getResta() {
        return num;
    }

    public synchronized void setResta(int e) {
        num -= e;
    }
}



