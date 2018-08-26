package com.prac.thread.concurrent.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingPriorityQueue1 
{
    class Producer implements Runnable
    {
        BlockingQueue<Person> queue;
		
		public  Producer(BlockingQueue<Person> queue)
		{
			// TODO Auto-generated method stub
			this.queue=queue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try 
			{
//				queue.put("C");
//				queue.put("A");
//				queue.put("Z");
//				Thread.sleep(1000);
//				queue.put("M");
//				queue.put("G");
//				Thread.sleep(1000);
//				queue.put("R");
				
				
				
				queue.put(new Person("mukesh",27));
				queue.put(new Person("singh",28));
				queue.put(new Person("alok",28));
				queue.put(new Person("ravi",25));
				queue.put(new Person("rudra",20));
				queue.put(new Person("pratap",17));
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
    	
    }
	
	class Consumer implements Runnable
	{
		BlockingQueue<Person> queue;
        public Consumer(BlockingQueue<Person> queue) {
			// TODO Auto-generated constructor stub
        	this.queue=queue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(!queue.isEmpty())
			{
			try {
				Thread.sleep(5000);
				System.out.println(queue.take());
//				System.out.println(queue.take());
//				System.out.println(queue.take());
//				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		
	}
	class Person implements Comparable<Person>
	{
        private String name;
        private int age;
        public Person(String name,int age)
        {
			// TODO Auto-generated constructor stub
        	this.name=name;
        	this.age=age;
		}
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(o.getName());
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name+" : "+this.age;
		}
	}
	public void process()
	{
		BlockingQueue<Person> queue=new PriorityBlockingQueue<>();
		
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
		
		
		
		
	}
	
	
}
