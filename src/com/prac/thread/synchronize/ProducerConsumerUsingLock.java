package com.prac.thread.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock
{
	/*
	 * ReenterantLock
	 * new ReenterantLock(boolean fairnessParameter)
	 * Fairness parameter: if it is set to be true ---> the lonest waiting thread will get the lock
	 * Fairness==false ---> There is no access ordeer
	 * 
	 * 
	 * Important: we have to use try catch block when doing critical section
	 *            that may throw exception
	 *            -we call unlock in finally block
	 * 
	 * 
	 */
	
     private Lock lock=new ReentrantLock();
     private Condition condotion=lock.newCondition();
     
     public void producer() throws InterruptedException
     {
    	 lock.lock();
    	 System.out.println("Producer Method...........");
    	 condotion.await();
    	 System.out.println("Producer Again............");
    	 lock.unlock();
    	 
     }
	 public void consumer()
	 {
		 lock.lock();
		 System.out.println("Consumer Method..........");
		 condotion.signal();
		 System.out.println("Consumer Again...........");
		 lock.unlock();
	 }
	
	 public void threads()
	 {
		 
		 Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producer();
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
				consumer();
			}
		}) ;
		
		
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
