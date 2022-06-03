/**
 * @author Ronny Sivan  (ronny.sivan@gmail.com)
 *
 * @date 15 May 2022
 * 
 */

/**
 * Service - a variant of the standard ExecutorService.
 *
 */
public interface Service
{
   /**
    * execute - run the given Runnable on one of the 
    *           service's threads 
    *
    * @param r - the Runnable to run
    */
   public void execute( Runnable r );
   
   
   /**
    * awaitTermination - block until all requests for 
    *                    execution made so far have completed. 
    *                    If no thread activity, return immediately.
    *
    * @throws InterruptedException
    */
   public void awaitTermination() throws InterruptedException;

   
   /**
    * shutdown - stop accepting new requests for execution 
    *
    */
   public void shutdown();
     
   
   /**
    * shutdownNow - stop accepting new requests and also 
    *               terminate all executing threads.  
    *
    */
   public void shutdownNow();
   
   
   /**
    * isShutdown - return <bold>true</bold> if shutdown() or 
    *              shutdownNow() have been called for this 
    *              service, or <bold>false</bold> otherwise.   
    *
    * @return true if service is shutting down
    */
   public boolean isShutdown();

}