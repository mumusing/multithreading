package com.prac.thread.concurrent.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample 
{
	  /*
     *  BlockingQueue -> An interface that represents a queue that is thread safe
     *                   Put item or take item from it.......
     *                   
     *                   
     *   For Example: one thread putting item into the queue and other thread taking item from it at the same time
     *                We can do it with producer - consumer pattern
     *                
     *                
     *   put() putting item to the queue
     *   take() taking item from the queue
     *                
     *    
     */
    private class Producer implements Runnable
    {   
    	private int counter=0;
        private BlockingQueue<Integer> blockQueue;
		public Producer(BlockingQueue<Integer> blockQueue) 
		{
			this.blockQueue=blockQueue;
		}
		@Override
		public void run()
		{
			while(true)
			{
			try {
				blockQueue.put(counter);
				System.out.println("Putting items into the Queue......."+counter);
				counter++;
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
    	
    }
    
    
    
    private class Consumer implements Runnable
    {  
    	BlockingQueue<Integer> blockQueue;
        public Consumer(BlockingQueue<Integer> blockQueue) 
        {
        	this.blockQueue=blockQueue;
		}
		@Override
		public void run() 
		{
			// TODO Auto-generated method stub
			while (true)
			{
				try 
				{
					int item=blockQueue.take();
					System.out.println("Taking out item...."+item);
					
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		}
    	
    }
    
    public  void process()
    {
    	BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
    	Consumer consumer=new Consumer(queue);
    	Producer producer=new Producer(queue);

    	new Thread(producer).start();
    	new Thread(consumer).start();
    	
    }
	
	
	
	
}
