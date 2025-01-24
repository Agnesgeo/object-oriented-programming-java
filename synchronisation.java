public class practice {
    public static void main(String[] args) {
        Data data = new Data();
        data.N = 10;

        OddNumPrinter odd = new OddNumPrinter(data);
        EvenNumPrinter even = new EvenNumPrinter(data);

        odd.start();
        even.start();

        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Data {
    int counter = 1;
    static int N;
}

class OddNumPrinter extends Thread {
    Data data;

    public OddNumPrinter(Data data) {
        this.data = data;
    }

    public void run() {
        synchronized (data) {
            while (data.counter < Data.N) {
                while (data.counter % 2 == 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(data.counter + " ");
                data.counter++;
                data.notify();
            }
        }
    }
}

class EvenNumPrinter extends Thread {
    Data data;

    public EvenNumPrinter(Data data) {
        this.data = data;
    }

    public void run() {
        synchronized (data) {
            while (data.counter < Data.N) {
                while (data.counter % 2 == 1) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(data.counter + " ");
                data.counter++;
                data.notify();
            }
        }
    }
}
