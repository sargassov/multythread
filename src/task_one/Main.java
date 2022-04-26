package task_one;

public class Main {
//    Реализовать программу, в которой два потока поочередно пишут ping и pong
    public static void main(String[] args) {
        Object monitor = new Object();
        WriteThread thread1 = new WriteThread("ping", monitor);
        WriteThread thread2 = new WriteThread("pong", monitor);
        thread1.start();
        thread2.start();
    }

}
