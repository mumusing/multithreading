package com.prac.thread.synchronize;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer 
{
	List<Integer> list=new ArrayList<>();
	private int LIMIT=5;
	private int BOTTOM=0;
	private int value=0;
	private Object lock=new Object();
    public void produce() throws InterruptedException
    {
    	
    	synchronized (lock)
    	{
    		while(true)
    		{
			if (LIMIT==list.size())
			{
				System.out.println("Waiting for removing items from list...............");
				lock.wait();
			} 
			else
			{
				 System.out.println("Adding: "+value);
                 list.add(value);
                 value++;
                 lock.notify();
			}
			Thread.sleep(500);
    		}
    	}
    }
    public void consume() throws InterruptedException
    {
    	synchronized (lock)
    	{
			while (true) 
			{
				if (BOTTOM==list.size())
				{
					System.out.println("Waiting for adding items in the list............");
					lock.wait();
				} else
				{
                    System.out.println("Removed: "+list.remove(--value));
                    lock.notify();
				}
				Thread.sleep(500);
			}
		}
    	
    }
    
    
	public void process()
	{
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
