package com.proc.thread.sequential.run;

import com.proc.thread.sequential.run.SequentialExecution.Runner1;
import com.proc.thread.sequential.run.SequentialExecution.Runner2;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SequentialExecution sq=new SequentialExecution();
        Runner1 r1=sq.new Runner1();
        Runner2 r2=sq.new Runner2();
        r1.run();
        r2.run();
	}

}
