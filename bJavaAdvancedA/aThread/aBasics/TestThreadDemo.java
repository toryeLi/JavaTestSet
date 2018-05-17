package aThread.aBasics;

/**
 * 一 进程与线程的区别：
 *   进程就是系统中最小执行单元
 *   线程是进程中最小执行单元
 *   进程中执行的功能通过线程来实现
 *   多个线程共享一个进程中所有资源（PC寄存器，上下文，本地栈）
 *  二 线程运行方式：
 *     程序-->创建一个线程-->start-->runnable-->系统调度就行状态中的线程--->running
 *  三 java中怎样创建线程
 *     Thread
 *     Runnable
 * 线程基础：使用线程
 */
public class TestThreadDemo {
    public static void main(String[] args) {
        System.out.println("main thread started");
        //创建两个线程
        GameThread gameThread=new GameThread();
        VoicThread voicThread=new VoicThread();
        gameThread.start();
        voicThread.start();
        try {
            //停止（太暴力，终止过程中会出现数据错误的问题）
            gameThread.join();
            voicThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end");
    }
    /**
     * 游戏线程类
     */
    private static class GameThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                System.out.println("执行打游戏");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class  VoicThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                System.out.println("执行语音通话"+i);
            }
        }
    }

}


