class Data {
    private int value;
    private int flag;

    public synchronized void set() {
        while(flag > 0)
            try { wait(); } catch (InterruptedException e) {}
        value = (int) (Math.random() * 100);
        System.out.println("Set: " + value);
        flag ++;
        notifyAll();
    }
    public synchronized void get() {
        while(flag == 0 || flag > 2)
            try { wait(); } catch (InterruptedException e) {}
        System.out.println("Get: " + value);

        flag++;
        if(flag == 3)
            flag = 0;
        notify();
    }
}

class Producer extends Thread {
    private Data data;
    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while(true) {
            data.set();
//            try { sleep(1); } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    private Data data;
    public Consumer(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        while(true) {
            data.get();
//            try { sleep(1); } catch (InterruptedException e) {}
        }
    }
}

public class InterComm {
    public static void main(String[] args) {
        Data data = new Data();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        Consumer consumer2 = new Consumer(data);
        producer.start();
        consumer.start();
        consumer2.start();
    }
}
