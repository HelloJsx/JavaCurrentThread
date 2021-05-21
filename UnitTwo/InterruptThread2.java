package UnitTwo;

/**
 * 中断处理
 */

public class InterruptThread2 extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
