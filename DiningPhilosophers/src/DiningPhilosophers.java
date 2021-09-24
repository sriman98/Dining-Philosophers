import java.util.Scanner;

public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int num=0;
        System.out.println("Enter the number of philosophers");
        num= Integer.valueOf(new Scanner(System.in).nextLine());

        Philosopher[] philosophers = new Philosopher[num];
         Object[] chopSticks = new Object[philosophers.length];

        for (int i = 0; i < chopSticks.length; i++) {
            chopSticks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length-1; i++) {

            Object leftChopStick = chopSticks[i];
            Object rightChopStick = chopSticks[(i + 1) % chopSticks.length];
            philosophers[i] = new Philosopher(leftChopStick,rightChopStick);
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
        Object leftChopStick = chopSticks[philosophers.length-1];
        Object rightChopStick = chopSticks[0];
        philosophers[philosophers.length-1] = new Philosopher(rightChopStick,leftChopStick);
        Thread t = new Thread(philosophers[philosophers.length-1], "Philosopher " + (philosophers.length));
        t.start();
    }
}
