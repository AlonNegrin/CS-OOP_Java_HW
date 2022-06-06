import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyService implements Service {

    private boolean isShutDown;
    private final List<WorkerThread> threadPool;
    private final BlockingQueue<Runnable> taskQueue;
    private final Lock lock;
    private final Condition condition;

    public MyService(int numOfThreads) {
        isShutDown = false;
        threadPool = new ArrayList<>();
        taskQueue = new LinkedBlockingQueue<>();
        lock = new ReentrantLock();
        condition = lock.newCondition();

        //init all threads in the pool
        for (int i = 1; i <= numOfThreads; i++) {
            threadPool.add(new WorkerThread(taskQueue, lock,condition));
        }

        //run all threads
        for (WorkerThread thread : threadPool) {
            new Thread(thread).start();
        }
    }


    @Override
    public void execute(Runnable r) {
        if (!isShutDown) {
            synchronized (taskQueue) {
                taskQueue.add(r);
                taskQueue.notify();
            }
        }
    }


    @Override
    public void awaitTermination() throws InterruptedException {
        while (isWorking()){
            lock.lock();
            condition.await();
            lock.unlock();
        }
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
    }

    @Override
    public boolean isShutdown() {
        return isShutDown;
    }

    public boolean isWorking() {
        for (WorkerThread thread : threadPool) {
            if (thread.isWorking()) {
                return true;
            }
        }
        return !taskQueue.isEmpty();
    }

}