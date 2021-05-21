package UnitTwo;

/**
 * Thread.sleep()方法会让当付钱线程休眠若干时间，他会抛出一个InterruptedException中断异常，这个异常不是运行时异常，所以一定要捕获
 * Thread.sleep()方法由于中断而抛出异常，此时，他会清除中断标记，如果不加处理，那么在下一次循环开始时，就无法捕获这个异常
 * 所以在异常处理时，再次设置中断标记位
 */

public class InterruptThread3 extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        };
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
