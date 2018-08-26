package com.prac.thread.synchronize;

public class SynchronizedBlock 
{
    public static int counter1;
    public static int counter2;
    
  private static  Object lock1=new Object();
  private static  Object lock2=new Object();
    public static void add()
    {
    	synchronized (lock1) 
    	{
    		counter1++;
		}
    	
    }
	public static void addAgain()
	{
		synchronized (lock2)
		{
			counter2++;
		}
	}
	public static void compute()
	{
		for (int i = 0; i < 100; i++) 
		{
			add();
			addAgain();
		}
	}
	public static void process()
	{
		Thread t1=new Thread(new Runnable() 
		{			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				compute();		
			}
		});
		
		Thread t2=new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				compute();	
			}
		});
		
		t1.start();
		t2.start();
		
		try 
		{
			t1.join();
			t2.join();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("counter_1: "+counter1+" : "+"counter_2"+" : "+counter2);
	}
	
	
	
}
