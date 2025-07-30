public class ThreadControl extends Thread {
    @Override
    public void run() {
        String tname =  Thread.currentThread().getName();
        while(true) {
            System.out.println(tname);
            Thread.yield();
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        ThreadControl t1 = new ThreadControl();
        ThreadControl t2 = new ThreadControl();
        t1.setName("Hello");
        t2.setName("World");
        t1.start();
        t2.start();
    }
}
