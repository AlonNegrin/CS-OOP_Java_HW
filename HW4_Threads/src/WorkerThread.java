import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class WorkerThread implements Runnable {
    private final Thread thread;
    private final BlockingQueue<Runnable> taskQueue;
    private final Lock lock;
    private final Condition condition;
    private boolean isStopped;
    private boolean isWorking;

    public WorkerThread(BlockingQueue<Runnable> taskQueue, Lock lock, Condition condition) {
        this.taskQueue = taskQueue;
        this.thread = Thread.currentThread();
        this.lock = lock;
        this.condition = condition;
        this.isStopped = false;
        this.isWorking = false;
    }

    @Override
    public void run() {
        Runnable task;
        while (!isStopped()) {
            lock.lock();
            synchronized (taskQueue) {
                lock.unlock();
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                    }
                }
                isWorking = true;
                task = taskQueue.poll();
            }
            try {
                task.run();
                isWorking = false;
                lock.lock();
                condition.signal();
                lock.unlock();
            } catch (RuntimeException e) {
                System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
            }
        }
    }

    public synchronized void setStopped() {
        isStopped = true;
        thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }

    public boolean isWorking(){
        return  isWorking;
    }
}