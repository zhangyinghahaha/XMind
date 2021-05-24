package concurrency;

public class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println("hellothread start...");
        int n = 0;
        while(true) {
            System.out.println(isInterrupted());
            n++;
            System.out.println(n + " hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}
