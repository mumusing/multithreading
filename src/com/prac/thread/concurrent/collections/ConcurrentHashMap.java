package com.prac.thread.concurrent.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMap 
{

	public class Producer implements Runnable
	{
		ConcurrentMap<String, Integer>concurrentHashMap;
		public Producer(ConcurrentMap<String, Integer>concurrentHashMap)
		{
			// TODO Auto-generated constructor stub
			this.concurrentHashMap=concurrentHashMap;
		}
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			concurrentHashMap.put("A", 1);
			concurrentHashMap.put("Z", 27);
			concurrentHashMap.put("F", 8);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			concurrentHashMap.put("M", 15);
			concurrentHashMap.put("R", 21);
		}
	}
	
	public class Consumer implements Runnable
	{
		ConcurrentMap<String, Integer>concurrentHashMap;
		public Consumer(ConcurrentMap<String, Integer>concurrentHashMap)
		{
			// TODO Auto-generated constructor stub
			this.concurrentHashMap=concurrentHashMap;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(concurrentHashMap.get("A"));
			System.out.println(concurrentHashMap.get("M"));
			System.out.println(concurrentHashMap.get("R"));
			System.out.println(concurrentHashMap.get("b"));
		}
	}
	public void processThread()
	{
		ConcurrentMap<String, Integer>concurrentHashMap=new java.util.concurrent.ConcurrentHashMap<>();
		new Thread(new Producer(concurrentHashMap)).start();
		new Thread(new Consumer(concurrentHashMap)).start();
		
	}
	
	
}
