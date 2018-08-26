package com.prac.thread.concurrent.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample 
{
    /*
     *  This is an unbound block queue of objects that implement the Delayed interface
     *  
     *  - DelayQueue keeps the elements internally until certain delay has expired
     *  
     *  - An Object can be taken from the queue when its delay has expired
     *  
     *  - We can not put null items into the queue - The queue is sorted so that the
     *    object at the head has a delay that has expired for the longer time
     *    
     *    
     *  -  If no delay has expired, then there is no head element and poll() will return null
     *  
     *    size return the count of both expired and unexpired item !!!!
     *   
     */
	
	public class DelayWorker implements Delayed
	{
        private long duration;
        private String message;
        
        public DelayWorker(String message,long duration) {
			// TODO Auto-generated constructor stub
        	this.message=message;
        	this.duration=System.currentTimeMillis()+duration;
		}
        
		@Override
		public int compareTo(Delayed otherDelayed) {
			// TODO Auto-generated method stub
			
			if (this.duration<((DelayWorker)otherDelayed).getDuration())
			{
				return -1;
			}
			if (this.duration>((DelayWorker)otherDelayed).getDuration())
			{
				return 1;
			}
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			return unit.convert(duration-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}

		public long getDuration() {
			return duration;
		}

		public void setDuration(long duration) {
			this.duration = duration;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.message;
		}
		
	}
	public void delayQueue()
	{
		BlockingQueue<DelayWorker>deleayQueue=new DelayQueue<>();
		
		try {
			deleayQueue.put(new DelayWorker("This is first message.........", 1000));
			deleayQueue.put(new DelayWorker("This is first message.........", 10000));
			deleayQueue.put(new DelayWorker("This is first message.........", 4000));			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (!deleayQueue.isEmpty())
		{
			try {
				System.out.println(deleayQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
