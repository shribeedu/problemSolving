package com.shri;
import java.util.*;


class MyCode {

    public void longestConsecutiveNumber() {

        int[] array = {-1,-2,0,1,2,6,10,3,12,20,18,8,9,13,7,11,14};

        Arrays.sort(array);

        System.out.print("SortedArray is : ");
        for (int k=0;k<array.length;k++){
            System.out.print(" "+array[k]);
        }

        int longestCount = 1;
        int currentCount = 1;
        int beginIndex = 0;
        int endIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i-1]) {
                if (array[i] == array[i-1]+1) {
                    currentCount += 1;
                }
                else {
                    if(currentCount>longestCount){
                        longestCount=currentCount;
                        currentCount = 1;
                        beginIndex = i-longestCount;
                        endIndex= i-1;
                    }
                }
            }
        }

        System.out.print("\n\nLongest Sub consecutive array is: ");

        for(int i=beginIndex ;i<=endIndex;i++) {
            System.out.print(" "+array[i]);
        }

    }

    public static void main(String args[]){
        MyCode myCode = new MyCode();
        myCode.longestConsecutiveNumber();
    }
}
