package com.prac.thread.parallel.algo;

import java.util.Random;

public class App {

	public static Random random=new Random();
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        int numberOfProcessor=Runtime.getRuntime().availableProcessors();
        int[] arr= {7,4,-1,10,-7};
        MergeSort mergeSort=new MergeSort(arr);

        
        mergeSort.parallelMergeSort(0, arr.length-1, numberOfProcessor);
       // mergeSort.show();
//        int[] array=createRandomArray();
//        MergeSort mergeSort=new MergeSort(array);
//        long startTime=System.currentTimeMillis();
//        mergeSort.mergeSortParallel(0, array.length-1, numberOfProcessor);
//        mergeSort.show();
//        long endTime=System.currentTimeMillis();
//        System.out.printf("Time Taken for 100000000 element sorting in Parallel: ", endTime - startTime);
//        
//        startTime=System.currentTimeMillis();
//        mergeSort.sort();
//        endTime=System.currentTimeMillis();
//        System.out.printf("Time Taken for 100000000 element sorting in Sequential: ", endTime - startTime);

	}
    public static int[] createRandomArray()
    {
    	int[] arr=new int[100000000];
    	for (int i = 0; i < 100000000; i++)
    	{
			arr[i]=random.nextInt();
		}
    	return arr;
    }
}
