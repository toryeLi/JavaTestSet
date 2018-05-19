package aThread.bSafe;

/**
 * 线程安全问题：多个线程共享一个资源导致
 */
public class ThreadSafe1{
    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable(),"窗口1");
        Thread t2=new Thread(new MyRunnable(),"窗口2");
        Thread t3=new Thread(new MyRunnable(),"窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
private  static class MyRunnable implements  Runnable{
    static int count=10;
    @Override
    public void run() {//
        while (count>=0){
            count--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第"+ count+"号票被"+Thread.currentThread().getName()+"卖出了");
        }
    }
}
}

