package com.shri.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Program to get the
 */
public class LongestSubstring {

   public static void main(String args[]){

      String str = new String();
      char chr;
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter the string");

      try{
          str = reader.readLine();
      }catch (IOException ioe){
          System.out.println("Input Exception"+ioe);
      }
      System.out.println("Entered string is : "+str);

      Set<Character> charSet = new LinkedHashSet<Character>();
      String outPutString ="";
      for(int i=0;i<str.length();i++){
         int j =i;
         for(;j<str.length();j++){
            chr = str.charAt(j);
            if(charSet.contains((Character) chr )){
               break;
            }else{
               charSet.add((Character) chr);
            }
         }
        if(outPutString.length()<(j-i+1)){
            outPutString = str.substring(i,j);
        }

      }
      System.out.println("Longest Substing is : "+outPutString);
   }

}
