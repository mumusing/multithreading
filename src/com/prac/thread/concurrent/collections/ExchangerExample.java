package com.prac.thread.concurrent.collections;

import java.util.concurrent.Exchanger;

public class ExchangerExample 
{
   /*
    * With the help of Exchanger -> Two Threads can exchange objects
    * 
    * exchange()-> exchanging object is done via one of two exchange() methods
    * 
    * For Example: genetic algorithms, training neural networks
    * 
    * 
    */
	
	class FirstThread implements Runnable
	{
		private Exchanger<Integer>exchanger;
		private int counter;
        public FirstThread(Exchanger<Integer>exchanger) {
			// TODO Auto-generated constructor stub
        	this.exchanger=exchanger;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
			counter=counter+1;
			System.out.println("First Thread inncremented the counter: "+counter);
			
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		}
	}
	
	
	
	class SecondThread implements Runnable
	{
		private Exchanger<Integer>exchanger;
		private int counter;
        public SecondThread(Exchanger<Integer>exchanger) {
			// TODO Auto-generated constructor stub
        	this.exchanger=exchanger;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{				
			counter=counter-21;
			System.out.println("Second Thread decremented the counter: "+counter);
			
			try {
				counter=exchanger.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		}
	}
	
	public void processThread()
	{
		Exchanger<Integer> exchanger=new Exchanger<>();
		new Thread(new FirstThread(exchanger)).start();
		new Thread(new SecondThread(exchanger)).start();
		
	}
	
	
}
