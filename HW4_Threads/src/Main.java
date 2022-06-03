public class Main {
    public static void main(String[] args) throws InterruptedException {

        Service s = new MyService(5); // create a pool of 5 threads
        for (int j = 0; j < 30; j++) {// generate 30 Runnable
            s.execute(new Runnable() {
                public void run() {
                    long id = Thread.currentThread().getId() -15;
                    System.out.println("Thread: " + id + " task: " + this);
                    for (int i = 0; i < 25000000; i++) {// take some time
                        double d = Math.sin((double) i);
                    }
                    System.out.println("Thread: " + id + " end task");

                }
            });
        }
        s.awaitTermination(); // only if implemented
        System.out.println( "job done" );


        s.shutdown();
        System.out.println("isShutdown() = " + s.isShutdown());

//        s.shutdownNow();
//        System.out.println("Terminated");
    }
}

