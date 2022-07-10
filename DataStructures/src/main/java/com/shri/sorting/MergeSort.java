package com.shri.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {


	public static void main(String args[]) {
		
		int [] array;
		int num = 0;
		System.out.println("Enter the no of items");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			num = Integer.parseInt(br.readLine());
			array = new int[50];
			
			for(int i=0;i<num;i++) {
				array[i]=Integer.parseInt(br.readLine());
			}
			
			System.out.println("Entered list of nnumbers are: ");
			
			for(int i=0;i<num;i++) {
				System.out.print(array[i]);
			}
		}catch(IOException ex) {
			System.out.println("Error while reading the input stream");
		}
		
		
	}
	
}


