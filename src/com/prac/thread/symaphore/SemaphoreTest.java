package com.prac.thread.symaphore;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest
{
    /*
     * Semaphore maintains a set of permit
     * acquire()--- If a permit is available then take it
     * release----- add a permit
     * 
     * semaphore just keeps a  count of number available 
     * 
     * new  Sempaphore(int permits,boolean fair)
     * 
     */
	 
	 enum DOWNLOADER
	 {
		 INSTANCE;
		 private Semaphore semaphore =new Semaphore(5,true);
		 
		 public void downloadDat()
		 {
			 try
			 {
				semaphore.acquire();
				download();
			} 
			 
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally
			 {
				// semaphore.release();
			 }
		 }

		private void download()
		{
			// TODO Auto-generated method stub
			System.out.println("Downloading data from web...............");
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
		ExecutorService exeService=Executors.newCachedThreadPool();
		for (int i = 0; i < 112; i++) 
		{
			exeService.execute(new Runnable() 
			{				
				
				public void run() 
				{
					// TODO Auto-generated method stub
					DOWNLOADER.INSTANCE.download();
				}
			});
		}
		
		
	}
	
}
