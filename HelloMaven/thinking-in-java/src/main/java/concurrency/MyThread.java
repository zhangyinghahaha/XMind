package concurrency;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("mythread start...");
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hello.interrupt();
        System.out.println("mythread interrupt hellothread");
        System.out.println("mythread end.");
    }
}
