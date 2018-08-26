package com.prac.thread.multi.run;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Runner1 r1=new Runner1();
      //  r1.run();
        
        Runner2 r2=new Runner2();
      //  r2.run();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
               
        try 
        {
        	//Join get use to wait for let until other thread finish there job
			t1.join();
			t2.join();
		} 
        catch (InterruptedException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Wait for finish for second thread");
        
        
	}

}
