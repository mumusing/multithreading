package com.prac.thread.multi.run;

public class Runner1 implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Running Thread_"+Thread.currentThread().getName());
		}
	}

}
class Runner2 implements Runnable
{

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++)
		{
			System.out.println("Running Thread_"+Thread.currentThread().getName());
		}
	}
	
}