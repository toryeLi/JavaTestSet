package aThread.bSafe.sync;

/**
 * 使用同步快解决线程安全的问题
 */
public class SyncBlock {
    private static  int count=0;
   private  static Object lock=0;
    public static void main(String[] args) {
        Thread thread=new Thread(new MyRunnable());
        Thread thread1=new Thread(new MyRunnable());
        Thread thread2=new Thread(new MyRunnable());
        thread.start();
        thread1.start();
        thread2.start();
        try {
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
    static  class MyRunnable implements  Runnable{
        @Override
        public void run() {
            for (int i=0;i<20000;i++) {
                //synchronized 保证在同一个时间段中不能有其他线程同时执行
                synchronized (lock){
                count++;}
            }
        }
    }
}
