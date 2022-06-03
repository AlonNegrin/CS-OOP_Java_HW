import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public class WorkerThread implements Runnable {
    private final Thread thread;
    private final BlockingQueue<Runnable> taskQueue;
    private boolean isStopped;
    private final Lock lock;

    public WorkerThread(BlockingQueue<Runnable> taskQueue, Lock lock) {
        this.taskQueue = taskQueue;
        this.isStopped = false;
        this.thread = Thread.currentThread();
        this.lock = lock;
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
                task = taskQueue.poll();
            }

            try {
                task.run();
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
}
