package aThread.aBasics;

public class TestThreadDemo1 {
    public static void main(String[] args) {
        Thread thread=new Thread(new MyRunnable(),"aaaa");
        Thread thread1=new Thread(new MyRunnable(),"bbbb");
        thread.start();
        thread1.start();
    }
    private  static  class MyRunnable implements  Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+"执行Runnable接口1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行Runnable接口2");
            }
        }
    }
}
