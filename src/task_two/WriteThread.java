package task_two;

import java.util.concurrent.locks.Lock;

public class WriteThread extends Thread{
    private int abortCounter = 10;
    private Lock lock;
    private Counter counter;

    public WriteThread(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        counter.setCounter(1);
        while (abortCounter > 0){
            abortCounter--;
            System.out.println(Thread.currentThread().getName() + " " + counter.getCounter());
            counter.setCounter(counter.getCounter() + 1);
        }
        lock.unlock();
    }
}

