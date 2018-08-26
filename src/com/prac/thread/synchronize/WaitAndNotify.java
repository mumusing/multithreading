package com.prac.thread.synchronize;

public class WaitAndNotify
{
	public void produce() throws InterruptedException
    {
    	synchronized (this)
    	{
			System.out.println("We are in produce method.........");
			wait();
			System.out.println("Again producer method............");
    	}
    }
	public void consumer()
	{
		synchronized (this)
		{
		   System.out.println("Consumer method...................");	
		   notify();
		   System.out.println("Finished consumer method...........");
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
