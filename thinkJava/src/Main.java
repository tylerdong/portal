import concurrence.LiftOff;

public class Main {
    public static void main(String[] args) {
        //LiftOff launch = new LiftOff();
        //launch.run();

        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for liftoff");
    }
}
