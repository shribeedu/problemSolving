package com.shri.sorting;

public class HeapSort {

    public void sort(int[] array){
             int n = array.length;
             for(int i = array.length/2-1;i>=0;i--){
                 hepify(array,n,i);
             }

             for(int i=n-1;i>=0;i--){
                 int temp = array[0];
                 array[0]=array[i];
                 array[i]=temp;
                 hepify(array,i,0);
             }

    }

    public void hepify(int[] array,int n, int i){

          int large = i;
          int l = i*2+1;
          int r =i*2+2;
          if(l<n && array[l]>array[large])
              large = l;
          if(r <n && array[r]>array[large])
              large = r;
          if( large !=i ){
               int temp = array[i];
               array[i]=array[large];
               array[large] = temp;
               hepify(array,n,large);
          }

    }

    public static  void main (String args[]){
        int[] array = {5,6,7,13,4,12,1,2};
        int lenth = array.length;
        System.out.println("\nUnsorted array is:");
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }

        HeapSort hs = new HeapSort();
        hs.sort(array);
        System.out.println("\nSorted Array is: ");
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
    }
}
