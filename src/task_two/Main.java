package task_two;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
//    2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
    public static void main(String[] args) {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        WriteThread t1 = new WriteThread(counter, lock);
        WriteThread t2 = new WriteThread(counter, lock);
        WriteThread t3 = new WriteThread(counter, lock);
        t1.start();
        t2.start();
        t3.start();
    }
}
