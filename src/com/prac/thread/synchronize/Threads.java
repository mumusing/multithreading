package com.prac.thread.synchronize;

public class Threads
{
    public static void process()
    {
    	WaitAndNotify waitNotify=new WaitAndNotify();
    	Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					waitNotify.produce();
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
				waitNotify.consumer();
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
