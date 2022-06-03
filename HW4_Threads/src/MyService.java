
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyService implements Service {

    private boolean isShutDown;
    private final List<WorkerThread> threadPool;
    private final BlockingQueue<Runnable> taskQueue;
    private final Lock lock;

    public MyService(int numOfThreads) {
        isShutDown = false;
        threadPool = new ArrayList<>();
        taskQueue = new LinkedBlockingQueue<>();
        lock = new ReentrantLock();

        //init all threads in the pool
        for (int i = 1; i <= numOfThreads; i++) {
            threadPool.add(new WorkerThread(taskQueue, lock));
        }

        //run all threads
        for (WorkerThread thread : threadPool) {
            new Thread(thread).start();
        }
    }

    public List<WorkerThread> getThreadPool() {
        return threadPool;
    }

    @Override
    public void execute(Runnable r) {
        if (!isShutDown) {
            synchronized (taskQueue) {
                taskQueue.add(r);
                taskQueue.notify();
            }
        } else {
            return;
        }
    }


    @Override
    public void awaitTermination() throws InterruptedException {
        lock.lock();

        lock.unlock();
    }

    @Override
    public void shutdown() {
        this.isShutDown = true;
    }

    @Override
    public void shutdownNow() {
        for (WorkerThread thread : threadPool) {
            thread.setStopped();
        }
        this.isShutDown = true;
    }

    @Override
    public boolean isShutdown() {
        return isShutDown;
    }

}
