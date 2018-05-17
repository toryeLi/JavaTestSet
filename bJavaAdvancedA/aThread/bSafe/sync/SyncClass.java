package aThread.bSafe.sync;

/**
 * 使用同步关键字加锁Class对象
 */
public class SyncClass {
   static int count=0;

    public static void main(String[] args) {
        Thread thread=new Thread(new MyRunnable());
        Thread thread2=new Thread(new MyRunnable());
        thread.start();
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
static  class MyRunnable implements  Runnable{
    /**
     * 对count操作的类方法
     */
    public static  synchronized  void addCount(){
        count++;
    }
    @Override
    public void run() {
        for (int i=0;i<20000;i++) {
            addCount(); }
    }
}
}

