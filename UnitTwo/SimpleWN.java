package UnitTwo;

/**
 * Object.wait()方法和Thread.sleep()方法都可以让线程等待若干时间，除wait()方法可以被唤醒之外，另一个主要区别就是wait()方法
 * 会释放目标对象的锁，而Thread.sleep()方法不会释放任何资源
 */
public class SimpleWN {
    final static Object object = new Object();

    public static class T1 extends Thread{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T1 start! ");

                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread!");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
