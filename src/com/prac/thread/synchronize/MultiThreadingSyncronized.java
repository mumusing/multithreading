package com.prac.thread.synchronize;

public class MultiThreadingSyncronized 
{
    public static int counter=0;
    
    private static synchronized void increment() {
		// TODO Auto-generated method stub
		counter++;
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
    public static void process()
    {
    	Thread t1=new Thread(new Runnable() 
    	{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++)
				{
					increment();
					
				}
			}

			
		});
    	
       Thread t2=new Thread(new Runnable() 
       {
		
		@Override
		public void run() 
		{
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) 
			{
				increment();
			}
		}
	})	;
       t2.start();
       t1.start();
      
       
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
