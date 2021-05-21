package UnitTwo;

public class BadSuspend {

    public static Object u = new Object();


    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in " + getName());
                //Thread.currentThread().suspend();
            }
        }
    }
}
