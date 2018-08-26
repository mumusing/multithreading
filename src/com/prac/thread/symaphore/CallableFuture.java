package com.prac.thread.symaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture implements Callable<String>
{
   private int id;
	public CallableFuture(int id)
	{
     this.id=id;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		return id+"";
	}
    
	public static void threads()
	{
		ExecutorService threadPoll=Executors.newFixedThreadPool(2);
		List<Future<String>>list=new ArrayList<>();
		
		for (int i = 0; i < 5; i++)
		{
			Future<String>future=threadPoll.submit(new CallableFuture(i+1));
			list.add(future);
		}
		
		for (Future<String> future : list) 
		{
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		threadPoll.shutdown();
	}
	
	
}
