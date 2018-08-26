package com.prac.thread.symaphore;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
	     * Semaphore maintains a set of permit
	     * acquire()--- If a permit is available then take it
	     * release----- add a permit
	     * 
	     * semaphore just keeps a  count of number available 
	     * 
	     * new  Sempaphore(int permits,boolean fair)
	     * 
	     */
		
//		SemaphoreTest smtest=new SemaphoreTest();
//		smtest.threads();
		
		
//		//Executor service
//		Executor executor=new Executor();
//		executor.threads();
		
		// Callable Future
		CallableFuture.threads();
	}

}
