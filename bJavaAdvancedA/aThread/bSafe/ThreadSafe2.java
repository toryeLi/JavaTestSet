package aThread.bSafe;

/**
 * 线程安全问题：多线程共享同一个资源导致
 */
public class ThreadSafe2 {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyRunnable());
        Thread thread2=new Thread(new MyRunnable());
        Thread thread3=new Thread(new MyRunnable());
        thread.start();
        thread2.start();
        thread3.start();
        try {
            thread.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }
    private  static  int count=0;
    private  static  class MyRunnable implements  Runnable{
        @Override
        public void run() {
            for (int i=0;i<1234567;i++) {
                count++;
            }
        }
    }
}
