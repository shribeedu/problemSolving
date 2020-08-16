package com.shri.general;

import java.util.HashMap;
import java.util.Map;

/*
 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

public class TwoSum {

	public static void main(String args[]) {
		int array[] = {2,4,3,6,1,9};
		int sum = 11;
		int nums[] = sumOfTwo(array,sum);
		if(nums != null) {
			System.out.println("Index of the sum elements  : "+nums[0] +" and "+nums[1]);
		}else {
			System.out.println("No Pair of elements found");
		}
	}

	private static int[] sumOfTwo(int[] array, int sum) {
		
		Map indexMap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<array.length;i++) {
			int complement = sum - array[i];
			if(indexMap.containsKey(complement)) {
				return new int[] {(int)indexMap.get(complement),i};
			}
			indexMap.put(array[i],i);
		}
		return null;
	}
	
	
}
