package com.prac.thread.symaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor implements Runnable
{

	
/*
 * ExecutorService exeService=Executors.newCachedThreadPool();
 *    -Going to return an executor service that can dynamically reuse threads
 *    
 *    - Before starting a job -> It is going to check whether there are any threads that finished the job... reuse them
 *    
 *    - If there are no waiting threads -> it is going to create another one
 *    - good for processor .....effective solution
 *    
 *     2) ExecutorService exeService=Executors.newFixedThreadPool(N);
 *     - Maximize the number of threads
 *     - If we want to start a job -> If all the threads are busy, we have to wait for one to terminate
 *     
 *     
 *     3)  ExecutorService exeService=Executors.newSingleThreadExecutor();
 *        It uses single thread for the job
 *        
 *        execute() -> runnable+callable
 *        submit    -> runnable
 *        
 */
	
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) 
		{
			System.out.println(Thread.currentThread().getName()+"  :  "+i);
		//	System.out.println();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void threads()
	{
		ExecutorService exeService=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) 
    	{
			exeService.submit(new Executor());
		}
		exeService.shutdown();
	}
	
	
	
	
	
	
	
	
}
