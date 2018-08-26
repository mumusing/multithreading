package com.prac.thread.synchronize;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//MultiThreadingSyncronized.process();
		//SynchronizedBlock.process();
		//Threads waitAndNotify=new Threads();
		
		//Wait and Notify
	//	Threads.process();
		
//		//Process Consumer
//		ProducerConsumer procConsum=new ProducerConsumer();
//		procConsum.process();
		
		
//		//Reentrant Lock
//		ReenterantLock relock=new ReenterantLock();
//		ReenterantLock.process();
		
		//Reentrant Lock for producer and consumer
		ProducerConsumerUsingLock pc=new ProducerConsumerUsingLock();
		pc.threads();
	}

}
