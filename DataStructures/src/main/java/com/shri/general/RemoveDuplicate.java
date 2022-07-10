package com.shri.general;

public class RemoveDuplicate {

    public static void main(String args[]){
        int array[]=new int[6];
        array[0]=1;
        array[1]=1;
        array[2]=2;
        array[3]=2;
        array[4]=3;
        array[5]=3;
        System.out.println("Array: ");
        for(int i=0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }

        int i=0;
        for(int j=1;j< array.length;j++){
          if(array[j] !=array[i]){
                i++;
                array[i]=array[j];
          }
        }

        System.out.println("\n Duplicate removed array: ");
        for(i=0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}