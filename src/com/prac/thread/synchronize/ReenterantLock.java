package com.prac.thread.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLock 
{
    private static int counter=0;
    private static Lock lock=new ReentrantLock();
	
	public static void increment()
	{
		
		lock.lock();
		
		try {
			for (int i = 0; i < 10000; i++) 
			{
				counter=counter+1;
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
		
	}
	public static void process()
	{
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				increment();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try
		{
			t1.join();
			t2.join();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}
	
}
