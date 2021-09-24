
public class Philosopher implements Runnable {

    private final Object leftChopStick;
    private final Object rightChopStick;

    Philosopher(Object left, Object right) {
        this.leftChopStick = left;
        this.rightChopStick = right;
    }

    @Override
    public void run() {
        try {
            while (true)
            {
                System.out.println(Thread.currentThread().getName() + ": Hungry");
                Thread.sleep(((int) (Math.random() * 1000)));
                synchronized (leftChopStick) {
                    System.out.println(Thread.currentThread().getName() + ": Picked left Chopstick");
                    Thread.sleep(((int) (Math.random() * 1000)));
                    synchronized (rightChopStick) {
                        System.out.println(Thread.currentThread().getName() + ": Picked right Chopstick");
                        Thread.sleep(((int) (Math.random() * 1000)));
                        System.out.println(Thread.currentThread().getName() + ": Put down right Chopstick");
                        Thread.sleep(((int) (Math.random() * 1000)));
                    }
                    System.out.println(Thread.currentThread().getName() + ": Put down left Chopstick. Returning to thinking");
                    Thread.sleep(((int) (Math.random() * 1000)));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}