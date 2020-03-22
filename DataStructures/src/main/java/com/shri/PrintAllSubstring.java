package com.shri;

public class PrintAllSubstring {

    public static void main(String args[]){
        System.out.println("Welcome to data structure");
        String originalStr = "abcd";
        int length = originalStr.length();
        for(int i=0;i<=length;i++){
            //System.out.println("");
            for(int j=i;j<=length;j++){
              System.out.println(originalStr.substring(i,j));

            }
        }

    }
}

