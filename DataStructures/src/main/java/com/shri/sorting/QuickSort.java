package com.shri.sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int array[] = {9,3,1,6,7,4,5,8};
		System.out.println("Array : ");
		for(int i: array) {
			System.out.print(" "+i);
		}
		
		qucksort(array,0,array.length-1);
		System.out.println("\n Sorted array is");
		for(int i : array) {
			System.out.print(" "+i);
		}
		
	}
	
	public static void qucksort(int[] array,int start,int end) {
			if(start<end) {
				int pivote = partition(array,start,end);
				qucksort(array,start,pivote-1);
				qucksort(array,pivote+1,end);
			}
	}

	private static int partition(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		
		int pivote = array[end];
		int pIndex = start;
		for(int i=start;i<end;i++) {
			if(array[i] <= pivote) {
			  	swap(array,i,pIndex);
			  	pIndex++;
			}
		}
		swap(array,pIndex,end);
		return pIndex;
	}
	
	private static void swap(int[] array,int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
