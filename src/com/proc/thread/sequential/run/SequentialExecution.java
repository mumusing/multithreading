package com.proc.thread.sequential.run;

public class SequentialExecution
{
 class Runner1
 {
	public void run()
	{
		for (int i = 0; i < 7; i++)
		{
			System.out.println("Running runner 1");
		}
	}
 }
 
 class Runner2
 {
	 public void run()
	 {
		 for (int i = 0; i < 7; i++)
		 {
			 System.out.println("Running runner 2");
		 }
	 }
 }
}
