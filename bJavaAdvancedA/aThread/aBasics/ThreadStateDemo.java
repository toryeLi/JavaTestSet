package aThread.aBasics;

public class ThreadStateDemo {
    public static void main(String[] args) {
        StateThread st = new StateThread("AAAA");
        st.start();
        try {
            st.join(2000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end~");
    }

    private static class StateThread extends Thread {
        public StateThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行内容");
            }

        }
    }
}
