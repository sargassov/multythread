package task_one;

public class WriteThread extends Thread{
    private String text;
    private int abortCounter;
    private Object monitor;

    public WriteThread(String text, Object monitor) {
        this.text = text;
        abortCounter = 6;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            while(abortCounter > 0) {
                System.out.println(text);
                monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                abortCounter--;
            }
        }
    }
}

